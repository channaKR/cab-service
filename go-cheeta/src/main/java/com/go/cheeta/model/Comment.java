package com.go.cheeta.model;

public class Comment {
  private int commentid;
  private String comment;
  private int orderid;
public Comment() {
	super();
	// TODO Auto-generated constructor stub
}
public Comment(int commentid, String comment, int orderid) {
	super();
	this.commentid = commentid;
	this.comment = comment;
	this.orderid = orderid;
}
public int getCommentid() {
	return commentid;
}
public void setCommentid(int commentid) {
	this.commentid = commentid;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public int getOrderid() {
	return orderid;
}
public void setOrderid(int orderid) {
	this.orderid = orderid;
}
  
  
}
