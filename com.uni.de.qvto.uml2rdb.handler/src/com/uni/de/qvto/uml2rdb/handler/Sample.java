package com.uni.de.qvto.uml2rdb.handler;

import java.util.Arrays;
import java.util.List;


public class Sample {
	
	public static void main(String[] args) {
		int  numGen = 34;
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		int i =0;
		while(numGen>0) {
			if(i>=numbers.size()) {
				i=0;
			}
			int eObject = numbers.get(i);
			System.out.println(eObject);
			numGen--;
			i++;
		}

	}

}
