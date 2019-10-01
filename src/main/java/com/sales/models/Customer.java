package com.sales.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="CUSTOMERS")
public class Customer {
	@Id
	@GeneratedValue
	@Column(name="CID")
	private Long cid;

	@Column(name="CNAME")
	@NotBlank
	private String cname;
	
	
	@Column(name="LOANPERIOD")
	@Min(value=1)
	private int loanperiod;
	
	@OneToMany(mappedBy="cust")
	private List<Loan> loans = new ArrayList<Loan>();

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cId) {
		this.cid = cId;
	}

	public String getCname() {
		return cname;
	}

	public void setcName(String cName) {
		this.cname = cName;
	}

	public int getLoanPeriod() {
		return loanperiod;
	}
	
	public int getLoanperiod() {
		return loanperiod;
	}

	public void setLoanPeriod(int loanPeriod) {
		this.loanperiod = loanPeriod;
	}

	public List<Loan> getLoans() {
		return loans;
	}

	public void setLoans(List<Loan> loans) {
		this.loans = loans;
	}

}