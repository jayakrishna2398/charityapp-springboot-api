package com.revature.charityapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.charityapp.model.Users;
@Repository
public interface UserRepository extends JpaRepository<Users,Integer>{
	
	@Query("select u from Users u")
    List<Users> donorlist();
    
    @Query("select d from Users d where d.donorEmailId = :email_id and d.donorPassword = :password")
    Users findByEmailIdAndPassword(@Param("email_id") String name, @Param("password") String password);
}
