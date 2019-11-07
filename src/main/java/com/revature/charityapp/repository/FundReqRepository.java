package com.revature.charityapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.revature.charityapp.model.FundRequest;

	@Repository
	public interface FundReqRepository extends JpaRepository<FundRequest,Integer> {
	   
	    
	    @Modifying
	    @Transactional
	    @Query("update FundRequest d set d.amount = :TargetAmount where d.reqType = :ReqType")
	   int update(@Param("ReqType") String reqType,@Param("TargetAmount") Integer amount);
	    
	    @Query("select d from FundRequest d")
	    List<FundRequest> findAll();
	    
	    @Query("select d from FundRequest d where d.reqType = :ReqType")
	    FundRequest findOne(@Param("ReqType") String fundType);
	    
	}

