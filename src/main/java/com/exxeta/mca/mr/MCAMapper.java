package com.exxeta.mca.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import au.com.bytecode.opencsv.CSVParser;

/*
 * Simple/Naive Mapper, welcher eine Zeile als Array einließt, 
 * einen groupingKey aus COBDate[0], ORGID[1], BU[2] und Currency[3] besteht
 * Der Amount in [5] wird als String übergeben.
 * 
 * Überlegungen: PERFORMANCE!
 * ACTCD zu GroupKey; GroupKey vorher definierbar!--> In Business Rules, Anforderung Wolfgang
 */
public class MCAMapper extends Mapper<LongWritable, Text, Text, Text> {
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException
	{

			CSVParser parser = new CSVParser();
			String[] lines = parser.parseLine(value.toString());
			
			String groupKey = lines[0].toString()+lines[1].toString()+lines[2].toString()+lines[3].toString();
			
			System.out.println(groupKey);
			System.out.println(lines[5].toString());
			
			context.write(
					new Text(groupKey), 
					new Text(lines[5].toString()) 
					);			
	}

}
