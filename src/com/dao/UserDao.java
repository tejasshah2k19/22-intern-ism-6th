package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.UserBean;
import com.util.DbConnection;

public class UserDao {

	public void insertUser(UserBean userBean) {

		try {
			Connection con = DbConnection.getConnection();

			PreparedStatement pstmt = con.prepareStatement(
					"insert into users (firstname,lastname,email,password,gender) values (?,?,?,?,?)");

			pstmt.setString(1, userBean.getFirstName());
			pstmt.setString(2, userBean.getLastName());
			pstmt.setString(3, userBean.getEmail());
			pstmt.setString(4, userBean.getPassword());
			pstmt.setString(5, userBean.getGender());

			int records = pstmt.executeUpdate();

			System.out.println(records + " inserted...........");
		} catch (Exception e) {
			System.out.println("SMW in insertUser() ");
			e.printStackTrace();
		}

	}
}
