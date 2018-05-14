package org.guet.exam.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.controller.command.QuestionCommand;
import org.guet.exam.entity.BankBlankFillingQuestion;
import org.guet.exam.service.BankBlankFillingQuestionService;
import org.guet.exam.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankBlankFillingQuestionServiceImpl extends DaoSupportImpl<BankBlankFillingQuestion>
		implements BankBlankFillingQuestionService {
	@SuppressWarnings("all")
	@Override
	public BankBlankFillingQuestion convert(QuestionCommand command) {
		BankBlankFillingQuestion bankBlankFillingQuestion = new BankBlankFillingQuestion();
		bankBlankFillingQuestion.setContent(command.getContent());
		bankBlankFillingQuestion.setSubject(command.getSubject());
		bankBlankFillingQuestion.setKnowledgePoint(command.getKnowledgePoint());
		bankBlankFillingQuestion.setCreateDate(new Date());
		bankBlankFillingQuestion.setType("判断题");

		// WARNING 利用反射填充答案 真牛儿逼 可能是一段魔法

		String anwsers[] = command.getAnswer().split(" ");
		System.out.println("=========答案个数=========" + anwsers.length);
		try {
			for (int i = 0; i < anwsers.length; i++) {
				String[] anwser = { anwsers[i] };

				if (i > 0) {
					int temp = i + 1;
					BankBlankFillingQuestion.class.getDeclaredMethod("setAnswer" + temp, String.class)
							.invoke(bankBlankFillingQuestion, anwser);
				} else {
					BankBlankFillingQuestion.class.getDeclaredMethod("setAnswer", String.class)
							.invoke(bankBlankFillingQuestion, anwser);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return bankBlankFillingQuestion;
	}

	private enum ImportStringLineTypeForBlank {
		CONTENT, ANSWER, KNOWLEDGE_POINT, SUBJECT
	};// 题干、答案、知识点

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int importBlankFromTxt(File txtFile, String contributor) {
		BufferedReader br = null;
		int cnt = 0;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(txtFile), "UTF-8"));
			String line = "";
			String content = "";// 题干
			String answer = "";// 答案
			String knowledgePoint = "";// 知识点
			String subject = "";// 科目

			ImportStringLineTypeForBlank type = null;

			while ((line = br.readLine()) != null) {
				line = line.replace(" ", "");// 将UTF-8的特殊空格替换掉，编码c2a0
				line = line.replace((char) 65279, ' ');// 对有BOM头的第一行做处理
				line = line.trim();
				if (line.equals("")) {
					continue; // 空行被忽略
				} else if (line.startsWith("######")) {
					if (content == null || content.equals("")) {
						continue; // 每题开始行的######被忽略
					} else {
						System.out.println("题干：" + content);
						System.out.println("答案：" + answer);
						System.out.println("知识点：" + knowledgePoint);
						System.out.println("科目：" + subject);
						System.out.println();

						BankBlankFillingQuestion q = null;
						if (answer != null && !answer.equals("")) {
							if (answer.contains(",")) {
								String[] answers = answer.split(",");
								switch (answers.length) {
								case 2:
									q = new BankBlankFillingQuestion(content, answers[0], answers[1], knowledgePoint,
											subject);
									break;
								case 3:
									q = new BankBlankFillingQuestion(content, answers[0], answers[1], answers[2],
											knowledgePoint, subject);
									break;
								case 4:
									q = new BankBlankFillingQuestion(content, answers[0], answers[1], answers[2],
											answers[3], knowledgePoint, subject);
									break;
								}
							} else {
								q = new BankBlankFillingQuestion(content, answer, knowledgePoint, subject);
							}
						}
						q.setContributor(contributor);

						getSession().save(q);

						content = "";// 题干
						answer = "";// 答案
						knowledgePoint = "";// 知识点
						subject = "";// 科目
						cnt++;
					}
				} else if (line.startsWith("***")) {
					knowledgePoint = line.substring(3).trim();
					type = ImportStringLineTypeForBlank.KNOWLEDGE_POINT;
				} else if (line.startsWith("@@@")) {
					subject = line.substring(3).trim();
					type = ImportStringLineTypeForBlank.SUBJECT;
				} else if (line.startsWith(">>>")) {
					answer = line.substring(3).trim();
					type = ImportStringLineTypeForBlank.ANSWER;
				} else {
					char firstChar = line.charAt(0);
					if (Character.isDigit(firstChar)) {
						content = StringUtil.firstStringLineProcess(line);
						type = ImportStringLineTypeForBlank.CONTENT;
					} else { // 不属于上述任何一种情况，则说明题干、答案、知识点占用了多行的情况。
						// System.out.println("第二行："+line);
						switch (type) {
						case CONTENT:
							content += "\n" + line;
							break;
						case ANSWER:
							answer += "\n" + line;
							break;
						case KNOWLEDGE_POINT:
							knowledgePoint += "\n" + line;
							break;
						case SUBJECT:
							subject += "\n" + line;
							break;
						}
					}
				}
			}

			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("共导入了" + cnt + "道填空题！");
		return cnt;
	}


}
