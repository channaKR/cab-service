package com.go.cheeta.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.go.cheeta.model.Comment;
import com.go.cheeta.service.CommentService;

public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		if(action.equals("addComment")) {
			addcomment(request,response);
		};
	
	}

	private void addcomment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String message= "";
		Comment comment=new Comment();
		CommentService service=new CommentService();
		comment.setComment(request.getParameter("comment"));
		comment.setOrderid(Integer.parseInt(request.getParameter("orderid")));
		
		try {
			boolean addcomment=service.addComment(comment);
			if(addcomment) {
				message="Comment Added ";
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		
		request.setAttribute("message", message);
		response.sendRedirect("/go-cheeta/saledata?action=getorder&customer="+Integer.parseInt(request.getParameter("customer")));
		
	}
}
