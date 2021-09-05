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
			System.out.println("1:Buy shares   2:Sell shares   3: Print Report  4: Get value  5:exit");
			int option = scanner.nextInt();
			switch(option) {
				case 1:
					System.out.println("enter the stock symbol");
					String symbol = scanner.next();
					System.out.println("enter the Share amount");
					int amount = scanner.nextInt();
					stock.buy(amount, symbol);
					break;
				case 2:
					System.out.println("enter the stock symbol");
					String symbolSell = scanner.next();
					System.out.println("enter the Share amount");
					int amountSell = scanner.nextInt();
					stock.sell(amountSell, symbolSell);
					break;
				case 3:
					stock.printReport();
					break;
				case 4:
					System.out.println("The total value of shares : " + stock.valueOf());
					break;
				default:
					flag = false;
					break;	
			}
		}

	}

}
