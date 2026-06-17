package com.klef.ep.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Company;
import com.klef.ep.models.Quote;
import com.klef.ep.models.Tender;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CompanyServiceImpl implements CompanyService
{
	//login
	@Override
	public Company checkcompanylogin(String cname, String cpassword) 
	{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdp");
			EntityManager em = emf.createEntityManager();
			
			Query qry = em.createQuery("select c from Company c where c.cname=? and c.cpassword=?");
			qry.setParameter(1, cname);
			qry.setParameter(2, cpassword);
			System.out.println(cname+" "+cpassword);
			
	        Company company = null;
	        
	        if(qry.getResultList().size()>0)
	        {
	        	company = (Company) qry.getSingleResult();
	        }
			em.close();
			emf.close();
			
			return company;
	}

	//view all tenders
	@Override
	public List<Tender> viewalltenders() 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdp");
	    EntityManager em = emf.createEntityManager();
	    
	    Query qry = em.createQuery("select t from Tender t");
	    // e is an alias of Employee Class
	    List<Tender> tenderlist = qry.getResultList();
	    
	    em.close();
	    emf.close();
	      
	    return tenderlist;
	}

	//create quote
	@Override
	public String addquote(Quote quote) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdp");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(quote); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Quote Created Successfully";
	}

	//view all quotes
	@Override
	public List<Quote> viewallquotes(String username) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdp");
	    EntityManager em = emf.createEntityManager();
	    
	    Query qry = em.createQuery("select q from Quote q where username=?");
	    qry.setParameter(1, username);
	    // e is an alias of Employee Class
	    List<Quote> quotelist = qry.getResultList();
	    
	    em.close();
	    emf.close();
	      
	    return quotelist;
	}

	@Override
	public String addcompany(Company company) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdp");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(company); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Company Created Successfully";
	}
	
	
	
}




