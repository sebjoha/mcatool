package com.exxeta.mca.MRUnittests;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.junit.Before;
import org.junit.Test;

import com.exxeta.mca.mr.MCAMapper;

public class MCAMapperTest {
	
	MapDriver<LongWritable, Text, Text, Text> mapDriver;
	
	@Before
	  public void setUp() {
	    MCAMapper mapper = new MCAMapper();
	    mapDriver = MapDriver.newMapDriver(mapper);
	  }
	
	@Test
	public void processValidRecord() throws IOException
	{
		String value = "\"1\",\"2\",\"3\",\"AUD\",\"0000000001\",\"123456789\",\"\",\"\" ";
		mapDriver.withInput(new LongWritable(), new Text(value));
		mapDriver.withOutput(new Text("123AUD"), new Text ("123456789"));
		mapDriver.runTest();
	}

}
