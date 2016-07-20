package com.shen.express.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ExpressOrder")
public class ExpressOrder {
	private Date arriveTime;
	private boolean cancel;
	private String hrComment;

	private ExpressSite department;

	public double getMouthSalary() {
		return mouthSalary;
	}

	@ManyToOne
	public ExpressSite getDepartment() {
		return department;
	}

	public void setDepartment(ExpressSite department) {
		this.department = department;
	}

	public void setMouthSalary(double mouthSalary) {
		this.mouthSalary = mouthSalary;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobComment() {
		return jobComment;
	}

	public void setJobComment(String jobComment) {
		this.jobComment = jobComment;
	}

	private String poComment;
	private double mouthSalary;

	private String jobTitle;
	private String jobComment;

	public String getHrComment() {
		return hrComment;
	}

	public void setHrComment(String hrComment) {
		this.hrComment = hrComment;
	}

	public String getPoComment() {
		return poComment;
	}

	public void setPoComment(String poComment) {
		this.poComment = poComment;
	}

	// 发起 申请的那个人
	private ExpressCustomer expressCustomer;

	private ExpressSite finalSite;

	private Date flushTime;

	private Date getTime;

	//
	private String note;

	private long oid;

	private Date orderTime;

	private ExpressSite originSite;

	private boolean paid;
	private double price;
	private String receiverAddress;

	private String receiverName;
	private String receiverNumber;
	private String senderAddress;
	private String senderName;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	private String senderNumber;

	public String getRequired() {
		return required;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	private Date sendTime;
	private Date signTime;
	private int status;

	private String title;
	private String content;
	private String salary;
	private String required;

	private double weight;

	public Date getArriveTime() {
		return arriveTime;
	}

	@ManyToOne
	public ExpressCustomer getExpressCustomer() {
		return expressCustomer;
	}

	@ManyToOne
	public ExpressSite getFinalSite() {
		return finalSite;
	}

	public Date getFlushTime() {
		return flushTime;
	}

	public Date getGetTime() {
		return getTime;
	}

	public String getNote() {
		return note;
	}

	@Id
	@GeneratedValue
	public long getOid() {
		return oid;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	@ManyToOne
	public ExpressSite getOriginSite() {
		return originSite;
	}

	public double getPrice() {
		return price;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverNumber() {
		return receiverNumber;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderNumber() {
		return senderNumber;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public Date getSignTime() {
		return signTime;
	}

	public int getStatus() {
		return status;
	}

	public double getWeight() {
		return weight;
	}

	public boolean isCancel() {
		return cancel;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}

	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	public void setExpressCustomer(ExpressCustomer expressCustomer) {
		this.expressCustomer = expressCustomer;
	}

	public void setFinalSite(ExpressSite finalSite) {
		this.finalSite = finalSite;
	}

	public void setFlushTime(Date flushTime) {
		this.flushTime = flushTime;
	}

	public void setGetTime(Date getTime) {
		this.getTime = getTime;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public void setOriginSite(ExpressSite originSite) {
		this.originSite = originSite;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiverNumber(String receiverNumber) {
		this.receiverNumber = receiverNumber;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public void setSenderNumber(String senderNumber) {
		this.senderNumber = senderNumber;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
