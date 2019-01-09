
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		String s1 = "src/Graph 1.txt";

		Graph g1 = new Graph();

		Graph run = new Graph();
		run.createArray(s1);
		run.makeAdjacencyList();
		
		Scanner in = new Scanner(System.in);
		int x = 0;
		
		while(x != 5) {
			System.out.println();
			System.out.println("1-Print the adjacency List");
			System.out.println("2-BFS");
			System.out.println("3-DFS");
			System.out.println("4-MST");
			System.out.println("5-Exit");
			System.out.println();
			x = in.nextInt();
			if(x < 1 || x > 5) {
				System.out.println("Invalid Input");
			} else if (x==1) {
				run.printAdjacencyList();
			} else if (x==2) {
				run.BreathFirstSearch();
			} else if (x==3) {
				run.DepthFirstSearch();
			} else if (x==4) {
				run.MinimumSpanningTree();
			}
		}
		in.close();
		
		/*g1.createArray(s1);
		g1.makeAdjacencyList();
		g1.printAdjacencyList();
		g1.BreathFirstSearch();
		System.out.println();
		g1.DepthFirstSearch();*/
		
		
	}
}
