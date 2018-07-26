package com.example.myportal.vo;

public class GuestbookVo {
	//필드
	private Long no;
	private String name;
	private String password;
	private String content;
	private String regdate;
	
	//생성자
	public GuestbookVo() {
		super();
	}

	public GuestbookVo(Long no, String name, String password, String content, String regdate) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.content = content;
		this.regdate = regdate;
	}
	
	// Getters / Setters
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	// toString Override

	@Override
	public String toString() {
		return "GuestbookVO [no=" + no + ", name=" + name + ", password=" + password + ", content=" + content
				+ ", regdate=" + regdate + "]";
	};
	
	
}
