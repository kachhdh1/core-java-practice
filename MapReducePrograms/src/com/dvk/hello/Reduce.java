package com.dvk.hello;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class Reduce extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	public void reduce(final Text key, final Iterable<IntWritable> values,
			final Context context) throws IOException, InterruptedException {
		Integer count = 0;

		for (IntWritable value : values) {
			count+=value.get();
		}

		try {
			context.write(new Text(key), new IntWritable(count));
		} catch (Exception e) {

		}

	}

}
