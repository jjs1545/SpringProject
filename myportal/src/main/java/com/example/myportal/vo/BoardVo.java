package com.example.myportal.vo;

public class BoardVo {
	//fields
	private Long no;
	private String title;
	private String content;
	private String regDate;
	private Long userNo;
	private String userName;
	
	public BoardVo() {
		
	}
	
	public BoardVo(Long no, String title, String content, String regDate, Long userNo, String userName) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.userNo = userNo;
		this.userName = userName;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
