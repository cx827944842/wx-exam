package org.guet.exam.util;

import java.text.NumberFormat;

/**
 * 字符串操作工具类
 * 
 * @author cx
 *
 */
public class StringUtil {
	/*
	 * 对题干、选项等的第一行，先去掉第一个字符（字母或数字后），如果还有逗号或句号等分隔符，也去掉。
	 */
	public static String firstStringLineProcess(String line) {
		String result = line;
		while (Character.isDigit(result.charAt(0))) {
			result = result.substring(1);
		}

		char firstNoLetterChar = result.charAt(0);
		if (firstNoLetterChar == '.' || firstNoLetterChar == '．' || firstNoLetterChar == '。' || firstNoLetterChar == ','
				|| firstNoLetterChar == '，') {
			result = result.substring(1).trim();
		}
		return result;
	}

	public static String formattedDecimalToPercentage(double decimal) {
		// 获取格式化对象
		NumberFormat nt = NumberFormat.getPercentInstance();
		// 设置百分数精确度2即保留两位小数
		nt.setMinimumFractionDigits(2);
		return nt.format(decimal);
	}
	
	/**
	 * 随机数生成
	 * @param min
	 * @param max
	 * @param n
	 * @return
	 */
	public static int[] randomCommon(int min, int max, int n){  
	    if (n > (max - min + 1) || max < min) {  
	           return null;  
	       }  
	    int[] result = new int[n];  
	    int count = 0;  
	    while(count < n) {  
	        int num = (int) (Math.random() * (max - min)) + min;  
	        boolean flag = true;  
	        for (int j = 0; j < n; j++) {  
	            if(num == result[j]){  
	                flag = false;  
	                break;  
	            }  
	        }  
	        if(flag){  
	            result[count] = num;  
	            count++;  
	        }  
	    }  
	    return result;  
	}

	
}
