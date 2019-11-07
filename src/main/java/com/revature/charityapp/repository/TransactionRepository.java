package com.revature.charityapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



import com.revature.charityapp.model.UsersTransaction;

public interface TransactionRepository extends JpaRepository<UsersTransaction,Integer>{
	/*
	 * @Query(value="select request_type, target_amount," +
	 * " ifnull((select sum(amount_funded) from transaction_details where fund_id = fr.id),0) as fund_raised,"
	 * +
	 * " ( target_amount -( select sum(amount_funded) from transaction_details where fund_id = fr.id)) as fund_p"
	 * + " from fund_request fr",nativeQuery=true)
	 */
    List<UsersTransaction> findAll();
}
