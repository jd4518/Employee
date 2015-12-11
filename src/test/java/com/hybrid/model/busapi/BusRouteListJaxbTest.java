package com.hybrid.model.busapi;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class BusRouteListJaxbTest {
	public static void main(String[] args) throws MalformedURLException {
		try{
			JAXBContext ctx = JAXBContext.newInstance(ServiceResult.class);
			
			ServiceResult result = new ServiceResult();
			MsgHeader msgHeader = new MsgHeader();
			
			msgHeader.setHeaderCd("100");
			msgHeader.setHeaderMsg("정상처리...");
			msgHeader.setItemCount(999);
			result.setMsgHeader(msgHeader);
			
			
			Marshaller marshaller = ctx.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			marshaller.marshal(result, System.out);
			
			Unmarshaller unmarshaller = ctx.createUnmarshaller();
			
			String str = "http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList?strSrch=6628&serviceKey=AaxqTg02PVW%2BZhaIkh4fVAIiknK6EU6ZkfT1lQEHEo2PRlldpzfhjoBwE63YKQGpiY4JdZCjCktTW2yatRX%2FgA%3D%3D";
			
			URL url = new URL(str);
			
			ServiceResult busResult = (ServiceResult) unmarshaller.unmarshal(url);
			
			marshaller.marshal(busResult, System.out);
			
		}
		catch(JAXBException e){
			e.printStackTrace();
		}
	}
}
