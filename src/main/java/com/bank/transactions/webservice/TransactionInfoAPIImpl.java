package com.bank.transactions.webservice;

import com.bank.transactions.model.TransactionInfo;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AutoJsonRpcServiceImpl
public class TransactionInfoAPIImpl implements TransactionInfoAPI {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public String getTnasctionInfo(TransactionInfo transactionInfo) {
		logger.info("transactionInfo : {}", transactionInfo);

		return "Contacts updated successfully";
	}

}
