package com.exxeta.mca.MRUnittests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.junit.Before;
import org.junit.Test;

import com.exxeta.mca.mr.MCAReduce;

public class MCAReducerTest {
	
	ReduceDriver<Text, Text, Text, Text> reduceDriver;
	
	@Before
	  public void setUp() {
	    MCAReduce reducer = new MCAReduce();
	    reduceDriver = ReduceDriver.newReduceDriver(reducer);
	  }
	
	@Test
	public void testReducer() throws IOException
	{
		List<Text> values = new ArrayList<Text>();
		values.add(new Text ("100.001"));
		values.add(new Text ("200"));		
		reduceDriver.withInput(new Text("123AUD"), values);
		reduceDriver.withOutput(new Text ("123AUD"), new Text ("300.001"));
		reduceDriver.runTest();
	}

}
