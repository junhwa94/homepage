package model;

public class UserDTO {
	
	private String unum;
	private String uid;
	private String upassword;
	private String uname;
	private String ubirth;
	private String ugender;
	private String uemail;
	private String uphone;
	
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}


	public UserDTO(String uid) {
		this.uid = uid;
	}


	public String getUnum() {
		return unum;
	}


	public void setUnum(String unum) {
		this.unum = unum;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}


	public String getUpassword() {
		return upassword;
	}


	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getUbirth() {
		return ubirth;
	}


	public void setUbirth(String ubirth) {
		this.ubirth = ubirth;
	}


	public String getUgender() {
		return ugender;
	}


	public void setUgender(String ugender) {
		this.ugender = ugender;
	}


	public String getUemail() {
		return uemail;
	}


	public void setUemail(String uemail) {
		this.uemail = uemail;
	}


	public String getUphone() {
		return uphone;
	}


	public void setUphone(String uphone) {
		this.uphone = uphone;
	}


	@Override
	public String toString() {
		return "UserDTO [unum=" + unum + ", uid=" + uid + ", upassword=" + upassword + ", uname=" + uname + ", ubirth="
				+ ubirth + ", ugender=" + ugender + ", uemail=" + uemail + ", uphone=" + uphone + "]";
	}
	
	
	
	
	
	
}
