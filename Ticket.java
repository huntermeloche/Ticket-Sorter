package com.meloche.ticketsorter;

import java.util.Date;

public class Ticket {

    private int num;
    private String code;
    private int days;
    private int price;
    private String type;
    private Date date;

    public int getNum()
    {
	    return this.num;
    }
    public void setNum(int num)
    {
	    this.num = num;
    }

    public String getCode()
    {
    	return this.code;
    }
    public void setCode(String code)
    {
    	this.code = code;
    }

    public int getDays()
    {
    	return this.days;
    }
    public void setDays(int days)
    {
    	this.days = days;
    }

    public int getPrice()
    {
    	return this.price;
    }
    public void setPrice(int price)
    {
    	this.price = price;
    }

    public String getType()
    {
    	return this.type;
    }
    public void setType(String type)
    {
    	this.type = type;
    }

    public Date getDate()
    {
    	return this.date;
    }
    public void setDate(Date date)
    {
    	this.date = date;
    }

}