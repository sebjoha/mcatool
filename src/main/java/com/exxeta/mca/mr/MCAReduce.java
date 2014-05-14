package com.exxeta.mca.mr;

import java.io.IOException;
import java.math.BigDecimal;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;


/*
 * Simpler Mapper, welcher den amount als String annimmt, in BigDecimal umwandelt 
 * und bisher lediglich zu dem Gesamt"ergebnis" addiert.
 * Noch Keine unterscheidung in Assets und Liabilities!!
 * Für die Ausgabe wird BigDecimal wieder in einen String umgewandelt
 * 
 * Anmerkung: Später wiederverwendet als Combiner!
 */
public class MCAReduce extends Reducer<Text, Text, Text, Text>{
	
	
	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException{
		
		BigDecimal sum = new BigDecimal(0);
		BigDecimal bigDecimalConverter = new BigDecimal(0);
		
		for ( Text value: values)
		{
			bigDecimalConverter = new BigDecimal(value.toString());
			
			sum = sum.add(bigDecimalConverter);
		}
		
		context.write(key, new Text(sum.toString()));
		
	}
}
