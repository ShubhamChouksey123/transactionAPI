package com.bank.transactions.webservice;

import com.bank.transactions.hibernate.dao.TranactionInfoDAO;
import com.bank.transactions.hibernate.dao.TranactionInfoDAOImpl;
import com.bank.transactions.model.TransactionInfo;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;

import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AutoJsonRpcServiceImpl
public class TransactionInfoAPIImpl implements TransactionInfoAPI {

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	private TranactionInfoDAOImpl tranactionInfoDAO;

	@Override
	public String setTransactionInfo(TransactionInfo transactionInfo) {
		logger.info("transactionInfo : {}", transactionInfo);

		Date timestamp = new Date();
		transactionInfo.setTimeStamp(timestamp);

		UUID transactionId = tranactionInfoDAO.saveTransaction(transactionInfo);
		
		logger.info("Saved Transaction with transactionID : {}",transactionId );

		return "TransactionInfo added successfully with ID : " + transactionId;
	}

}
