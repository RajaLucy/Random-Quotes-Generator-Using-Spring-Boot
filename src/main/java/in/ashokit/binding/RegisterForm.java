package in.ashokit.binding;

import org.springframework.stereotype.Component;

import jakarta.persistence.Id;

@Component
public class RegisterForm {
	
	private Integer userId;
	private String userName;
	private String userMail;
	private String pwd;
	private Integer counId;
	private Integer stateId;
	private Integer cityId;
	private String pwdUpdated;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	
	
	public Integer getCounId() {
		return counId;
	}
	public void setCounId(Integer counId) {
		this.counId = counId;
	}
	public Integer getStateId() {
		return stateId;
	}
	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwdUpdated() {
		return pwdUpdated;
	}
	public void setPwdUpdated(String pwdUpdated) {
		this.pwdUpdated = pwdUpdated;
	}
	
	
}
