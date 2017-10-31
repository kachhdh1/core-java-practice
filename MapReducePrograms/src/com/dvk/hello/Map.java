package com.dvk.hello;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Map extends Mapper<LongWritable, Text, Text, IntWritable> {

	@Override
	public void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		String line = value.toString();
		String[] data = line.split("\t");
		try {
			context.write(new Text(data[2]), new IntWritable(1));
		} catch (Exception e) {

		}
	}

}
