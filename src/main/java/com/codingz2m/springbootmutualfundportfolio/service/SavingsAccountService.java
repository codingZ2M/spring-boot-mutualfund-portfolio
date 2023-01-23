package com.codingz2m.springbootmutualfundportfolio.service;

import com.codingz2m.springbootmutualfundportfolio.repository.MutualFundPortfolio;
import com.codingz2m.springbootmutualfundportfolio.repository.SavingsAccount;
import com.codingz2m.springbootmutualfundportfolio.shared.SavingsAccountDTO;

public interface SavingsAccountService {

	SavingsAccount createSavingsAccount(SavingsAccountDTO savingsAccountDTO);
	
	MutualFundPortfolio getMutualFundPortfolioOfSavingsAccount(Long savingsAccountId);
}
