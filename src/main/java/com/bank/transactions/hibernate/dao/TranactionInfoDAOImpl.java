package com.bank.transactions.hibernate.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bank.transactions.model.TransactionInfo;

@Repository
@Transactional
public class TranactionInfoDAOImpl implements TranactionInfoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<TransactionInfo> getTransactions(String accountNumber) {

		Session session = this.sessionFactory.getCurrentSession();
		List<TransactionInfo> tranxList = new ArrayList<TransactionInfo>();
		String sql = "from transaction_info t where t.accountNumber = '" + accountNumber + "' or t.accountFrom = '"
				+ accountNumber + "' order by t.timeStamp desc";
		tranxList = session.createQuery(sql).getResultList();
		return tranxList;

	}

	@Override
	public TransactionInfo getTransactionByHash(UUID transactionId) {
		Session session = this.sessionFactory.getCurrentSession();

		TransactionInfo txn = session.get(TransactionInfo.class, transactionId);

		return txn;

	}

	@Override
	public UUID saveTransaction(TransactionInfo transactionInfo) {
		Session session = this.sessionFactory.getCurrentSession();

		UUID transactionId = (UUID)session.save(transactionInfo);

		return transactionId;
	}

	@Override
	public boolean isPresent(UUID transactionId) {
		Session session = this.sessionFactory.getCurrentSession();

		TransactionInfo transactionInfo = session.get(TransactionInfo.class, transactionId);

		return (transactionInfo == null) ? false : true;
	}

}
