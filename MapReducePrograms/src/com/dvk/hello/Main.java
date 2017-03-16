package com.dvk.hello;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;
import org.apache.hadoop.fs.Path;

public class Main extends Configured implements Tool{

	public static void main(String[] args) throws Exception {
		//http://stackoverflow.com/questions/35652665/java-io-ioexception-could-not-locate-executable-null-bin-winutils-exe-in-the-ha
		System.setProperty("hadoop.home.dir", "H:/Dharmik"); 
		int exitCode = ToolRunner.run(new Main(), args);
		System.exit(exitCode);
	}

	@Override
	public int run(String[] args) throws Exception {
		Job job = Job.getInstance(getConf());
		job.setJobName("Hello Hadoop");
		job.setJarByClass(Main.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);
		
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		
		Path inputFilePath = new Path("/MapReducePrograms/data/input");
		Path putputFilePath = new Path("/MapReducePrograms/data/output");
		
		//Path inputFilePath = new Path(args[0]);
		//Path putputFilePath = new Path(args[1]);
		
		FileInputFormat.addInputPath(job, inputFilePath);
		FileOutputFormat.setOutputPath(job, putputFilePath);
		
		return job.waitForCompletion(true)?0:1;
	}

}
