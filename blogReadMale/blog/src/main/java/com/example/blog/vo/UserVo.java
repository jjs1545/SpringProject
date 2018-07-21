package com.example.blog.vo;

public class UserVo {
	private Long no;
	private String id;
	private String name;
	private String password;
	private String regDate;
	
	public UserVo() {
		
	}
	
	public UserVo(Long no, String id, String name, String password, String regDate) {
		super();
		this.no = no;
		this.id = id;
		this.name = name;
		this.password = password;
		this.regDate = regDate;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", name=" + name + ", password=" + password + ", regDate=" + regDate
				+ "]";
	}
	
	
}
