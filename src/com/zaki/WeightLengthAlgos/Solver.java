package com.zaki.WeightLengthAlgos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solver {

	private final static String FILE_PATH = "C:\\Users\\Marcin_Zakidalski@epam.com\\workspace\\AlgoStandford_Jobs\\src\\jobs.txt";
	
	private static ScheduleElement[] readFile(String fileName) throws FileNotFoundException {
		try  (Scanner scanner = new Scanner(new File (fileName)) ){
			int numOfElems = scanner.nextInt();
			ScheduleElement[] result = new ScheduleElement[numOfElems];
			
			for (int i=0; i<numOfElems; ++i) {
				long weight = scanner.nextLong();
				long length = scanner.nextLong();
				result[i] = new ScheduleElement(weight, length);
			}
			return result;
		} 
	}
	
	private static long computeWeightedEndTime(ScheduleElement[] fileData) {
		long result = 0;
		long currentEndTime = 0;
		
		for (int i =0; i< fileData.length;++i) {
			currentEndTime += fileData[i].getLength();
			result += currentEndTime*fileData[i].getWeight();
		}
		return result;
	}
	
	private static void printSolution(ScheduleElement[] fileData) {
		int i=1;		
		for (ScheduleElement elem : fileData) {
			System.out.println(i+" "+elem);
			++i;
		}
		
		System.out.println("\n\n");		
	}
	
	public static void getWeightMinusLengthSolution(String fileName) throws FileNotFoundException {
		ScheduleElement[] fileData = readFile(fileName);
				
		System.out.println("\n\n ->> Weight minus length solution ");
		Arrays.sort(fileData, (ScheduleElement elemFirst,ScheduleElement elemSecond) -> 
								{
									long valueToCompare =  elemSecond.getWeightMinusLength() - elemFirst.getWeightMinusLength() ;
									if (valueToCompare != 0) {
										return (int)Math.signum(valueToCompare);
									} else {
										return (int)(elemSecond.getWeight() - elemFirst.getWeight());
									}
								});

		//printSolution(fileData);

		long computedWeight = computeWeightedEndTime(fileData);
		System.out.println("weight minus length ->"+computedWeight);
		
	}
	
	public static void getWeightDivSolution(String fileName) throws FileNotFoundException {
		ScheduleElement[] fileData = readFile(fileName);
		
		System.out.println("\n\n ->> Weight divided by length solution ");
		Arrays.sort(fileData, (ScheduleElement elemFirst,ScheduleElement elemSecond) -> 
								{
										double valueToCompare =  elemSecond.getWeightDivLength() - elemFirst.getWeightDivLength() ;
										return (int)Math.signum(valueToCompare);
								});

		//printSolution(fileData);

		long computedWeight = computeWeightedEndTime(fileData);
		System.out.println("weight divided by length ->"+computedWeight);
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		getWeightMinusLengthSolution(FILE_PATH);
		getWeightDivSolution(FILE_PATH);
		
	}

}
