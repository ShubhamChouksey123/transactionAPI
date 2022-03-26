package com.bank.transactions.hibernate.dao;

import java.util.List;
import java.util.UUID;

import com.bank.transactions.model.TransactionInfo;

public interface TranactionInfoDAO {

	List<TransactionInfo> getTransactions(String accountNumber);

	TransactionInfo getTransactionByHash(UUID transactionId);

	UUID saveTransaction(TransactionInfo transactionInfo);

	boolean isPresent(UUID transactionId);

}
