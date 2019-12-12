package com.abhinavan.main;

import java.util.Scanner;
import java.util.logging.Logger;

import com.abhinavan.service.TaxService;
import com.abhinavan.service.impl.IndianTaxService;
import com.abhinavan.service.impl.IndonesianTaxService;

/*
 * for solving this problem 
 *  - used different country specific classes implementing same interface which will initialize their tax slabs 
 *  - used bridge design pattern as it contains common logic of calculating tax based on amount and tax percentage as parameter
 *  - For implementing bridge , I used default method inside TaxService interface which will calculate tax amount . 
 * */
public class IncomeTaxCalculator {
	public static final Logger LOGGER = Logger.getLogger("IncomeTaxCalculator");

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter total income --");
			Double totalIncome = sc.nextDouble();
			System.out.println("Enter the country");
			String country = sc.next();
			country = country.toLowerCase();
			TaxService taxService;
			switch (country) {
			case "india":
				taxService = new IndianTaxService();
				LOGGER.info("Total Tax Amount in India is " + taxService.calculateTax(totalIncome)+" INR");
				break;
			case "indonesia":
				taxService = new IndonesianTaxService();
				LOGGER.info("Total Tax Amount in Indonesia is " + taxService.calculateTax(totalIncome)+" IDR");
				break;
			default:
				LOGGER.info("This service only calculates tax for India and Indonesia . Thanks for Visiting");

			}
			sc.close();
		} catch (NullPointerException e) {
			LOGGER.info(e.getMessage());
		}

	}
}
