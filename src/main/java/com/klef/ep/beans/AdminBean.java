package com.klef.ep.beans;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Tender;
import com.klef.ep.services.AdminService;

@ManagedBean(name = "adminbean",eager = true)
public class AdminBean 
{
	@EJB(lookup = "java:global/SDPProject/AdminServiceImpl!com.klef.ep.services.AdminService")
	AdminService adminService;
	
	private String username;
	private String password;
	
	private int tid;
	private String name;
	private int departmentid;
	private Date opendate;
	private Date deadline;
	private int timeline;
	private String contact;
	private BigDecimal budget;
	
	private List<Tender> tenderlist;
	
	public List<Tender> getTenderlist() {
		
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);
        Admin admin = (Admin) session.getAttribute("admin");
		
		return adminService.viewalltenders(admin.getUsername());
	}
	public void setTenderlist(List<Tender> tenderlist) {
		this.tenderlist = tenderlist;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
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
	
	//For  Debug Purpose
	@Override
	public String toString() {
		return "AdminBean [username=" + getUsername() + ", password=" + getPassword() + "]";
	}
	
	public void validateAdminLogin() throws IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		
		Admin admin = adminService.checkadminlogin(username, password);
		  if(admin!=null){
		     HttpSession session = request.getSession();
		     session.setAttribute("admin", admin);
		     response.sendRedirect("adminhome.jsp");
		 }
		 else {
		    response.sendRedirect("loginfail.jsp");
		 }
	}
	
	public String add() {
		
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(false);
        Admin admin = (Admin) session.getAttribute("admin");
		
		Tender t = new Tender();
		t.setTid(tid);
		t.setName(name);
		t.setDepartmentid(departmentid);
		t.setOpendate(opendate);
		t.setDeadline(deadline);
		t.setTimeline(timeline);
		t.setContact(contact);
		t.setBudget(budget);
		t.setUsername(admin.getUsername());
		
		adminService.addtender(t);
		
		//it will reset the form after redirection
		return "successreg.jsf?faces-redirect=true";
	}
	
public String updatetender() 
{
		Tender tender =adminService.viewtenderbyid(tid);
		if(tender!=null) {
			Tender t =new Tender();
			t.setTid(tid);
			t.setName(name);
			t.setDepartmentid(departmentid);
			t.setOpendate(opendate);
			t.setDeadline(deadline);
			t.setTimeline(timeline);
			t.setContact(contact);
			t.setBudget(budget);
			
			adminService.updatetender(tender);
			return "updatesucess.jsf";
		}else {
			System.out.println("ID  Not Found");
			return "updatefail.jsf";
		}
	}

public String delete(int eid) {
	
	adminService.deletetender(eid);
	
	return "viewalltenders.jsf";
}

	
	
}
