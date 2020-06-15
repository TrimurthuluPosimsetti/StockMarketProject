package com.mthree.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mthree.dto.OrderDTO;
import com.mthree.models.OrdersDetails;



@Repository
public interface SMRepository extends JpaRepository<OrdersDetails,Integer>{
	
	@Query("select new com.mthree.dto.OrderDTO(o.orderId,o.userId,o.price,o.noofShares,o.companyName,o.buyOrSell) from OrderBookDetails obd join obd.order o on obd.traderName=o.traderName")
	public List<OrderDTO> getOrderBookRepo();
	
	@Query("select new com.mthree.dto.OrderDTO(o.orderId,o.userId,o.price,o.noofShares,o.companyName,o.buyOrSell) from OrderBookDetails obd join obd.order o on obd.traderName=:tn where o.companyName=:cn and o.buyOrSell=:bs")
	public List<OrderDTO> getOrderCompleteBookRepository(@Param("tn") String tn,@Param("cn") String cn,@Param("bs") String bs);

//	@Modifying
//	@Transactional
//	@Query("update OrdersDetails set noOfShares=0,price=0,status=completed where orderId=:oid")
//	public int updateSellDetailsOfSeller(@Param("oid") int oid);
	
}
