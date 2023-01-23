package com.codingz2m.springbootmutualfundportfolio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MutualFundPortfolioRepository extends CrudRepository<MutualFundPortfolio, Long> {

	// Using Spring Data JPA @Query
	// Custom Queries with @Query Annotation
	// Creating JPA-based repository layer, using Spring Data JPA
	
	 // JPQL Update @Query
    @Modifying
	@Query("UPDATE MutualFundPortfolio mfp SET mfp.totalInvestedValue = :totalInvestedValue WHERE "
	 		                           + "mfp.id = :id")
    int updateMutualFundPortfolio(@Param("id") Long id, @Param("totalInvestedValue") double totalInvestedValue);
	
    @Query("SELECT totalInvestedValue FROM MutualFundPortfolio mfp WHERE mfp.id = :id")
    double getPortfolioTotalInvestedValue(@Param("id") Long  id);
    

}
