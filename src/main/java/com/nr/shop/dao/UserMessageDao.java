package com.nr.shop.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nr.shop.entity.UserMessage;

@Repository
public interface UserMessageDao extends PagingAndSortingRepository<UserMessage, Integer> {


}
