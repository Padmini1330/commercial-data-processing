package com.bridgelabz.commercialdataprocessing;

import java.util.Scanner;

public class StockAccountMain 
{

	public static void main(String[] args) 
	{
		StockAccount stock = new StockAccount();
		stock.addCompanyShares();
		stock.valueOf();
		Scanner scanner= new Scanner(System.in);
		boolean flag = true;
		while(flag) 
		{
			System.out.println("1:AddCompanyShares 2.RemoveCompanyShares 3.Buy shares 4:Sell shares 5: Print Report 6: Get value  7:exit");
			int option = scanner.nextInt();
			switch(option) {
				case 1: stock.addCompanyShares();
						stock.valueOf();
						break;
						
				case 2: System.out.println("Enter Company name whose share is to be removed:");
						String symbol1=scanner.next();
						stock.removeCompanyShares(symbol1);
						stock.valueOf();
						break;
						
				case 3: System.out.println("enter the stock symbol");
						String symbol = scanner.next();
						System.out.println("enter the Share amount");
						int amount = scanner.nextInt();
						stock.buy(amount, symbol);
						break;
					
				case 4: System.out.println("enter the stock symbol");
						String symbolSell = scanner.next();
						System.out.println("enter the Share amount");
						int amountSell = scanner.nextInt();
						stock.sell(amountSell, symbolSell);
						break;
					
				case 5:	stock.printReport();
						break;
					
				case 6:	System.out.println("The total value of shares : " + stock.valueOf());
						break;
					
				default: flag = false;
				         break;
						
			}
		}

	}

}
