package com.hybrid.util;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;

public class PaginationTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_mysql.xml");
		Pagination paging = new Pagination();
		Scanner scan = new Scanner(System.in);
		CityMapper cityMapper = ctx.getBean(CityMapper.class);
		int totalItem = cityMapper.selectCount();
		
		
		while(true){
			System.out.println("pageNo=");
			int pageNo = scan.nextInt();
			
			paging.setPageNo(pageNo);
			paging.setTotalItem(totalItem);
			System.out.println(paging.getStart());
			System.out.println(paging.getLength());
			
			List<City> list = cityMapper.selectPage(paging);
			
			
//			for(int i=paging.getFirstItem(); i<=paging.getLastItem();i++){
//				City c = list.get(i-paging.getFirstItem());
			for(int i=0; i<paging.getLength();i++){
				City c = list.get(i);
				String line = c.getId() + " " + c.getName() + " " + c.getCountryCode();
				System.out.println(line);
			}
			if(!paging.isFirstGroup()){
				System.out.print("[이전] ");
			}else{
				System.out.print("      ");
			}
			for(int i=paging.getFirstPage(); i<=paging.getLastPage();i++){
				System.out.printf("[%03d] ",i);
			}
			if(!paging.isLastGroup()){
				System.out.print("[다음] ");
			}else{
				System.out.print("      ");
			}
		}
	}
	
	static void test1(){
		Pagination paging = new Pagination();
		for(int i=-2; i<30;i++){
			paging.setPageNo(i);
			paging.setTotalItem(271);
				
			
			String line = "totalPage =" + paging.getTotalPage()
						+ ", firstGroup =" + paging.isFirstGroup()
						+ ", firstItem = " + paging.getFirstItem()
						+ ", firstPage = " + paging.getFirstPage()
						+ ", pageNo = " + paging.getPageNo()
						+ ", lastItem = " + paging.getLastItem()
						+ ", lastPage = " + paging.getLastPage()
						+ ", lastGroup = " + paging.isLastGroup();
			
			System.out.println(line);
		}
	}

}
