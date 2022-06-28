package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ProductBean;
import com.dao.ProductDao;

@WebServlet("/ListProductController")
public class ListProductController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProductDao productDao = new ProductDao();
		ArrayList<ProductBean> products = productDao.getAllProducts();

		request.setAttribute("products", products);
		request.getRequestDispatcher("AllProducts.jsp").forward(request, response);
	}
}
