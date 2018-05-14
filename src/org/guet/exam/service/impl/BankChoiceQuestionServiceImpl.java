package org.guet.exam.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;

import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.controller.command.QuestionCommand;
import org.guet.exam.entity.BankChoiceQuestion;
import org.guet.exam.service.BankChoiceQuestionService;
import org.guet.exam.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankChoiceQuestionServiceImpl extends DaoSupportImpl<BankChoiceQuestion>
		implements BankChoiceQuestionService {

	@Override
	public BankChoiceQuestion convert(QuestionCommand command) {
		BankChoiceQuestion bankChoiceQuestion = new BankChoiceQuestion();
		bankChoiceQuestion.setContent(command.getContent());
		bankChoiceQuestion.setSubject(command.getSubject());
		bankChoiceQuestion.setKnowledgePoint(command.getKnowledgePoint());
		bankChoiceQuestion.setCreateDate(new Date());
		bankChoiceQuestion.setAnswer(command.getAnswer());
		bankChoiceQuestion.setType("选择题");

		bankChoiceQuestion.setChoiceA(command.getOption1());
		bankChoiceQuestion.setChoiceB(command.getOption2());
		bankChoiceQuestion.setChoiceC(command.getOption3());
		bankChoiceQuestion.setChoiceD(command.getOption4());
		bankChoiceQuestion.setChoiceE(command.getOption5());
		bankChoiceQuestion.setChoiceF(command.getOption6());
		bankChoiceQuestion.setChoiceG(command.getOption7());
		bankChoiceQuestion.setChoiceH(command.getOption8());

		return bankChoiceQuestion;
	}

	private enum ImportStringLineTypeForChoice {
		CONTENT, OPTION_A, OPTION_B, OPTION_C, OPTION_D, OPTION_E, OPTION_F, OPTION_G, OPTION_H, ANSWER, KNOWLEDGE_POINT,SUBJECT
	};// 题干、选项(A~H)、答案、知识点

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public int importChoiceFromTxt(File txtFile,String contributor) {
		BufferedReader br = null;
		int cnt = 0;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(txtFile), "UTF-8"));
			String line = "";
			String content = "";// 题干
			String[] choices = new String[8];// 选项
			String answer = "";// 答案
			String knowledgePoint = "";// 知识点
			String subject = "";// 科目
			ImportStringLineTypeForChoice type = null;

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
						 System.out.println("题干："+content);
						 System.out.println("选项:"+Arrays.toString(choices));
						 System.out.println("答案："+answer);
						 System.out.println("知识点："+knowledgePoint);
						 System.out.println("科目："+subject);
						 System.out.println();

						BankChoiceQuestion q = new BankChoiceQuestion(content, choices[0], choices[1], choices[2],
								choices[3], choices[4], choices[5], choices[6], choices[7], answer, knowledgePoint,subject);
						q.setContributor(contributor);
						
						getSession().save(q);

						content = "";// 题干
						choices = new String[8];// 选项
						answer = "";// 答案
						knowledgePoint = "";// 知识点
						subject="";//科目
						cnt++;
					}
				} else if (line.startsWith("@@@")) {
					subject = line.substring(3).trim();
					type = ImportStringLineTypeForChoice.SUBJECT;
				} else if (line.startsWith("***")) {
					knowledgePoint = line.substring(3).trim();
					type = ImportStringLineTypeForChoice.KNOWLEDGE_POINT;
				} else if (line.startsWith(">>>")) {
					answer = line.substring(3).trim();
					type = ImportStringLineTypeForChoice.ANSWER;
				} else {
					char firstChar = line.charAt(0);
					if (Character.isDigit(firstChar)) {
						content = StringUtil.firstStringLineProcess(line);
						type = ImportStringLineTypeForChoice.CONTENT;
					} else if (Character.isUpperCase(firstChar)) { // 不能用isLetter()，因汉字也会为true
						switch (firstChar) {
						case 'A':
							choices[0] = StringUtil.firstStringLineProcess(line);
							type = ImportStringLineTypeForChoice.OPTION_A;
							break;
						case 'B':
							choices[1] = StringUtil.firstStringLineProcess(line);
							type = ImportStringLineTypeForChoice.OPTION_B;
							break;
						case 'C':
							choices[2] = StringUtil.firstStringLineProcess(line);
							type = ImportStringLineTypeForChoice.OPTION_C;
							break;
						case 'D':
							choices[3] = StringUtil.firstStringLineProcess(line);
							type = ImportStringLineTypeForChoice.OPTION_D;
							break;
						case 'E':
							choices[4] = StringUtil.firstStringLineProcess(line);
							type = ImportStringLineTypeForChoice.OPTION_E;
							break;
						case 'F':
							choices[5] = StringUtil.firstStringLineProcess(line);
							type = ImportStringLineTypeForChoice.OPTION_F;
							break;
						case 'G':
							choices[6] = StringUtil.firstStringLineProcess(line);
							type = ImportStringLineTypeForChoice.OPTION_G;
							break;
						case 'H':
							choices[7] = StringUtil.firstStringLineProcess(line);
							type = ImportStringLineTypeForChoice.OPTION_H;
							break;
						}
					} else { // 不属于上述任何一种情况，则说明题干、选项、答案、知识点占用了多行的情况。
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
						case OPTION_A:
							choices[0] += "\n" + line;
							break;
						case OPTION_B:
							choices[1] += "\n" + line;
							break;
						case OPTION_C:
							choices[2] += "\n" + line;
							break;
						case OPTION_D:
							choices[3] += "\n" + line;
							break;
						case OPTION_E:
							choices[4] += "\n" + line;
							break;
						case OPTION_F:
							choices[5] += "\n" + line;
							break;
						case OPTION_G:
							choices[6] += "\n" + line;
							break;
						case OPTION_H:
							choices[7] += "\n" + line;
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
		System.out.println("共导入了" + cnt + "道选择题！");
		return cnt;
	}
}
