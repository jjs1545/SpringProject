package com.example.myportal.vo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class UserVo {
	// 필드
	private Long no;
	
	@NotEmpty
	@Length(min=2, max=20)
	private String name;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	@Pattern(regexp="^[0-9a-zA-Z]{4,8}$") /*%는 시작 $끝 0~9사이 or a~z or A~Z 4글자~8글자 사이*/
	private String password;
	@NotEmpty
	@Pattern(regexp="^(FEMALE|MALE)$")	/*시작과 끝 사이 FEMALE 혹은 MALE이 들어가야한다*/
	private String gender;
	private String joinDate;
	// getter/setter
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	
	//toString Override
	@Override
	public String toString() {
		return "userVo [no=" + no + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", joinDate=" + joinDate + "]";
	}
	
	
	
}
