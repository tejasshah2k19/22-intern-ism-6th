package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.CartBean;
import com.bean.CartProductBean;
import com.util.DbConnection;

public class CartDao {

	public void addToCart(CartBean cart) {
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement pstm = con.prepareStatement("insert into carts (userid,productid) values (?,?)");
			pstm.setInt(1, cart.getUserId());
			pstm.setInt(2, cart.getProductId());

			pstm.executeUpdate();// insert update delete
		} catch (Exception e) {
			System.out.println("SMW CartDao::addToCart()");
			e.printStackTrace();
		}
	}

	public ArrayList<CartProductBean> getCartItems(int userId) {
		ArrayList<CartProductBean> carts = new ArrayList<CartProductBean>();

		try {
			Connection con = DbConnection.getConnection(); // db connection
			PreparedStatement pstmt = con.prepareStatement(
					"select p.name , p.price , c.cartid , p.productid , c.userid  from products p,carts c where c.userid = ? and c.productid = p.productid ");
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();// select
			while (rs.next()) {
				CartProductBean cart = new CartProductBean();
				cart.setCartId(rs.getInt("cartid"));
				cart.setProductId(rs.getInt("productid"));
				cart.setUserId(rs.getInt("userid"));
				cart.setName(rs.getString("name"));
				cart.setPrice(rs.getInt("price"));
				carts.add(cart);
			}

		} catch (Exception e) {
			System.out.println("SMW CartDao::getCartItems()");
			e.printStackTrace();
		}

		return carts;
	}

}
