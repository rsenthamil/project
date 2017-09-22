package com.Project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Addproduct {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	int pid;
	
	@Column
	String pName;
	@Column
	int pPrize;
	@Column
	String pDes;
	@Column
	int pPer;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
	public int getpPrize() {
		return pPrize;
	}
	public void setpPrize(int pPrize) {
		this.pPrize = pPrize;
	}
	public String getpDes() {
		return pDes;
	}
	public void setpDes(String pDes) {
		this.pDes = pDes;
	}
	public int getpPer() {
		return pPer;
	}
	public void setpPer(int pPer) {
		this.pPer = pPer;
	}
}
