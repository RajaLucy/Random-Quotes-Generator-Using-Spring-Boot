package in.ashokit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Countries")
public class Countries {
	
	@Id
	private Integer counId;
	private String countryName;
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Integer getCounId() {
		return counId;
	}
	public void setCounId(Integer counId) {
		this.counId = counId;
	}
	
	
	public Countries()
	{
		
	}
	
	public Countries(Integer counId,String countryName)
	{
		this.counId=counId;
		this.countryName=countryName;
	}
	
	
	

}
