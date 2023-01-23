package com.codingz2m.springbootmutualfundportfolio.shared;

import java.util.List;
import java.util.UUID;

import com.codingz2m.springbootmutualfundportfolio.repository.MutualFund;
import com.codingz2m.springbootmutualfundportfolio.repository.SavingsAccount;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MutualFundPortfolioDTO {

	private UUID id;
	private String holderName;
	private double totalInvestedValue;
	
	private double totalCurrentValue;
	private double gainOrLoss; 
	private List<MutualFund> mutualFunds;
	
	private SavingsAccount savingsAccount;
}
