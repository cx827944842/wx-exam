package org.guet.exam.entity;

import org.apache.poi.ss.usermodel.Row;
/**
 * 
 * @author cx
 *
 * @param <T>
 */
public interface ExcelAble<T extends BankQuestion> {
	T convert(Row row);
}
