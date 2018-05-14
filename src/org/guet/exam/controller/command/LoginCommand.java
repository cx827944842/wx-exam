package org.guet.exam.controller.command;
/**
 * 登录表单模型
 * @author cx
 *
 */
public class LoginCommand {
	private Long LoginName;
	private String password;
	public Long getLoginName() {
		return LoginName;
	}
	public void setLoginName(Long loginName) {
		LoginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
