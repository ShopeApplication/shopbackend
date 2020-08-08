package com.nr.shop.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nr.shop.entity.MaleProduct;

@Repository
public interface MaleProductDao extends PagingAndSortingRepository<MaleProduct, Integer>{

	@Transactional
	@Query(value = "SELECT * from male_product WHERE id=:id",nativeQuery = true)
	MaleProduct find(@Param("id") int id);

}
