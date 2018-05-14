package org.guet.exam.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * Created by FirenzesEagle on 2016/7/7 0007.
 * Email:liumingbo2008@gmail.com
 */
public class XMLUtil {

    /**
     * 灏嗗井淇℃湇鍔″櫒鍙戦�佺殑Request璇锋眰涓瑽ody鐨刋ML瑙ｆ瀽涓篗ap
     *
     * @param request
     * @return
     * @throws Exception
     */
    public static Map<String, String> parseRequestXmlToMap(HttpServletRequest request) throws Exception {
        // 瑙ｆ瀽缁撴灉瀛樺偍鍦℉ashMap涓�
        Map<String, String> resultMap;
        InputStream inputStream = request.getInputStream();
        resultMap = parseInputStreamToMap(inputStream);
        return resultMap;
    }

    /**
     * 灏嗚緭鍏ユ祦涓殑XML瑙ｆ瀽涓篗ap
     *
     * @param inputStream
     * @return
     * @throws DocumentException
     * @throws IOException
     */
    public static Map<String, String> parseInputStreamToMap(InputStream inputStream) throws DocumentException, IOException {
        // 瑙ｆ瀽缁撴灉瀛樺偍鍦℉ashMap涓�
        Map<String, String> map = new HashMap<String, String>();
        // 璇诲彇杈撳叆娴�
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        //寰楀埌xml鏍瑰厓绱�
        Element root = document.getRootElement();
        // 寰楀埌鏍瑰厓绱犵殑鎵�鏈夊瓙鑺傜偣
        List<Element> elementList = root.elements();
        //閬嶅巻鎵�鏈夊瓙鑺傜偣
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        //閲婃斁璧勬簮
        inputStream.close();
        return map;
    }

    /**
     * 灏哠tring绫诲瀷鐨刋ML瑙ｆ瀽涓篗ap
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static Map<String, String> parseXmlStringToMap(String str) throws Exception {
        Map<String, String> resultMap;
        InputStream inputStream = new ByteArrayInputStream(str.getBytes("UTF-8"));
        resultMap = parseInputStreamToMap(inputStream);
        return resultMap;
    }

}
