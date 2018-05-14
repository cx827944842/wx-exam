package org.guet.exam.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.guet.exam.base.DaoSupportImpl;
import org.guet.exam.entity.BankBlankFillingQuestion;
import org.guet.exam.entity.BankChoiceQuestion;
import org.guet.exam.entity.BankJudgeQuestion;
import org.guet.exam.entity.BankQuestion;
import org.guet.exam.entity.ExcelAble;
import org.guet.exam.service.BankQuestionService;
import org.guet.exam.util.QueryHelper;
import org.guet.exam.util.StringUtil;
import org.hibernate.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankQuetionServiceImpl extends DaoSupportImpl<BankQuestion> implements BankQuestionService {

	@Override
	public BankQuestion getById(Integer id) {
		return (BankQuestion) getSession().get(BankQuestion.class, id);
	}

	/**
	 * 
	 * @param excelFile
	 * @return
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public List<BankQuestion> importBlankFromExel(File excelFile)
			throws FileNotFoundException, IOException {
		// int cnt = 0;
		List<BankQuestion> list = new ArrayList<BankQuestion>();
		// 使用POI解析Excel文件
		XSSFWorkbook book = new XSSFWorkbook(new FileInputStream(excelFile));
		// 根据名称获得指定Sheet对象
		XSSFSheet choiceSheet = book.getSheet("选择题");
		if (choiceSheet != null) {
			System.out.println(choiceSheet.getLastRowNum());
			BankChoiceQuestion choiceQuestion = new BankChoiceQuestion();
			for (Row row : choiceSheet) {
				list.add(choiceQuestion.convert(row));
			}
		}
		XSSFSheet judgeSheet = book.getSheet("判断题");
		if (judgeSheet != null) {
			System.out.println(judgeSheet.getLastRowNum());
			BankJudgeQuestion judgeQuestion = new BankJudgeQuestion();
			for (Row row : judgeSheet) {
				list.add(judgeQuestion.convert(row));
			}
		}
		XSSFSheet fillingSheet = book.getSheet("填空题");
		if (fillingSheet != null) {
			System.out.println(fillingSheet.getLastRowNum());
			BankBlankFillingQuestion fillingQuestion = new BankBlankFillingQuestion();
			for (Row row : fillingSheet) {
				list.add(fillingQuestion.convert(row));
			}
		}

		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BankQuestion> findByCondition(String subject, String knowledgePoints[]) {

		String innerHql = " AND q.id IN (SELECT id FROM BankQuestion b";
		if (knowledgePoints != null && knowledgePoints.length > 0) {
			for (int i = 0; i < knowledgePoints.length; i++) {
				if (i == 0) {
					innerHql += " WHERE ";
				} else {
					innerHql += " OR ";
				}
				innerHql += " lower(b.knowledgePoint) like lower(?) ";
			}
			innerHql += ")";
		} else {
			innerHql = "";
		}

		String hql = "FROM BankQuestion q WHERE lower(q.subject) like lower(?)" + innerHql;

		System.out.println(hql);
		Query query = getSession().createQuery(hql);

		query.setParameter(0, "%" + subject.trim() + "%");
		if (knowledgePoints != null && knowledgePoints.length > 0) {
			int count = 1;
			for (String s : knowledgePoints) {
				query.setParameter(count++, "%" + s.trim() + "%");
			}
			System.out.println(count);
		}
		return query.list();
	}

	/**
	 * 生成自动组卷
	 */
	@Override
	public List<BankQuestion> autoPick(List<BankQuestion> list, int choice, int filling, int judge) {

		List<BankQuestion> result = new ArrayList<>();// 最终返回列表
		List<BankQuestion> choiceList = new ArrayList<>();// 选择题总体
		List<BankQuestion> fillingList = new ArrayList<>();// 填空题
		List<BankQuestion> judgeList = new ArrayList<>();//

		for (BankQuestion b : list) {
			if ("选择题".equals(b.getType()) && choice != 0) {
				choiceList.add(b);
			}
			if ("填空题".equals(b.getType()) && filling != 0) {
				fillingList.add(b);
			}
			if ("判断题".equals(b.getType()) && judge != 0) {
				judgeList.add(b);
			}
		}
		if (choiceList.size() != 0 && choice != 0) {

			int[] choiceNum = StringUtil.randomCommon(0, choiceList.size(), choice);// 生成0-list.size内的choice个不重复的数
			for (int c : choiceNum) {
				result.add(choiceList.get(c));
			}
		}
		if (judgeList.size() != 0 && judge != 0) {

			int[] judgeNum = StringUtil.randomCommon(0, judgeList.size(), judge);
			for (int c : judgeNum) {
				result.add(judgeList.get(c));
			}
		}
		if (fillingList.size() != 0 && filling != 0) {
			int[] fillingNum = StringUtil.randomCommon(0, fillingList.size(), filling);
			for (int c : fillingNum) {
				result.add(fillingList.get(c));
			}

		}

		return result;
	}

}
