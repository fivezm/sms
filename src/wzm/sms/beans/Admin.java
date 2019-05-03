package wzm.sms.beans;

import java.io.Serializable;

public class Admin implements Serializable {
	private Integer id;
	private String num;
	private String password;
	private String admin_name;
	
	public Admin() {
		super();
	}
	
	public Admin( String num, String password,String admin_name) {
		super();
		this.num = num;
		this.password = password;
		this.admin_name = admin_name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	
	

}
