package com.shen.express.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contest")
public class AcmContest implements Serializable {
	private int contest_id;
	private String title;
	private Date start_time;
	private Date end_time;
	private int defunct;

	@Id
	public int getContest_id() {
		return contest_id;
	}

	public void setContest_id(int contest_id) {
		this.contest_id = contest_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public int getDefunct() {
		return defunct;
	}

	public void setDefunct(int defunct) {
		this.defunct = defunct;
	}

	@Column(name = "private")
	public int get_private() {
		// private关键字
		return _private;
	}

	public void set_private(int _private) {
		this._private = _private;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPaper_path() {
		return paper_path;
	}

	public void setPaper_path(String paper_path) {
		this.paper_path = paper_path;
	}

	public String getPaper_key() {
		return paper_key;
	}

	public void setPaper_key(String paper_key) {
		this.paper_key = paper_key;
	}

	private int _private;
	private int status;
	private String paper_path;
	private String paper_key;

}
