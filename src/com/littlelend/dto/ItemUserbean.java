package com.littlelend.dto;

import java.util.Date;

public class ItemUserbean {
	int itemid,borrowerid;
	String category,productname,description,flag;
	Date startdate,enddate;
	String firstname;
	String lastname;
	String email,address,city,zip,phone;
	
	
	
	public ItemUserbean(int itemid, int borrowerid, String category, String productname, String description,
			String flag, Date startdate, Date enddate, String firstname, String lastname, String email, String address,
			String city, String zip, String phone) {
		super();
		this.itemid = itemid;
		this.borrowerid = borrowerid;
		this.category = category;
		this.productname = productname;
		this.description = description;
		this.flag = flag;
		this.startdate = startdate;
		this.enddate = enddate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
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
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "ItemUserbean [itemid=" + itemid + ", borrowerid=" + borrowerid + ", category=" + category
				+ ", productname=" + productname + ", description=" + description + ", flag=" + flag + ", startdate="
				+ startdate + ", enddate=" + enddate + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", email=" + email + ", address=" + address + ", city=" + city + ", zip=" + zip + ", phone=" + phone
				+ "]";
	}
	public ItemUserbean(int itemid, int borrowerid, String category, String productname, String description,
			Date startdate, Date enddate, String firstname, String lastname, String email, String address, String city,
			String zip, String phone) {
		super();
		this.itemid = itemid;
		this.borrowerid = borrowerid;
		this.category = category;
		this.productname = productname;
		this.description = description;
		this.startdate = startdate;
		this.enddate = enddate;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
	}
	public ItemUserbean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	
	

}
