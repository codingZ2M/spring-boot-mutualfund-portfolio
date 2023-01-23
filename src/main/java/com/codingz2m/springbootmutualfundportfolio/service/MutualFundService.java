package com.codingz2m.springbootmutualfundportfolio.service;

import java.util.List;
import com.codingz2m.springbootmutualfundportfolio.repository.MutualFund;
import com.codingz2m.springbootmutualfundportfolio.repository.MutualFundPortfolio;
import com.codingz2m.springbootmutualfundportfolio.shared.MutualFundDTO;
import com.codingz2m.springbootmutualfundportfolio.shared.MutualFundPortfolioDTO;

public interface MutualFundService {
	
	MutualFundPortfolio createMutualFundPortfolio(MutualFundPortfolioDTO mutualFundPortfolioDTO);
	
	MutualFund createMutualFund(MutualFundDTO mutualFundDTO);
	
	List<MutualFund> getMutualFundsOfPortfolio(Long mutualFundPortfolioId);
	
	int deleteMutualFundById(Long id);
}	
