package com.dieson.green.pojo;

import java.io.Serializable;
import java.util.Date;

public class LoginToken  implements Serializable{

	/**
     * serialVersionUID
     */
    private static final long serialVersionUID = 6157721973121305916L;
    
    private String token;

    private Employee employee;
	
	private CompanyInfo company;
	
	private Date cacheDate;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

    public CompanyInfo getCompany()
    {
        return company;
    }

    public void setCompany(CompanyInfo company)
    {
        this.company = company;
    }

    public Date getCacheDate()
    {
        return cacheDate;
    }

    public void setCacheDate(Date cacheDate)
    {
        this.cacheDate = cacheDate;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }


}
