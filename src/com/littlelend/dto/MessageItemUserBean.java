package com.littlelend.dto;

import java.util.Date;

public class MessageItemUserBean {
	int messageID,mborrowerID,mitemID,sentID,receiverID;
	String messageContent,mborrowerfname,mborroweremail,mitemname,receivername;
	Date messageDate;
	
	
	
	public MessageItemUserBean(int messageID, int mborrowerID, int mitemID, int sentID, int receiverID,
			String messageContent, String mborrowerfname, String mborroweremail, String mitemname, Date messageDate) {
		super();
		this.messageID = messageID;
		this.mborrowerID = mborrowerID;
		this.mitemID = mitemID;
		this.sentID = sentID;
		this.receiverID = receiverID;
		this.messageContent = messageContent;
		this.mborrowerfname = mborrowerfname;
		this.mborroweremail = mborroweremail;
		this.mitemname = mitemname;
		this.messageDate = messageDate;
	}
	@Override
	public String toString() {
		return "MessageItemUserBean [messageID=" + messageID + ", mborrowerID=" + mborrowerID + ", mitemID=" + mitemID
				+ ", sentID=" + sentID + ", receiverID=" + receiverID + ", messageContent=" + messageContent
				+ ", mborrowerfname=" + mborrowerfname + ", mborroweremail=" + mborroweremail + ", mitemname="
				+ mitemname + ", receivername=" + receivername + ", messageDate=" + messageDate + "]";
	}
	public MessageItemUserBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MessageItemUserBean(int messageID, int mborrowerID, int mitemID, int sentID, int receiverID,
			String messageContent, String mborrowerfname, String mborroweremail, String mitemname, String receivername,
			Date messageDate) {
		super();
		this.messageID = messageID;
		this.mborrowerID = mborrowerID;
		this.mitemID = mitemID;
		this.sentID = sentID;
		this.receiverID = receiverID;
		this.messageContent = messageContent;
		this.mborrowerfname = mborrowerfname;
		this.mborroweremail = mborroweremail;
		this.mitemname = mitemname;
		this.receivername = receivername;
		this.messageDate = messageDate;
	}
	public int getMessageID() {
		return messageID;
	}
	public void setMessageID(int messageID) {
		this.messageID = messageID;
	}
	public int getMborrowerID() {
		return mborrowerID;
	}
	public void setMborrowerID(int mborrowerID) {
		this.mborrowerID = mborrowerID;
	}
	public int getMitemID() {
		return mitemID;
	}
	public void setMitemID(int mitemID) {
		this.mitemID = mitemID;
	}
	public int getSentID() {
		return sentID;
	}
	public void setSentID(int sentID) {
		this.sentID = sentID;
	}
	public int getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(int receiverID) {
		this.receiverID = receiverID;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getMborrowerfname() {
		return mborrowerfname;
	}
	public void setMborrowerfname(String mborrowerfname) {
		this.mborrowerfname = mborrowerfname;
	}
	public String getMborroweremail() {
		return mborroweremail;
	}
	public void setMborroweremail(String mborroweremail) {
		this.mborroweremail = mborroweremail;
	}
	public String getMitemname() {
		return mitemname;
	}
	public void setMitemname(String mitemname) {
		this.mitemname = mitemname;
	}
	public String getReceivername() {
		return receivername;
	}
	public void setReceivername(String receivername) {
		this.receivername = receivername;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	
	
	
	
	
	
	

}
