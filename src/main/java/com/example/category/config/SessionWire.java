package com.example.category.config;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SessionWire
{
	@Autowired
	HttpSession httpSession;
	private final static String ID = "ID";
	private final static String ADMIN = "ADMIN";
	public long getId()
	{
		return (long)httpSession.getAttribute(ID);
	}
	public void invaildate()
	{
		httpSession.invalidate();
	}
	public void setId(long id)
	{
		httpSession.setAttribute(ID, id);
	}
	public void setAdmin(boolean bool)
	{
		httpSession.setAttribute(ADMIN, bool);
	}
	public boolean getAdmin()
	{
		return (boolean)httpSession.getAttribute(ADMIN);
	}
}
