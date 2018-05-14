package org.guet.exam.controller.command;
/**
 * 消息添加表单模型
 * @author cx
 *
 */

public class MessgeAddCommand {
	private String ekey;
	private String message;
	private String type;
	public String getEkey() {
		return ekey;
	}
	public void setEkey(String ekey) {
		this.ekey = ekey;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

	
}
