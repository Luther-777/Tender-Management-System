package com.klef.ep.models;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "company_table")
public class Company 
{
	@Id
	@Column(name = "cid")
	private int id;
	@Column(name = "cname",length = 50,nullable = false)
	private String cname;
	@Column(name = "cdof",nullable = false,length = 10)
	private String dof;
	@Column(name = "cemail",nullable = false,length = 50,unique = true)
	private String email;
	@Column(name = "cpassword",nullable = false,length = 50)
	private String cpassword;
	@Column(name = "ccontact",nullable = false,length = 20,unique = true)
	private String ccontact;
	@Lob
	@Column(nullable = false)
	private Blob imagedata;
	
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getCname() 
	{
		return cname;
	}
	public void setCname(String cname) 
	{
		this.cname = cname;
	}
	public String getDof() 
	{
		return dof;
	}
	public void setDof(String dof) 
	{
		this.dof = dof;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	public String getCcontact() {
		return ccontact;
	}
	public void setCcontact(String ccontact) {
		this.ccontact = ccontact;
	}
	public Blob getImagedata() {
		return imagedata;
	}
	public void setImagedata(Blob imagedata) {
		this.imagedata = imagedata;
	}	
	
}
