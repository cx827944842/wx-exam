package org.guet.exam.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


/**
 * 生成4位不重复字符
 * @author cx
 *
 */
public class DmSequenceUtil {  
	  
    static String bwords[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I",  
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",  
            "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i",  
            "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",  
            "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8",  
            "9" };  
    static Random random = new Random();  
    static int index1 = 0;  
    static int index2 = 0;  
    static int index3 = 0;  
    static int index4 = 0;  
    static boolean isRead = true;  
  
    /** 
     * 支持14776336个不重复4位字符串 2016-3-18 
     *  
     * @return 
     * @throws Exception 
     */  
    public static synchronized String getNoRepeatId() throws Exception {  
        // 判断是否需要读取文件记录  
        if (isRead) {  
            String sequence = read();  
            if (sequence != null && sequence.length() == 4) {  
                index1 = getIndex(String.valueOf(sequence.charAt(0))) + 10;  
                index2 = getIndex(String.valueOf(sequence.charAt(1))) + 10;  
                index3 = getIndex(String.valueOf(sequence.charAt(2))) + 10;  
                index4 = getIndex(String.valueOf(sequence.charAt(3))) + 10;  
            }  
            isRead = false;  
        }  
  
        getRandom();  
        String id = "" + bwords[index1 == 0 ? 0 : index1 - 1]  
                + bwords[index2 == 0 ? 0 : index2 - 1]  
                + bwords[index3 == 0 ? 0 : index3 - 1] + bwords[index4 - 1];  
        write(id);  
        return id;  
  
    }  
  
    private static int getIndex(String word) {  
        for (int i = 0; i < bwords.length; i++) {  
            if (bwords[i].equals(word)) {  
                return i;  
            }  
        }  
        return 0;  
    }  
  
    private static void getRandom() throws Exception {  
        if (index4 < 62) {  
            index4++;  
        } else {  
            index4 = 1;  
            if (index3 < 62) {  
                index3++;  
            } else {  
                index3 = 1;  
                if (index2 < 62) {  
                    index2++;  
                } else {  
                    index2 = 1;  
                    if (index1 < 62) {  
                        index1++;  
                    } else {  
                        throw new Exception("结束");  
                    }  
                }  
            }  
        }  
  
    }  
  
    private static void write(String sequence) throws IOException {  
        File file = new File("sequence.dat");  
        FileWriter fw = new FileWriter(file, false);  
        fw.write(sequence);  
        fw.flush();  
        fw.close();  
    }  
  
    private static String read() throws IOException {  
        String sequence = "";  
        File file = new File("sequence.dat");  
        try {  
            FileReader fr = new FileReader(file);  
            BufferedReader br = new BufferedReader(fr);  
            sequence = br.readLine();  
            br.close();  
            fr.close();  
        } catch (Exception e) {  
            System.err.println("读取文件出错");  
        }  
        return sequence;  
    }  
  
}  