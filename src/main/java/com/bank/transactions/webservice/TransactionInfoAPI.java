package com.bank.transactions.webservice;

import com.bank.transactions.model.TransactionInfo;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

@JsonRpcService(value = "/api")
public interface TransactionInfoAPI {

	String setTransactionInfo(@JsonRpcParam(value = "Transaction") TransactionInfo transactionInfo);
}