package model;

public class BoardDTO {
	private String bnum;
	private String bwriter;
	private String bpw;
	private String btitle;
	private String bcontent;
	private String bviews;
	private String breg_date;

	
	public BoardDTO() {
		// TODO Auto-generated constructor stub
	}


	public BoardDTO(String bnum, String bwriter, String bpw, String btitle, String bcontent, String bviews,
			String breg_date) {
		super();
		this.bnum = bnum;
		this.bwriter = bwriter;
		this.bpw = bpw;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bviews = bviews;
		this.breg_date = breg_date;
	}


	public String getBnum() {
		return bnum;
	}


	public void setBnum(String bnum) {
		this.bnum = bnum;
	}


	public String getBwriter() {
		return bwriter;
	}


	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}


	public String getBpw() {
		return bpw;
	}


	public void setBpw(String bpw) {
		this.bpw = bpw;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public String getBviews() {
		return bviews;
	}


	public void setBviews(String bviews) {
		this.bviews = bviews;
	}


	public String getBreg_date() {
		return breg_date;
	}


	public void setBreg_date(String breg_date) {
		this.breg_date = breg_date;
	}


	@Override
	public String toString() {
		return "BoardDTO [bnum=" + bnum + ", bwriter=" + bwriter + ", bpw=" + bpw + ", btitle=" + btitle + ", bcontent="
				+ bcontent + ", bviews=" + bviews + ", breg_date=" + breg_date + "]";
	}

	
	
	
}
