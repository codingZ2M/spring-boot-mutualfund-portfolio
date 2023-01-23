package com.codingz2m.springbootmutualfundportfolio.shared;

import com.codingz2m.springbootmutualfundportfolio.repository.MutualFundPortfolio;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SavingsAccountDTO {
	
	private Long id;
	private String holderName;
	private String accountType;
	private double annualPercentageYield;
	private double minimumBalanceToAvailAPY;
	private double minimumBalanceToOpenAccount;
	private double currentValue;
	private MutualFundPortfolio mutualFundPortfolio;
	
}
