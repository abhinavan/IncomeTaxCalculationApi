package com.abhinavan.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import com.abhinavan.service.TaxService;

public class IndianTaxService implements TaxService{

	public static final Logger LOGGER = Logger.getLogger("IndianTaxService");
	@Override
	public Map<String, Double> getTaxSlabes() {
		Map<String, Double> taxSlabs=new HashMap<String, Double>();
		taxSlabs.put("0-2.5L",0.00); 
		taxSlabs.put("2.5L-5L",5.00);
		taxSlabs.put("5L-10L",10.00);
		taxSlabs.put(">10L", 30.00);
		return taxSlabs;
	}

	@Override
	public Double calculateTax(Double totalIncome){
		try {
		
		
		
		
		}catch(Exception e) {e.printStackTrace();}
		
		try {
			InputStream stream=new FileInputStream("src/indianTaxSlab.properties");
			Properties props=new Properties();
			props.load(stream);
			Map<String, Double> taxSlabs=getTaxSlabes();
			Double taxPercentage;
			if(totalIncome<=250000) {
				taxPercentage=taxSlabs.get(props.getProperty("SLAB_1"));
				return TaxService.calculateAmount(totalIncome, taxPercentage);
			}
			if(totalIncome<=500000) {
				taxPercentage=taxSlabs.get(props.getProperty("SLAB_2"));
				return TaxService.calculateAmount(totalIncome, taxPercentage);
			}
			if(totalIncome<=1000000) {
				taxPercentage=taxSlabs.get(props.getProperty("SLAB_3"));
				return TaxService.calculateAmount(totalIncome, taxPercentage);
			}
			taxPercentage=taxSlabs.get(props.getProperty("SLAB_4"));
			return TaxService.calculateAmount(totalIncome, taxPercentage);
		}catch(IOException | NullPointerException e) {
			LOGGER.info(e.getMessage());
		}
		return 0.00;
	}

}
