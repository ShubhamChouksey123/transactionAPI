package com.bank.transactions.webservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigurationAPI.
 */
@Configuration
public class ConfigurationAPI {

	/**
	 * Auto JSON RPC service impl exporter. For the connection of Clients with the
	 * 
	 * 
	 * @return the auto json rpc service impl exporter
	 */
	@Bean
	public static AutoJsonRpcServiceImplExporter autoJsonRpcServiceImplExporter() {
		AutoJsonRpcServiceImplExporter exp = new AutoJsonRpcServiceImplExporter();
		// in here you can provide custom HTTP status code providers etc. eg:
		// exp.setHttpStatusCodeProvider();
		// exp.setErrorResolver();
		exp.setAllowExtraParams(true);
		exp.setAllowLessParams(true);
		return exp;
	}
}
