package com.exxeta.mca;

import java.math.BigDecimal;

import au.com.bytecode.opencsv.CSVParser;
import junit.framework.TestCase;

public class BasicTest extends TestCase {
	
	String csvLine = " \"1\",\"2\",\"3\",\"AUD\",\"0000000001\",\"123456789\",\"\",\"\" ";

	public void testReadSingleCSVLine() throws Exception {
		
		CSVParser parser = new CSVParser();
		String[] lines = parser.parseLine(csvLine.toString());
		System.out.println("testReadSingleCSVLine: "+lines[0].toString()+""+lines[1].toString()+lines[2].toString()+""+lines[3].toString());
		assertTrue(true);
	}
	
	public void testCastStringToBigDecimal () throws Exception {
		
		String value = "123456789.123456789";
		BigDecimal bigDecimalConverter = new BigDecimal(value);
		
		System.out.println("testCastStringToBigDecimal: "+bigDecimalConverter);
		assertTrue(true);
		
	}


}
