package com.bank.transactions.model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

class TransactionInfoTest {

	static TransactionInfo transactionInfo;

	Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@BeforeAll
	static void beforeAllInit() {
		System.out.println("Before All - Before the class has been created !");
		transactionInfo = new TransactionInfo();
	}

	@BeforeEach
	void init() {
		System.out.println("beforeEach Method Run !");
	}

	@AfterEach
	void cleanUp() {
		System.out.println("after each method has fininshed running. Cleaning up !");
	}

	@Test
	@DisplayName("Testing  convertJavaObjectTOJSON  Method ")
	void checkConvertJavaObjectTOJSON() throws IOException {
		Date timeStamp = new Date();
		TransactionInfo transactionInfo = new TransactionInfo("124578", TransactionType.CREDIT, "123", "INR", "9869",
				timeStamp);
		logger.info("transactionInfo : {}", transactionInfo);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String jsonTransactionInfo = ow.writeValueAsString(transactionInfo);

		System.out.println("jsonTransactionInfo : " + jsonTransactionInfo);


		
		assertNotNull(jsonTransactionInfo); 
	}

}
