package com.shen.express.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ExpressSite")
public class ExpressSite implements Serializable {
	private String address;
	private Set<ExpressOrder> lastOrders = new HashSet<ExpressOrder>();
	private String name;

	private Set<ExpressCustomer> customers = new HashSet<ExpressCustomer>();
	@OneToMany(mappedBy = "department")
	public Set<ExpressCustomer> getCustomers() {
		return customers;
	}
	
	public void setCustomers(Set<ExpressCustomer> customers) {
		this.customers = customers;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Set<ExpressOrder> nextOrders = new HashSet<ExpressOrder>();
	private long sid;
	private String password;

	public String getAddress() {
		return address;
	}

	@OneToMany(mappedBy = "originSite")
	public Set<ExpressOrder> getLastOrders() {
		return lastOrders;
	}

	public String getName() {
		return name;
	}

	@OneToMany(mappedBy = "finalSite")
	public Set<ExpressOrder> getNextOrders() {
		return nextOrders;
	}

	@Id
	@GeneratedValue
	public long getSid() {
		return sid;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setLastOrders(Set<ExpressOrder> lastOrders) {
		this.lastOrders = lastOrders;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNextOrders(Set<ExpressOrder> nextOrders) {
		this.nextOrders = nextOrders;
	}

	public void setSid(long sid) {
		this.sid = sid;
	}

}
