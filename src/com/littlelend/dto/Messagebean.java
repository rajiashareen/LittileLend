package com.littlelend.dto;

import java.util.Date;

public class Messagebean {
	int MessageId,ItemMessageID,userMessageID,sentID,receviverID;
	String MessageContent,messagestatus;
	Date messagdata;
	
	
	
	
	
	
	
	public Messagebean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Messagebean(int messageId, int itemMessageID, int userMessageID, int sentID, int receviverID,
			String messageContent, String messagestatus, Date messagdata) {
		super();
		MessageId = messageId;
		ItemMessageID = itemMessageID;
		this.userMessageID = userMessageID;
		this.sentID = sentID;
		this.receviverID = receviverID;
		MessageContent = messageContent;
		this.messagestatus = messagestatus;
		this.messagdata = messagdata;
	}
	@Override
	public String toString() {
		return "Messagebean [MessageId=" + MessageId + ", ItemMessageID=" + ItemMessageID + ", userMessageID="
				+ userMessageID + ", sentID=" + sentID + ", receviverID=" + receviverID + ", MessageContent="
				+ MessageContent + ", messagestatus=" + messagestatus + ", messagdata=" + messagdata + "]";
	}
	public int getMessageId() {
		return MessageId;
	}
	public void setMessageId(int messageId) {
		MessageId = messageId;
	}
	public int getItemMessageID() {
		return ItemMessageID;
	}
	public void setItemMessageID(int itemMessageID) {
		ItemMessageID = itemMessageID;
	}
	public int getUserMessageID() {
		return userMessageID;
	}
	public void setUserMessageID(int userMessageID) {
		this.userMessageID = userMessageID;
	}
	public int getSentID() {
		return sentID;
	}
	public void setSentID(int sentID) {
		this.sentID = sentID;
	}
	public int getReceviverID() {
		return receviverID;
	}
	public void setReceviverID(int receviverID) {
		this.receviverID = receviverID;
	}
	public String getMessageContent() {
		return MessageContent;
	}
	public void setMessageContent(String messageContent) {
		MessageContent = messageContent;
	}
	public String getMessagestatus() {
		return messagestatus;
	}
	public void setMessagestatus(String messagestatus) {
		this.messagestatus = messagestatus;
	}
	public Date getMessagdata() {
		return messagdata;
	}
	public void setMessagdata(Date messagdata) {
		this.messagdata = messagdata;
	}
	
	
	
	
	

	
	
}