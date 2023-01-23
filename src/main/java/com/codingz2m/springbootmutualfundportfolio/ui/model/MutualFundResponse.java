package com.codingz2m.springbootmutualfundportfolio.ui.model;

import com.codingz2m.springbootmutualfundportfolio.repository.MutualFundPortfolio;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MutualFundResponse {
	
	private Long id;
	private String fundName;
	private String schemeType;
	private String fundType;
	
	private float nav;
	private double investedValue;
	private double currentValue;
	private long totalUnits;
	private long freeUnits;

	private long lockedUnits;
	private String investmentDate;
	private String investmentType;
	private String transactionDetails;
	
	private String debitOrCredit;
	private MutualFundPortfolio mutualFundPortfolio;
	
}
