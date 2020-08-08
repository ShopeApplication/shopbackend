package com.nr.shop.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nr.shop.entity.User;

@Repository
public interface UserDao extends PagingAndSortingRepository<User, Integer> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE user SET status=0 where id=:id",nativeQuery = true)
	void delete(@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query(value = "UPDATE user SET status=1 where id=:id",nativeQuery = true)
	void activateUser(@Param("id") int id);
	
	@Transactional
	@Query(value = "SELECT * from user where status=1 and id=:id",nativeQuery = true)
	User findById(@Param("id") int id);

	User findByMobile(String mobile);

	User findByEmail(String email);

}
