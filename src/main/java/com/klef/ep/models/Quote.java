package com.klef.ep.models;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="quote_table")
public class Quote
{
	@Id
	private int qid;
	private String qname;
	@Column(name = "budget")
	private BigDecimal qbudget;
	private int qdepartmentid;
	private String qcontact;
	@Column(name="username",nullable = false)
	private String username;
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getQname() {
		return qname;
	}
	public void setQname(String qname) {
		this.qname = qname;
	}
	public BigDecimal getQbudget() {
		return qbudget;
	}
	public void setQbudget(BigDecimal qbudget) {
		this.qbudget = qbudget;
	}
	public String getQcontact() {
		return qcontact;
	}
	public void setQcontact(String qcontact) {
		this.qcontact = qcontact;
	}
	public int getQdepartmentid() {
		return qdepartmentid;
	}
	public void setQdepartmentid(int qdepartmentid) {
		this.qdepartmentid = qdepartmentid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}