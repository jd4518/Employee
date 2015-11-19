package com.hybrid.aspect;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Aspect
public class TransactionAspect {

	static Log log = LogFactory.getLog(TransactionAspect.class);
	
	DataSource datasource;
	
	public void setDataSource(DataSource dataSource){
		this.datasource = dataSource;
	}
	
	
	@Around("execution(public * com.hybrid.service.*Service.*(..))")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		//before
//		log.info("### before");
		
		DataSourceTransactionManager tm = new DataSourceTransactionManager(datasource);
		
		TransactionDefinition td = new DefaultTransactionDefinition();
		TransactionStatus ts = tm.getTransaction(td);
		log.info("### transaction start");
		Object rtn = null;
		try{
		 rtn = pjp.proceed();
		 //afterReturnning
		 tm.commit(ts);
		 log.info("### commit");
		}catch(Throwable t){
			//afterThrowing
			tm.rollback(ts);
			log.info("### rollback");
			throw t;
		}finally{
			//after
//			log.info("### after");
		}
		
		

		
		
		return rtn;
	}
	
}
