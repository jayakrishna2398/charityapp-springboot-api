package com.revature.charityapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.charityapp.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{
	 @Query("select ad from Admin ad where ad.adminName = :name and ad.adminPassword = :password")
     Admin findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
