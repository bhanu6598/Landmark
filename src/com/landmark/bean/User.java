package com.landmark.bean;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String firstname;
	private String lastname;
	private String email;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String password;
	
	public User()
	{
		userid="";
		firstname="";
		lastname="";
		email="";
		address1="";
		address2="";
		city="";
		state="";
		zip="";
		country="";	
	}
	
	public User(String userid, String firstname, String lastname, String email, String address1, String address2, String city, String state, String zip, String country)
	{
		this.userid=userid;
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.address1=address1;
		this.address2=address2;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.country=country;
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
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddressHTMLFormat() {
        String address = firstname + " " + lastname + "<br>";
        address += address1 + "<br>";
        address += address2 + "<br>";
        address += city + ", " + state + " " + zip + "<br>"+ country;
        return address;
    }
}
