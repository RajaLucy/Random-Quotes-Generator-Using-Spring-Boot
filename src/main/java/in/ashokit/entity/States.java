package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="States")
public class States {
	@Id
	private Integer stateId;
	private String stateName;
	private Integer counId;
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
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	
	
	
	
	public States(Integer stateId,String stateName,Integer counId) {
		
		this.stateId=stateId;
		this.stateName=stateName;
		this.counId=counId;
	}
	
	public States() {
		
	}
	

}
