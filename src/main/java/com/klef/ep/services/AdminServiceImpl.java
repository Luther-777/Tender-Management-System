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
import com.klef.ep.models.Tender;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AdminServiceImpl implements AdminService
{
	@Override
	public Admin checkadminlogin(String username, String password) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdp");
		EntityManager em = emf.createEntityManager();
		
		// a is an alias of Admin Class
		Query qry = em.createQuery("select a from Admin a where a.username=? and a.password=?  ");
		qry.setParameter(1, username);
		qry.setParameter(2, password);
		
        Admin admin = null;
        
        if(qry.getResultList().size()>0)
        {
        	admin = (Admin) qry.getSingleResult();
        }
		em.close();
		emf.close();
		
		return admin;
	}

	@Override
	public List<Tender> viewalltenders(String username) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdp");
	    EntityManager em = emf.createEntityManager();
	    
	    Query qry = em.createQuery("select t from Tender t where t.username=? ");
	    qry.setParameter(1, username);
	    // e is an alias of Employee Class
	    List<Tender> tenderlist = qry.getResultList();
	    
	    em.close();
	    emf.close();
	      
	    return tenderlist;
	}

	@Override
	public String addtender(Tender tender) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdp");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(tender); 
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Tender Created Successfully";
	}

	@Override
	public String updatetender(Tender tender) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdp");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Tender e = em.find(Tender.class, tender.getTid());
		e.setContact(tender.getContact());
		e.setName(tender.getName());
		e.setBudget(tender.getBudget());
		e.setTimeline(tender.getTimeline());
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
		return "Tender Updated Successfully";
	}

	@Override
	public Tender viewtenderbyid(int tid) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdp");
		EntityManager em = emf.createEntityManager();
		
		Tender t = em.find(Tender.class, tid);
		
		if(t==null)
		{
			em.close();
			emf.close();
			
			return null;
		}
		
		em.close();
		emf.close();
		
		return t;
	}

	@Override
	public String deletetender(int tid) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sdp");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Tender t = em.find(Tender.class, tid);
		em.remove(t);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
		return "Tender Deleted Successfully";
	}
	

}
