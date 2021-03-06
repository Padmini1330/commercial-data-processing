package com.bridgelabz.commercialdataprocessing;

import java.util.Scanner;
import java.util.Date;
import com.bridgelabz.linkedlistproblems.*;
import com.bridgelabz.stackandqueueproblem.*;
import com.bridgelabz.stackandqueueproblem.INode;


public class StockAccount implements StockAccountInterface
{
	MyStack<String> stockPurchased = new MyStack<String>();
	MyStack<String> stockSold = new MyStack<String>();
	MyLinkedList<CompanyShares> list;
	MyQueue<Date> queue =new MyQueue<Date>();
	Double total;
	public StockAccount() 
	{
		list =new MyLinkedList<CompanyShares>();
		total = 0.0;
	}
	public void addCompanyShares() 
	{
		System.out.println("Enter the number of CompanyShares:");
		Scanner scanner = new Scanner(System.in);
		int count = scanner.nextInt();
		for(int i=0;i<count;i++) {
			System.out.println("enter the Stock symbol");
			String symbol = scanner.next();
			System.out.println("Enter the number of shares");
			int numOfShares = scanner.nextInt();
			System.out.println("Enter the price of one share");
			double price = scanner.nextDouble();
			CompanyShares stock = new CompanyShares(symbol,numOfShares,price,new Date());
			MyNode<CompanyShares> node = new MyNode<CompanyShares>(stock);
			list.append(node);

		}
	}

	public double valueOf() 
	{
		MyNode<CompanyShares> temporaryNode = (MyNode<CompanyShares>) list.head;
		while(temporaryNode != null) 
		{
			this.total += ((temporaryNode.getKey().getNumberOfShares())*(temporaryNode.getKey().getSharePrice()));
			temporaryNode = (MyNode<CompanyShares>)temporaryNode.getNext();
			
		}
		System.out.println("Total Share value: "+ total);
		return this.total;
	}

	public void buy(int amount, String symbol)
	{
		MyNode<CompanyShares> temporaryNode = (MyNode<CompanyShares>) list.head;
		while(temporaryNode != null) 
		{
			if(temporaryNode.getKey().getStockSymbol().equals(symbol)) 
			{
				int currentShares = temporaryNode.getKey().getNumberOfShares();
				temporaryNode.getKey().setNumberOfShares(amount+currentShares);
				double value = temporaryNode.getKey().getSharePrice() * (amount+currentShares);
				this.total = value;
				Node<String> str=new Node<String>(symbol);
				stockPurchased.push(str);
				Node<Date> date=new Node<Date>(new Date());
				queue.addRear(date);
				System.out.println(amount+" shares to stockSymbol "+symbol+" is added. Updated value is "+value);
				return;
			}
			temporaryNode = (MyNode<CompanyShares>)temporaryNode.getNext();
		}
		System.out.println("Symbol not found!");
	}

	public void sell(int amount, String symbol) 
	{
		MyNode<CompanyShares> temporaryNode = (MyNode<CompanyShares>) list.head;
		while(temporaryNode != null) 
		{
			if(temporaryNode.getKey().getStockSymbol().equals(symbol)) 
			{
				int currentShares = temporaryNode.getKey().getNumberOfShares();
				if(currentShares-amount < 0) {
					System.out.println("Amount is exceeding the total Share, reduce amount!");
					return;
				}
				temporaryNode.getKey().setNumberOfShares(currentShares-amount);
				double value = temporaryNode.getKey().getSharePrice() * (currentShares-amount);
				this.total = value;
				Node<String> str1=new com.bridgelabz.stackandqueueproblem.Node<String>(symbol);
				stockSold.push((INode) str1);
				Node<Date> date=new Node<Date>(new Date());
				queue.addRear(date);
				System.out.println(amount+" shares of Stock "+symbol+" is sold. Updated value is "+value);
				return;
			}
			temporaryNode = (MyNode<CompanyShares>)temporaryNode.getNext();
		}
		System.out.println("Symbol not found!");
	}
	

	public void printReport() 
	{
		System.out.println("The total value is : "+ this.total);
		System.out.println(" ");
		list.printMyNodes();
	}
	@Override
	public void save(String fileName) {
		
	}
	public void removeCompanyShares(String symbol) 
	{
		Scanner sc = new Scanner(System.in);
		MyNode<CompanyShares> tempNode = (MyNode<CompanyShares>) list.head;
		while(tempNode != null) 
		{
			String currentSymbol = tempNode.getKey().getStockSymbol();
			if(currentSymbol.equals(symbol)) {
				list.delete(tempNode.getKey());
				System.out.println("Deleted Company share: "+tempNode.getKey().getStockSymbol());
				return;
			}
			tempNode = (MyNode<CompanyShares>)tempNode.getNext();
		}
		System.out.println("CompanyShare with symbol "+symbol+" not found!");
		
	}
	public void printStocks() {
		stockPurchased.printMyNodes();
		stockSold.printMyNodes();
		queue.printMyNodes();
		
	}
	
}
