package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bean.CartBean;
import com.bean.CartProductBean;
import com.util.DbConnection;

public class OrderDao {

	public void placeOrder(int userId) {
		// userid payment paymentStatus status amount
		CartDao cartDao = new CartDao();
		ArrayList<CartProductBean> carts = cartDao.getCartItems(userId);

		int total = 0;
		for (CartProductBean cartProductBean : carts) {
			total = total + cartProductBean.getPrice();
		}

		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"insert into orders (userid,amount,orderstatus,paymentmode,paymentstatus) values (?,?,?,?,?) ",
					Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, userId);
			pstmt.setInt(2, total);
			pstmt.setString(3, "placed");
			pstmt.setString(4, "COD");
			pstmt.setString(5, "pending");

			pstmt.executeUpdate();

			// orderid
			ResultSet rs = pstmt.getGeneratedKeys();

			rs.next();
			int orderId = rs.getInt("orderid");
			System.out.println("orderid ==> " + orderId);


			// orderdetail -> 7 10 [11 22 33 44 55 ]
			
			
			
			// remove all items from cart

		} catch (Exception e) {
			System.out.println("SMW in OrderDao::placeOrder() ");
			e.printStackTrace();
		}

	}
}
