package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.OrderDetailBean;
import com.util.DbConnection;

public class OrderDetailDao {

	public void addOrderDetail(OrderDetailBean orderDetailBean) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con
					.prepareStatement("insert into orderdetails (orderid,productid,price) values (?,?,?)");
			pstmt.setInt(1, orderDetailBean.getOrderId());
			pstmt.setInt(2, orderDetailBean.getProductId());
			pstmt.setInt(3, orderDetailBean.getPrice());

			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SMW OrderDetailDao :: OrderDetailBean");
			e.printStackTrace();
		}
	}
}
