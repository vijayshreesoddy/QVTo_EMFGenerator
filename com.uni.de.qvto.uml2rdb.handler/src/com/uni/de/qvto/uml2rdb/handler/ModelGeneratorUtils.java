package com.uni.de.qvto.uml2rdb.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;



public class ModelGeneratorUtils {

	public static int[] n_random(int count, int finalSum)
	{
	    Random r = new Random();
	    int numbers[] = new int[count];
	    int sum = 0;
	    for (int i = 0; i < count - 1; i++)
	    {
	        numbers[i] = r.nextInt((finalSum - sum) / 2) + 1;
	        sum += numbers[i];
	    }
	    numbers[count - 1] = finalSum - sum;

	   /* StringBuilder numbersString = new StringBuilder("Random number list: ");
	    for (int i = 0; i < count; i++)
	        numbersString.append(numbers[i] + " ");
	    System.out.println(numbersString);*/
	    return numbers;
	}

	public static void main(String[] args)
	{
	    for (int i = 0; i < 6; i++) {
			n_random(9, 250);

			
		}
	}
}
