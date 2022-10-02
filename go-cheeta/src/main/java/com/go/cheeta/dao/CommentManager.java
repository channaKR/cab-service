package com.go.cheeta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.go.cheeta.model.Comment;

public class CommentManager {

	public static boolean addComment(Comment comment) throws ClassNotFoundException, SQLException {
		DbConnector connector = new DbConnectorSQL();
		Connection connection = connector.getConnection();
		String query="INSERT INTO comment (comment,orderid) VALUES (?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, comment.getComment());
		ps.setInt(2, comment.getOrderid());
		boolean result = ps.executeUpdate() > 0 ;
		ps.close();
		connection.close();
		return result;
	}
	
}
