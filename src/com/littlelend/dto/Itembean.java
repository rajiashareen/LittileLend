package com.littlelend.dto;

import java.util.Date;

public class Itembean extends Userbean{
	int itemid,borrowerid;
	String category,productname,description,flag;
	Date startdate,enddate;
	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public int getBorrowerid() {
		return borrowerid;
	}
	public void setBorrowerid(int borrowerid) {
		this.borrowerid = borrowerid;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	@Override
	public String toString() {
		return "Itembean [itemid=" + itemid + ", borrowerid=" + borrowerid + ", category=" + category + ", productname="
				+ productname + ", description=" + description + ", flag=" + flag + ", startdate=" + startdate
				+ ", enddate=" + enddate + "]";
	}
	public Itembean( int itemid, int borrowerid, String category, String productname,
			String description, String flag, Date startdate, Date enddate) {
	
		this.itemid = itemid;
		this.borrowerid = borrowerid;
		this.category = category;
		this.productname = productname;
		this.description = description;
		this.flag = flag;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	public Itembean(int id, String firstname, String lastname, String email, String password, String address,
			String city, String zip, String phone, int itemid, int borrowerid, String category, String productname,
			String description, String flag, Date startdate, Date enddate) {
		super(id, firstname, lastname, email, password, address, city, zip, phone);
		this.itemid = itemid;
		this.borrowerid = borrowerid;
		this.category = category;
		this.productname = productname;
		this.description = description;
		this.flag = flag;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	
	
	public Itembean( int itemid, int borrowerid, String category, String productname,
			String description, Date startdate, Date enddate) {
	
		this.itemid = itemid;
		this.borrowerid = borrowerid;
		this.category = category;
		this.productname = productname;
		this.description = description;
		this.startdate = startdate;
		this.enddate = enddate;
	}
	public Itembean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Itembean(int id, String firstname, String lastname, String email, String password, String address,
			String city, String zip, String phone) {
		super(id, firstname, lastname, email, password, address, city, zip, phone);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
