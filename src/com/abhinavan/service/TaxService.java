package com.abhinavan.service;

import java.util.Map;
import java.util.logging.Logger;

public interface TaxService {
	public static final Logger LOGGER = Logger.getLogger("TaxService");
	public Map<String, Double> getTaxSlabes();

	public Double calculateTax(Double totalIncome);
	
	public static Double calculateAmount(Double totalIncome , Double taxPercentage) {
		try {
			return totalIncome*(taxPercentage/100);
		}catch(NullPointerException e) {
			LOGGER.info(e.getMessage());
		}
		return 0.00;
	}
}
