package in.ashokit.binding;

import org.springframework.stereotype.Component;

@Component
public class ResetPwdForm {

	private String newPass;
	private String conFromPass;
	private Integer userId;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	public String getConFromPass() {
		return conFromPass;
	}
	public void setConFromPass(String conFromPass) {
		this.conFromPass = conFromPass;
	}
	
	
	
	
}
