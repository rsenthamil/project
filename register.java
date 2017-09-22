package com.Project.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class register
{
@Id()
@GeneratedValue(strategy=GenerationType.AUTO)
 int userid;

@Column
String username;
@Column
String email;
@Column
String password;
@Column
int phoneno;
@Column
String address;


public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getPhoneno() {
	return phoneno;
}
public void setPhoneno(int phoneno) {
	this.phoneno = phoneno;
}

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}

