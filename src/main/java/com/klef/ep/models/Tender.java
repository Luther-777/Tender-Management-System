package com.klef.ep.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tender_table")
public class Tender implements Serializable
{
	@Id // primary key = unique + key
	private int tid;
	@Column(name="tender_name",nullable=false,length=50)
	private String name;
	@Column(name="tender_dept")
	private int departmentid;
	@Column(name="opendate_tender")
	private Date opendate;
	@Column(name="deadline_tender")
	private Date deadline;
	@Column(name="timeline")
	private int timeline;
	@Column(name="contact",nullable = false,length = 20,unique = true)
	private String contact;
	@Column(name ="budget",nullable = false)
	private BigDecimal budget;
	@Column(name="username",nullable = false)
	private String username;
	
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepartmentid() {
		return departmentid;
	}
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public int getTimeline() {
		return timeline;
	}
	public void setTimeline(int timeline) {
		this.timeline = timeline;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public BigDecimal getBudget() {
		return budget;
	}
	public void setBudget(BigDecimal budget) {
		this.budget = budget;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
