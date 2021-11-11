package com.springboot.phase3.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "buynow")
public class Buynow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "book_name")                        
	private String bookName;

	@Column(name = "user_name")                        
	private String userName;
	
	@Column(name = "email_id")                        
	private String emailId;
	
	@Column(name = "phone_number")                        
	private  String phoneNumber;
	
	@Column(name = "address")                        
	private String address;
	
	@Column(name = "state")                        
	private String state;
	
	@Column(name = "city")                        
	private String city;
	
	
	@Column(name = "zip_code")                        
	private String zipCode;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_date")                        
	private Date orderDate=new Date(System.currentTimeMillis());
	
	public Buynow() {
		
	}
	public long getId() {                              
		return id;
	}
	public void setId(long id) {                    
		this.id = id;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBookName() {                    
		return bookName;
	}
	public void setBookName(String bookName) {         
		this.bookName = bookName;
	}
	public String getUserName() {                       
		return userName;
	}
	public void setUserName(String userName) {          
		this.userName = userName;
	}
	
	public String getEmailId() {                       
		return emailId;
	}
	public void setEmailId(String emailId) {          
		this.emailId = emailId;
	}
		public String getAddress() {                       
		return address;
	}
	public void setAddress(String address) {          
		this.address = address;
}
	public String getState() {                       
	return state;
}
    public void setState(String state) {          
	this.state = state;
}
   
   public void setCity(String city) {          
		this.city = city;
	}
	   public String getCity() {                       
	   return city;
	}
	   public String getZipCode() {                       
		   return zipCode;
		}
    public void setZipCode(String zipCode) {          
    this.zipCode = zipCode;
}
	public Date getOrderDate() {                       
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {          
		this.orderDate = orderDate;
}
}