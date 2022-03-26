package com.bank.transactions.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import com.bank.transactions.model.TransactionType;

@Entity(name = "transaction_info")
@Table(name = "transaction_info")
public class TransactionInfo {

	/*
	 * { "AccountNumber": 1234561289, "Type": "Credit", "Amount": "10340",
	 * "Currency": "INR", "AccountFrom": 19989456 }
	 */

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "transactionId", updatable = false, nullable = false, length = 36)
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID transactionId;

	@Column(name = "accountNumber")
	private String accountNumber;

	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private TransactionType type;

	@Column
	private String amount;

	@Column
	private String currency;

	@Column(name = "accountFrom")
	private String accountFrom;

	@Column(name = "time_stamp")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date timeStamp;

	public TransactionInfo() {

	}

	public TransactionInfo(UUID transactionId, String accountNumber, TransactionType type, String amount,
			String currency, String accountFrom, Date timeStamp) {
		this.transactionId = transactionId;
		this.accountNumber = accountNumber;
		this.type = type;
		this.amount = amount;
		this.currency = currency;
		this.accountFrom = accountFrom;
		this.timeStamp = timeStamp;
	}

	public TransactionInfo(String accountNumber, TransactionType type, String amount, String currency,
			String accountFrom, Date timeStamp) {
		this.accountNumber = accountNumber;
		this.type = type;
		this.amount = amount;
		this.currency = currency;
		this.accountFrom = accountFrom;
		this.timeStamp = timeStamp;
	}

	public UUID getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(UUID transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public TransactionType getType() {
		return type;
	}

	public void setType(TransactionType type) {
		this.type = type;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccountFrom() {
		return accountFrom;
	}

	public void setAccountFrom(String accountFrom) {
		this.accountFrom = accountFrom;
	}

	@Override
	public String toString() {
		return "TransactionInfo [transactionId=" + transactionId + ", accountNumber=" + accountNumber + ", type=" + type
				+ ", amount=" + amount + ", currency=" + currency + ", accountFrom=" + accountFrom + "]";
	}

}
