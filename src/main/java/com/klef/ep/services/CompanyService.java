package com.klef.ep.services;

import java.util.List;

import com.klef.ep.models.Company;
import com.klef.ep.models.Quote;
import com.klef.ep.models.Tender;

public interface CompanyService 
{
	public Company checkcompanylogin(String cname,String cpassword);
	public List<Tender> viewalltenders();
	public String addquote(Quote quote);
	public List<Quote> viewallquotes(String username);
	public String addcompany(Company company);
}
