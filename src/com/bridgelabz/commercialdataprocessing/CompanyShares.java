package com.bridgelabz.commercialdataprocessing;

import java.util.Date;

public class CompanyShares 
{
	public String stockSymbol;
	public int numberOfShares;
	public Date dateTimeOfTransaction;
	public double sharePrice;
	
	public CompanyShares(String stockSymbol, int numberOfShares, double price, Date date) 
	{
		super();
		this.stockSymbol = stockSymbol;
		this.numberOfShares = numberOfShares;
		this.sharePrice = price;
		this.dateTimeOfTransaction = date;
	}
	public String getStockSymbol() 
	{
		return stockSymbol;
	}
	public int getNumberOfShares() 
	{
		return numberOfShares;
	}
	public Date getDateTimeOfTransaction() 
	{
		return dateTimeOfTransaction;
	}
	public double getSharePrice() 
	{
		return sharePrice;
	}
	public void setStockSymbol(String stockSymbol) 
	{
		this.stockSymbol = stockSymbol;
	}
	public void setNumberOfShares(int numberOfShares) 
	{
		this.numberOfShares = numberOfShares;
	}
	public void setDateTimeOfTransaction(Date dateTimeOfTransaction) 
	{
		this.dateTimeOfTransaction = dateTimeOfTransaction;
	}
	public void setSharePrice(double sharePrice) 
	{
		this.sharePrice = sharePrice;
	}
	
	@Override
	public String toString() 
	{
		return "CompanyShares [stockSymbol=" + stockSymbol + ", numberOfShares=" + numberOfShares
				+ ", dateTimeOfTransaction=" + dateTimeOfTransaction + ", sharePrice=" + sharePrice + "]";
	}
	
	
}
