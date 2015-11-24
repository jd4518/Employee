package com.hybrid.service;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hybrid.dao.CityDao;
import com.hybrid.model.City;

public class CityRegisterService {
	static Log log = LogFactory.getLog(CityRegisterService.class);
	CityDao cityDao;
	DataSource dataSource;
	
	public void setCityDao(CityDao cityDao){
		this.cityDao = cityDao;
	}
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}
	
	public void regist(DataSource dataSource){
		this.dataSource = dataSource;
		
		int deleteCount = cityDao.deleteAll();
		log.info("oracle City Delete Count = " + deleteCount);
		
		List<City> city = cityDao.selectAll();
		
	}
	
}
