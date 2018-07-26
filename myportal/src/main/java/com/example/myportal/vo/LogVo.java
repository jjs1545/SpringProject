package com.example.myportal.vo;

import java.util.Date;

public class LogVo {
	// Fields
	private Integer id;
	private String log;
	private Date createdAt;

	// Constructors
	public LogVo() {
		super();
	}

	public LogVo(Integer id, String log, Date createdAt) {
		super();
		this.id = id;
		this.log = log;
		this.createdAt = createdAt;
	}

	// Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = log;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	// Overrides
	@Override
	public String toString() {
		return "Log [id=" + id + ", log=" + log + ", createdAt=" + createdAt + "]";
	}
}
