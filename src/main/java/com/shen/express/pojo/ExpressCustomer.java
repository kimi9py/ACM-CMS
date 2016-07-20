package com.shen.express.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 部门 。。 员工登录，员工 部门，是否为主管
 * 
 * @author chinesejie
 * 
 */
@Entity
@Table(name = "ExpressCustomer")
public class ExpressCustomer implements Serializable {
	private long cid;
	private String name;
	private String password;
	private boolean charge;
	private ExpressSite department;

	@ManyToOne
	public ExpressSite getDepartment() {
		return department;
	}

	public void setDepartment(ExpressSite department) {
		this.department = department;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	private double money;

	public boolean isCharge() {
		return charge;
	}

	public void setCharge(boolean charge) {
		this.charge = charge;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private Set<ExpressOrder> expressOrders = new HashSet<ExpressOrder>();

	@Id
	@GeneratedValue
	public long getCid() {
		return cid;
	}

	public void setCid(long cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "expressCustomer")
	public Set<ExpressOrder> getExpressOrders() {
		return expressOrders;
	}

	public void setExpressOrders(Set<ExpressOrder> expressOrders) {
		this.expressOrders = expressOrders;
	}

}
