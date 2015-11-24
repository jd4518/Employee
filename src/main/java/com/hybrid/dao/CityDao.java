package com.hybrid.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;
import com.hybrid.util.Pagination;

public class CityDao {
	
	static Log log = LogFactory.getLog(CityDao.class);
	CityMapper mapper;
	
	public void setCityMapper(CityMapper mapper){
		this.mapper = mapper;
	}
	
	public List<City> selectAll(){
		
		return mapper.selectAll();
	}
	public List<City> selectPage(Pagination paging){
		return mapper.selectPage(paging);
	}
	public List<City> selectByCountryCode(String countryCode){
		return mapper.selectByCountryCode(countryCode);
	}
	
	public int insert(City city){
		return mapper.insert(city);
	}
	public int selectCount(){
		return mapper.selectCount();
	}
	public int deleteAll(){
		
		return mapper.deleteAll();
	}
	
}
