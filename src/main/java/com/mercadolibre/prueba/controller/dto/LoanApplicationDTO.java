package com.mercadolibre.prueba.controller.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;



public class LoanApplicationDTO {
	private Long amount;
	private Long term;
	private Double rate;
	@JsonFormat(pattern = "yyy-MM-dd HH:mm:ss")
	private Date date;
	private String loanId;
	private Double installment;
	
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getTerm() {
		return term;
	}
	public void setTerm(Long term) {
		this.term = term;
	}
	public Double getRate() {
		return rate;
	}
	public void setRate(Double rate) {
		this.rate = rate;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLoanId() {
		return loanId;
	}
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	public Double getInstallment() {
		return installment;
	}
	public void setInstallment(Double installment) {
		this.installment = installment;
	}
	
}
