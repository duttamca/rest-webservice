package com.sanjiv.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.FetchProfile;



@Entity
@Table(name="USERS")
//@JsonAutoDetect
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users {
	@Id
	@Column(name="USER_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userid_seq")
	@SequenceGenerator(name="userid_seq",sequenceName="userid_sequence",allocationSize=1)
	
	private int userID;
	
	@Column(name="USER_NAME")
	
	private String userName;
	
	@Column(name="EMAIL_ID")
	private String emailID;
	
	public Users(){}

	public Users(String userName, String emailID, int userID) {
		
		this.userName = userName;
		this.userID = userID;
		this.emailID = emailID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	
	@Override
	public String toString() {
	     return new StringBuffer(" User Name : ").append(this.userName)
	              .append(" Email Id : ").append(this.emailID)
	              .append(" User ID : ")
	              .append(this.userID).toString();
		    }
		 


}
