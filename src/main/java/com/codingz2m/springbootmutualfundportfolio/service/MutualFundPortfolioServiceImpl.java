package com.codingz2m.springbootmutualfundportfolio.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.codingz2m.springbootmutualfundportfolio.repository.MutualFund;
import com.codingz2m.springbootmutualfundportfolio.repository.MutualFundPortfolio;
import com.codingz2m.springbootmutualfundportfolio.repository.MutualFundPortfolioRepository;
import com.codingz2m.springbootmutualfundportfolio.shared.MutualFundDTO;
import com.codingz2m.springbootmutualfundportfolio.shared.MutualFundPortfolioDTO;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Service (value="mutualFundPortfolio")
@Transactional 
public class MutualFundPortfolioServiceImpl implements MutualFundService {
	
	MutualFundPortfolioRepository  mutualFundPortfolioRepository;	
	ModelMapper modelMapper;

	public MutualFundPortfolioServiceImpl(MutualFundPortfolioRepository mutualFundPortfolioRepository, ModelMapper modelMapper) {
		super();
		this.mutualFundPortfolioRepository = mutualFundPortfolioRepository;
		this.modelMapper= modelMapper;
	}

	@Override
	public MutualFundPortfolio createMutualFundPortfolio(MutualFundPortfolioDTO mutualFundPortfolioDTO) {
		 
		   modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		  
		   MutualFundPortfolio mutualFundPortfolio = modelMapper.map(mutualFundPortfolioDTO, MutualFundPortfolio.class);
		   
		   mutualFundPortfolio =   mutualFundPortfolioRepository.save(mutualFundPortfolio);
		       
		return mutualFundPortfolio;
	}

	@Override
	public List<MutualFund> getMutualFundsOfPortfolio(Long mutualFundPortfolioId) {
	List <MutualFund> mutualFundList = new ArrayList<>();
		
		Optional<MutualFundPortfolio> mutualFundPortfolioOptional = mutualFundPortfolioRepository.findById(mutualFundPortfolioId);
		MutualFundPortfolio mutualFundPortfolioObject = mutualFundPortfolioOptional.get();
			mutualFundList =	mutualFundPortfolioObject.retrieveMutualFunds();
		return mutualFundList;
	}
	
	
	@Override
	public MutualFund createMutualFund(MutualFundDTO mutualFundDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMutualFundById(Long id) {
		return 0;
		
	}

	

	


}
