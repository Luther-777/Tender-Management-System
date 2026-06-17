package com.klef.ep.services;

import java.util.List;

import javax.ejb.Remote;

import com.klef.ep.models.Admin;
import com.klef.ep.models.Tender;

@Remote
public interface AdminService
{
	public Admin checkadminlogin(String username,String password);
	public List<Tender> viewalltenders(String username);
	public String addtender(Tender tender);
	public String updatetender(Tender tender);
	public String deletetender(int tid);
	public Tender viewtenderbyid(int tid);
}
