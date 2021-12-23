package model;

public class CommentDTO {
	private String c_num;
	private String c_id;
	private String c_content;
	private String c_date;
	private String bnum;
	
	public CommentDTO() {
		// TODO Auto-generated constructor stub
	}

	public CommentDTO(String c_num, String c_id, String c_conent, String c_date, String bnum) {
		super();
		this.c_num = c_num;
		this.c_id = c_id;
		this.c_content = c_conent;
		this.c_date = c_date;
		this.bnum = bnum;
	}

	public String getC_num() {
		return c_num;
	}

	public void setC_num(String c_num) {
		this.c_num = c_num;
	}

	public String getC_id() {
		return c_id;
	}

	public void setC_id(String c_id) {
		this.c_id = c_id;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_conent) {
		this.c_content = c_conent;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public String getBnum() {
		return bnum;
	}

	public void setBnum(String bnum) {
		this.bnum = bnum;
	}

	@Override
	public String toString() {
		return "CommentDTO [c_num=" + c_num + ", c_id=" + c_id + ", c_conent=" + c_content + ", c_date=" + c_date
				+ ", bnum=" + bnum + "]";
	}

	
	
	
}
