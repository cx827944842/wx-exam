package org.guet.exam.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author cx
 * 
 */
public class Configuration {

	private static int pageSize = 10;
	private static String imagePath;
	private static String domain;
	private static String wxid;
	static {
		InputStream in = null;
		try {
			
			Properties props = new Properties();
			in = Configuration.class.getClassLoader().getResourceAsStream("default.properties");
			props.load(in);
			
			pageSize = Integer.parseInt(props.getProperty("pageSize"));
			imagePath=props.getProperty("imagePath");
			domain=props.getProperty("domain");
			wxid=props.getProperty("wxid");
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	public static String getWxid() {
		return wxid;
	}

	public static int getPageSize() {
		return pageSize;
	}

	public static void setPageSize(int pageSize) {
		Configuration.pageSize = pageSize;
	}

	public static String getImagePath() {
		return imagePath;
	}

	public static void setImagePath(String imagePath) {
		Configuration.imagePath = imagePath;
	}

	public static String getDomain() {
		return domain;
	}

	
	
}
