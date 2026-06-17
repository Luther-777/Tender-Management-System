package com.klef.ep.beans;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import com.klef.ep.models.Company;
import com.klef.ep.models.Quote;
import com.klef.ep.models.Tender;
import com.klef.ep.services.CompanyService;

@ManagedBean(name = "companybean",eager = true)
@MultipartConfig
public class CompanyBean 
{
	@EJB(lookup = "java:global/SDPProject/CompanyServiceImpl!com.klef.ep.services.CompanyService")
	CompanyService companyService;
	
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
	private List<Quote> quotelist;
	
	private int qid;
	private String qname;
	private int qdepartmentid;
	private String qcontact;
	private BigDecimal qbudget;
	
	private int cid;
	private String cname;
	private String dof;
	private String email;
	private String ccontact;
	public String cpassword;
	private Part uploadedImage;
	private Blob imageBytes;
	
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



	public List<Tender> getTenderlist() {
		return companyService.viewalltenders();
	}



	public void setTenderlist(List<Tender> tenderlist) {
		this.tenderlist = tenderlist;
	}



	public List<Quote> getQuotelist() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpSession session = (HttpSession)externalContext.getSession(false);
		
		Company company = (Company) session.getAttribute("company");
		
		return companyService.viewallquotes(company.getCname());
	}



	public void setQuotelist(List<Quote> quotelist) {
		this.quotelist = quotelist;
	}



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



	public int getQdepartmentid() {
		return qdepartmentid;
	}



	public void setQdepartmentid(int qdepartmentid) {
		this.qdepartmentid = qdepartmentid;
	}



	public String getQcontact() {
		return qcontact;
	}



	public void setQcontact(String qcontact) {
		this.qcontact = qcontact;
	}



	public BigDecimal getQbudget() {
		return qbudget;
	}



	public void setQbudget(BigDecimal qbudget) {
		this.qbudget = qbudget;
	}

	public int getCid() {
		return cid;
	}



	public void setCid(int cid) {
		this.cid = cid;
	}



	public String getDof() {
		return dof;
	}



	public void setDof(String dof) {
		this.dof = dof;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getCcontact() {
		return ccontact;
	}



	public void setCcontact(String ccontact) {
		this.ccontact = ccontact;
	}

	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}



	public String getCpassword() {
		return cpassword;
	}



	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public Part getUploadedImage() {
		return uploadedImage;
	}



	public void setUploadedImage(Part uploadedImage) {
		this.uploadedImage = uploadedImage;
	}



	public Blob getImageBytes() {
		return imageBytes;
	}



	public void setImageBytes(Blob imageBytes) {
		this.imageBytes = imageBytes;
	}

	public void validateCompanyLogin() throws IOException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		
		HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();
		
		Company company = companyService.checkcompanylogin(cname, cpassword);
		  if(company!=null){
		     HttpSession session = request.getSession();
		     session.setAttribute("company", company);
		     response.sendRedirect("companyhome.jsp");
		 }
		 else {
		    response.sendRedirect("loginfail.jsp");
		 }
	}
	
	public String addq() {
		Quote t = new Quote();
		t.setQid(qid);
		t.setQname(qname);
		t.setQdepartmentid(qdepartmentid);
		t.setQcontact(qcontact);
		t.setQbudget(qbudget);
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpSession session = (HttpSession)externalContext.getSession(false);
		
		Company company = (Company) session.getAttribute("company");
		
		t.setUsername(company.getCname());
		
		companyService.addquote(t);
		
		//it will reset the form after redirection
		return "successreg.jsf?faces-redirect=true";
	}
	
	public String addcompany() 
	{
		try (InputStream input = uploadedImage.getInputStream())
		{
			byte[] imageByte = toByteArray(input);
            imageBytes = new SerialBlob(imageByte);
            
            Company c = new Company();
    		c.setId(cid);
    		c.setCname(cname);
    		c.setEmail(email);
    		c.setDof(dof);
    		c.setCcontact(ccontact);
    		c.setCpassword(cpassword);
    		c.setImagedata(imageBytes);
    		
    		companyService.addcompany(c);
		} 
		catch (Exception e) 
		{
			e.getMessage();
		}
		
		//it will reset the form after redirection
		return "successreg.jsf?faces-redirect=true";
	}
	
	private byte[] toByteArray(InputStream input) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int n;
        while ((n = input.read(buffer)) != -1) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }
}
