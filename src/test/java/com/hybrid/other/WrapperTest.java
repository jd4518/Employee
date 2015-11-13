package com.hybrid.other;

public class WrapperTest {
	public static void main(String[] args) {
		//primitive Type (원시 타입 )
		byte b = 20;		// 1byte
		short s = 10;		// 2byte
		char c = 30;		// 2byte
		int i = 10;			// 4byte
		long l = 200;		// 8byte
		float f = 10.5f;	// 4byte
		double d = 10.6;	// 8byte
		
		// Wrapper Class (값에 NULL이 들어갈 수 있다 레퍼런스 타입ref)
		Byte b1 = 10;
		Byte b2 = Byte.valueOf("10"); // Boxing
		Short s1 = 10;
		Character c1 = 30;
		Integer i1 = 200;
		Long l1 = 200L;
		Float f1 = 10.5f;
		Double d1 = 10.7;
		
		d = d1; // UnBoxing
	}
}
