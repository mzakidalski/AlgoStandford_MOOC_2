package com.zaki.PrimAlgorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PrimBasic {
	
	private final static String FILE_NAME = "C:\\Users\\Marcin_Zakidalski@epam.com\\workspace\\AlgoStandford_Jobs\\src\\edges.txt";
	public static void main(String[] args) throws FileNotFoundException {
		File inputData = new File(FILE_NAME);
		Scanner scanner = new Scanner(inputData);
		int nodes = scanner.nextInt();
		int edges = scanner.nextInt();
		
		SimplePrimGraph graph = new SimplePrimGraph(nodes);
		
		while (scanner.hasNextInt()) {
			int first = scanner.nextInt();
			int second = scanner.nextInt();
			long weight = scanner.nextLong();			
			graph.addEdge(first, second, weight);
		}

		for (int i=1; i <=graph.getSize(); ++i) {
			graph.getMinSpanningTree(i);
			System.out.println(graph.getEdgesInMST());
			System.out.println(i+" minimum spanning tree = "+graph.getMinimumTreeLength());
			
		}





		
	}

}
