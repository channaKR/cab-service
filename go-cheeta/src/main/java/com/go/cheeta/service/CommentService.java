package com.go.cheeta.service;

import java.sql.SQLException;

import com.go.cheeta.dao.CommentManager;
import com.go.cheeta.model.Comment;

public class CommentService {
public boolean addComment(Comment comment) throws ClassNotFoundException, SQLException {
	return CommentManager.addComment(comment);
}
}
