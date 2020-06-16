package com.mthree.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mthree.dto.AllOrdersDTO;
import com.mthree.dto.OrderDTO;
import com.mthree.dto.SorDTO;
import com.mthree.models.OrdersDetails;



@Repository
public interface SMRepository extends JpaRepository<OrdersDetails,Integer>{
	
	@Query("select new com.mthree.dto.OrderDTO(o.orderId,o.userId,o.price,o.noofShares,o.companyName,o.buyOrSell) from OrderBookDetails obd join obd.order o on obd.traderName=o.traderName")
	public List<OrderDTO> getOrderBookRepo();
	
	@Query("select new com.mthree.dto.OrderDTO(o.orderId,o.userId,o.price,o.noofShares,o.companyName,o.buyOrSell) from OrderBookDetails obd join obd.order o on obd.traderName=:tn where o.companyName=:cn and o.buyOrSell=:bs and o.status=:auc")
	public List<OrderDTO> getOrderCompleteBookRepository(@Param("tn") String tn,@Param("cn") String cn,@Param("bs") String bs,@Param("auc") String auction);

	@Modifying
	@Transactional
	@Query("update OrdersDetails set noofShares=:ns,price=:pri,status=:stat where orderId=:oid")
	public int updateSellDetailsOfSeller(@Param("oid") int oid,@Param("ns") int ns,@Param("pri") float pri,@Param("stat") String stat);
	
	@Query("select e.feeLader from Exchanges e join e.obd o on e.exchangeId=o.exchangeId where o.traderName=:tn")
	public int getFeeInfo(@Param("tn") String tn);
	
	
	@Query("select new com.mthree.dto.SorDTO(o.orderId,o.userId,o.price,o.noofShares,o.companyName,o.buyOrSell,obd.traderName) from Exchanges e join e.obd obd on e.exchangeId=obd.exchangeId join obd.order o on obd.traderName=o.traderName where o.companyName=:cn and o.buyOrSell=:bs and o.status=:auc")
	public List<SorDTO> getAllOrderCompleteBookRepository(@Param("cn") String cn,@Param("bs") String bs,@Param("auc") String auction);

	//select o.order_id,o.user_id,o.price,o.noof_shares,o.company_name,o.buy_or_sell from exchanges e join order_book_details obd on e.exchange_id=obd.exchange_id join orders_details o on obd.trader_name=o.trader_name where o.company_name='google' and o.buy_or_sell='sell'

	@Modifying
	@Transactional
	@Query("update OrdersDetails set noofShares=:ns,price=:pri,status=:stat where orderId=:oid")
	public int updateBuyDetailsOfBuyer(@Param("oid") int oid,@Param("ns") int ns,@Param("pri") float pri,@Param("stat") String stat);
	
	@Query("Select new com.mthree.dto.AllOrdersDTO(o.orderId,o.userId,o.price,o.noofShares,o.companyName,o.buyOrSell, o.status) from OrdersDetails o where o.userId=:userId")
	public List<AllOrdersDTO> getOrdersHistory(@Param("userId") int userId);

	
}
