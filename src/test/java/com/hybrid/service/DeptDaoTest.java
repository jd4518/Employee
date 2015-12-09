package com.hybrid.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.dao.DeptDao;
import com.hybrid.model.Dept;

public class DeptDaoTest {

	static Log log = LogFactory.getLog(DeptRegisterServiceTest.class);
	
	public static void main(String[] args) {
			GenericXmlApplicationContext ctx = null;
			ctx = new GenericXmlApplicationContext("spring/beans_oracle.xml");
			
			DeptDao dao = ctx.getBean(DeptDao.class);
			
			List<Dept> list = dao.selectAll();
			log.info("dept size = " + list.size());
			
			list = dao.selectAllWithEmps();
			log.info("dept size = " + list.size());
			
			Dept dept;
			
			dept = dao.selectByDeptnoWithEmps(80);
	}

}
