package org.guet.exam.bean;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.validator.NotNull;
/**
 * 管理员类
 * @author cx
 *
 */
@Entity
public class Admin implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6707764906134172899L;
	@Id
	private Long loginName;
	@NotNull
	private String password;
	private boolean isSuper;//是否是超级管理员 默认不是
	
	public Long getLoginName() {
		return loginName;
	}
	public void setLoginName(Long loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isSuper() {
		return isSuper;
	}
	public void setSuper(boolean isSuper) {
		this.isSuper = isSuper;
	}
	
	
	

}
