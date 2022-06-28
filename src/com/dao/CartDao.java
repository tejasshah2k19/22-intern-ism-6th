package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.CartBean;
import com.util.DbConnection;

public class CartDao {

	public void addToCart(CartBean cart) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("insert into carts (userid,productid) values (?,?)");
			pstm.setInt(1, cart.getUserId());
			pstm.setInt(2, cart.getProductId());

			pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println("SMW CartDao::addToCart()");
			e.printStackTrace();
		}
	}

}
