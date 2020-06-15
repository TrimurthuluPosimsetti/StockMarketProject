package com.mthree.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mthree.dto.OrderDTO;
import com.mthree.models.OrdersDetails;



@Repository
public interface SMRepository extends JpaRepository<OrdersDetails,Integer>{
	
	@Query("select new com.mthree.dto.OrderDTO(o.userId,o.price,o.noofShares,o.companyName,o.buyOrSell) from OrderBookDetails obd join obd.order o on obd.traderName=o.traderName")
	public List<OrderDTO> getOrderBookRepo();
	
	
	
}
