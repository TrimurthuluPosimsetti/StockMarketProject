package com.mthree.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mthree.models.OrderBookDetails;

@Repository
public interface SMRepositoryOBD extends JpaRepository<OrderBookDetails,String> {

	@Query(value="select * from order_book_details where trader_name=?1",nativeQuery=true)
	public OrderBookDetails getOrderBookDetails(String tn);
	
}
