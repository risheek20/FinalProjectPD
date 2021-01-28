package com.mad322;

public class Individual {
	private String birth_date;
	private String first_name;
	private String last_name;
	private int cust_id ;
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	@Override
	public String toString() {
		return "Individual [birth_date=" + birth_date + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", cust_id=" + cust_id + "]";
	}
}