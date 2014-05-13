package com.exxeta.mca.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

/*
 * Main Driver Class.
 * Um Externe JARs einzubinden, muss das ganze Gedöns hier gemacht werden!
 * externe jars ind HADOOP_HOME/lib, dann beim ausführen in console mit -libjars
 * bsp:hadoop jar /home/master/hadoop/mca-0.0.1.jar com.exxeta.mca.mr.MCADriver -libjars ${LIBJARS} /user/master/input /output
 * Beispiel Aufbau für Driver Class:http://stackoverflow.com/questions/21977434/sample-code-for-using-hadoop-mapreduce-against-cassandra
 */
public class MCADriver extends Configured implements Tool 
{
	public static void main(String[] args) throws Exception
    {       
        ToolRunner.run(new Configuration(), new MCADriver(), args);
        System.exit(0);
    }

	@Override
	public int run(String[] args) throws Exception {
//		if (args.length !=2) 
//		{ 
//			System.err.println("Usage: MCADriver <input path> <output path>");;
//			System.exit(-1);
//		}
		
		Configuration conf = getConf();
		Job job = Job.getInstance(conf);
		
		job.setJarByClass(MCADriver.class);
		job.setJobName("MCA JOB");
		
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.setMapperClass(MCAMapper.class);
		//job.setCombinerClass(MCAReduce.class);
		job.setReducerClass(MCAReduce.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		
		job.waitForCompletion(true);		
		return 0;
	}

}
