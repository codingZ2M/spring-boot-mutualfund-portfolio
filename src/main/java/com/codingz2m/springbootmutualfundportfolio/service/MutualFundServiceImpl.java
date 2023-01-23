package com.codingz2m.springbootmutualfundportfolio.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingz2m.springbootmutualfundportfolio.repository.MutualFund;
import com.codingz2m.springbootmutualfundportfolio.repository.MutualFundPortfolio;
import com.codingz2m.springbootmutualfundportfolio.repository.MutualFundPortfolioRepository;
import com.codingz2m.springbootmutualfundportfolio.repository.MutualFundRepository;
import com.codingz2m.springbootmutualfundportfolio.shared.MutualFundDTO;
import com.codingz2m.springbootmutualfundportfolio.shared.MutualFundPortfolioDTO;

import jakarta.transaction.Transactional;

@Service(value="mutualFundService")
@Transactional 
public class MutualFundServiceImpl implements MutualFundService {

	MutualFundRepository  mutualFundRepository;
	MutualFundPortfolioRepository mutualFundPortfolioRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public MutualFundServiceImpl(MutualFundRepository mutualFundRepository,
			MutualFundPortfolioRepository mutualFundPortfolioRepository
			) {
		super();
		this.mutualFundRepository = mutualFundRepository;
		this.mutualFundPortfolioRepository = mutualFundPortfolioRepository;
	  }

	
	@Override
	public MutualFund createMutualFund(MutualFundDTO mutualFundDTO) {
		
		 Long mutualFundPortfolioId = mutualFundDTO.getMutualFundPortfolio().getId();
		 
		 double totalInvestedValue = mutualFundPortfolioRepository.getPortfolioTotalInvestedValue(mutualFundPortfolioId);
			double investedValue =  mutualFundDTO.getInvestedValue();
			totalInvestedValue += investedValue;
			 
			  modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
			  
			  // Business / Service Logic.....
			  
			  MutualFund mutualFund = modelMapper.map(mutualFundDTO, MutualFund.class);
			  mutualFund = mutualFundRepository.save(mutualFund);
			  
			  mutualFundPortfolioRepository.updateMutualFundPortfolio(mutualFundPortfolioId, totalInvestedValue);
			  
			return mutualFund;
	}

	
	@Override
	public MutualFundPortfolio createMutualFundPortfolio(MutualFundPortfolioDTO mutualFundPortfolioDTO) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<MutualFund> getMutualFundsOfPortfolio(Long mutualFundPortfolioId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int deleteMutualFundById(Long id) {
		int count = mutualFundRepository.deleteMutualFundById(id);
		return count;
	}

	

}
