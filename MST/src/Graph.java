
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Graph {

	private Scanner input;
	private int numVertices;
	private int numEdges;
	private int directed;
	private int weighted;
	private Node[] array;


	private class Node {
		private Node next;
		private int vertex;
		private float weight;
		private boolean discovered = false;

		public Node(Node next, int vertex) {
			this.next = next;
			this.vertex = vertex;

		}

		public Node(Node next, int vertex, float weight) {
			this.next = next;
			this.vertex = vertex;
			this.weight = weight;

		}
	}

	private class Edge {
		private int start;
		private int destination;
		private float weight;
		
		public Edge(int s, int d, float w) {
			this.start = s;
			this.destination = d;
			this.weight = w;
		}
	}
	
	public void createArray(String s) throws FileNotFoundException {
		input = new Scanner(new File(s));
		numVertices = input.nextInt();
		numEdges = input.nextInt();
		directed = input.nextInt();
		weighted = input.nextInt();

		//Changed the size of the array I created from numEdges to numVertices
		//because if there are more vertices than edges our array isn't big enough
		//and it throws an exception
		array = new Node[numVertices];

		for (int i = 0; i < numVertices; i++) {
			array[i] = new Node(null, i);
		}
	}

	public void makeAdjacencyList() {
		if (weighted == 1) {

			if (directed == 1) {
				
					while (input.hasNext()) {
						int vertex = input.nextInt();
						int vertex1 = input.nextInt();
						float weight = input.nextFloat();

						Node node = array[vertex];

						if (node.next != null) {
							Node after = node.next;
							node.next = new Node(after, vertex1, weight);
						} else {
							node.next = new Node(null, vertex1, weight);
						}
					}
				
			} else {

				while (input.hasNext()) {
					int vertex = input.nextInt();
					int vertex1 = input.nextInt();
					float weight = input.nextFloat();

					Node node = array[vertex];

					if (node.next != null) {
						Node after = node.next;
						node.next = new Node(after, vertex1, weight);
					} else {
						node.next = new Node(null, vertex1, weight);
					}

					Node node1 = array[vertex1];

					if (node1.next != null) {
						Node after = node1.next;
						node1.next = new Node(after, vertex, weight);
					} else {
						node1.next = new Node(null, vertex, weight);
					}

				}
			}

		} else {

			if (directed == 1) {

				while (input.hasNext()) {
					int vertex = input.nextInt();
					int vertex1 = input.nextInt();

					Node node = array[vertex];

					if (node.next != null) {
						Node after = node.next;
						node.next = new Node(after, vertex1);
					} else {
						node.next = new Node(null, vertex1);

					}
				}

			} else {

				while (input.hasNext()) {
					int vertex = input.nextInt();
					int vertex1 = input.nextInt();

					Node node = array[vertex];

					if (node.next != null) {
						Node after = node.next;
						node.next = new Node(after, vertex1);
					} else {
						node.next = new Node(null, vertex1);
					}

					Node node1 = array[vertex1];

					if (node1.next != null) {
						Node after = node1.next;
						node1.next = new Node(after, vertex);
					} else {
						node1.next = new Node(null, vertex);
					}

				}

			}
		}

	}

	public void printAdjacencyList() {

		if (weighted == 0) {


			for (int i = 0; i < numVertices; i++) {

				System.out.print(array[i].vertex + ": ");

				Node node = array[i];

				while (node.next != null) {
					System.out.print(node.next.vertex + " ");
					node = node.next;
				}
				System.out.println();

			}
			System.out.println();
		} else {

			for (int i = 0; i < numVertices; i++) {

				System.out.print(array[i].vertex + ": ");

				Node node = array[i];

				while (node.next != null) {
					System.out.print(node.next.vertex + "," + node.next.weight + " ");
					node = node.next;
				}
				System.out.println();

			}
			System.out.println();
		}

	}

	private boolean contains(int arrayIndex, int t) {
		Node n = array[arrayIndex];
		while(n.next != null) {
			if(n.next.vertex == t) {
				return true;
			} else {
				n = n.next;
			}
		}
		return false;
	}
	public void BreathFirstSearch() {
		
		LinkedList<Integer> list = new LinkedList<Integer>(); 
		boolean discovered[] = new boolean[numVertices];
		boolean processed[] = new boolean[numVertices];
		//added a nested if else statement asking if directed or undirected in order to remove duplicates
		int currentIndex = 0;
		if(directed == 1) {
		for (int i = 0; i < numVertices; i++) {
			System.out.println("Process " + array[currentIndex].vertex + " early");
			list.add(array[currentIndex].vertex);
			Node n = array[currentIndex];
			while (n.next != null) {
				if(!discovered[n.next.vertex]) {
					System.out.println("Process " + currentIndex + " " + n.next.vertex + " (Tree Edge)");
					list.add(n.next.vertex);
					
					n = n.next;
					discovered[currentIndex] = true;
				} else {
					boolean cross = false;
					for(int j = n.vertex - 1; j >= 0; j--) {
						if(contains(j, n.vertex) && contains(j, n.next.vertex)) {
							cross = true;
							break;
						}
					}
					if(cross) {
						System.out.println("Process edge " + currentIndex + " " + n.next.vertex + " (Cross Edge)");
					} else {
						System.out.println("Process edge " + currentIndex + " " + n.next.vertex + " (Back Edge)");
					}
					list.add(n.next.vertex);
					n = n.next;
					discovered[currentIndex] = true;
				}
			}
			System.out.println("Process " + array[currentIndex].vertex + " late");
			processed[array[currentIndex].vertex] = true;
			currentIndex = list.remove();
			
			while(discovered[currentIndex] && !list.isEmpty()) {
				currentIndex = list.remove();
				try {
					if (currentIndex > list.peek() && !processed[list.peek()]) {
						currentIndex = list.remove();
					}
				} catch (Exception e) {
				
				}
			}
			while (processed[currentIndex] && currentIndex < array.length - 1) {
				currentIndex++;
			}
		}
		} else 
		
		{
			Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < numVertices; i++) {
			System.out.println("Process " + array[i].vertex + " early");
			list.add(array[currentIndex].vertex);
			Node n = array[currentIndex];
			discovered[i] = true;
			while (n.next != null) {
				if(!discovered[n.next.vertex]) {
					if(!stack.contains(n.next.vertex)) {
						System.out.println("Process edge " + currentIndex + " " + n.next.vertex + " (Tree Edge)");
					}
					list.add(n.next.vertex);
					discovered[n.next.vertex] = true;
					n = n.next;
				} else {
					if(!stack.contains(n.next.vertex)) {
						System.out.println("Process edge " + currentIndex + " " + n.next.vertex + " (Cross Edge)");
					}
					list.add(n.next.vertex);
					n = n.next;
				}
			}
			System.out.println("Process " + array[currentIndex].vertex + " late");	
			processed[array[currentIndex].vertex] = true;
			stack.push(array[currentIndex].vertex);
			currentIndex = list.remove();
			
			while(processed[currentIndex] && !list.isEmpty()) {
				currentIndex = list.remove();
				try {
					if(currentIndex > list.peek() && !processed[list.peek()]) {
						currentIndex = list.remove();
					}
				} catch (Exception e) {
					
				}
			}
			while(processed[currentIndex] && currentIndex < array.length - 1) {
				currentIndex++;
			}
			}
		}
	}

	private void DepthFirstSearch(int currentIndex, int old, Stack<Integer> stack, Stack<Integer> processed, 
			Node n, ArrayList<String> flip, ArrayList<Integer> visited, Set<Integer>[] children) {
		
		String string = "";
		String f = "";
		
		if(n != null) {
			string = currentIndex + "" + n.next.vertex;
			
			f = n.next.vertex + "" + currentIndex;
		}
		if(directed == 0 && stack.size() == numVertices) {
			int i = stack.size();
			while( i > 0) {
				int x = stack.pop();
				System.out.println("Process " + x + " Late");
				i--;
			}
		} else if (old == -1 && currentIndex == -1) {
			
		} else if (!n.discovered && !stack.contains(n.vertex)) {
			System.out.println("Process " + currentIndex + " early");
			n.discovered = true;
			stack.push(currentIndex);
			
			n = array[currentIndex];
			DepthFirstSearch(currentIndex, old, stack, processed, n, flip, visited, children);
		
		} else if ( n.next != null && !flip.contains(string) && !n.next.discovered) {
			System.out.println("Process edge " + currentIndex + " " + n.next.vertex);
			n.next.discovered = true;
			visited.add(currentIndex);
			flip.add(f);
		
			if(directed == 1) {
				if(!visited.contains(n.next.vertex)) {
					children[currentIndex].add(n.next.vertex);
					for(int i = 0; i < numVertices; i++) {
						if(children[i].contains(currentIndex)) {
							children[i].add(n.next.vertex);
						}	
					}
				System.out.println(" (Tree Edge)");
			} else if((children[currentIndex].contains(n.next.vertex) || children[n.next.vertex].contains(currentIndex)) && currentIndex < n.next.vertex) {
				System.out.println(" (Forward Edge)");
			} else if((children[currentIndex].contains(n.next.vertex) || children[n.next.vertex].contains(currentIndex)) && currentIndex > n.next.vertex) {
				System.out.println(" (Backward Edge)");
			} else {
				System.out.println(" (Cross Edge)");
			}
		} else {
			if(!visited.contains(n.next.vertex)) {
				System.out.println(" (Tree Edge)");
			} else { 
				System.out.println(" (Back Edge)");
			}
		}
		if(!processed.contains(n.next.vertex) && !visited.contains(n.next.vertex)) {
			old = currentIndex;
			currentIndex = n.next.vertex;
			n = array[currentIndex];
		} else {
			
		}
		DepthFirstSearch(currentIndex, old, stack, processed, n, flip, visited, children);
	} else if (n.next == null || (processed.contains(n.next.vertex) || stack.contains(n.next.vertex)) && n.next.next == null) {
		int x = stack.pop();
		System.out.println("Process " + x + " Late");
		processed.push(x);
		try {
			currentIndex = stack.peek();
		} catch (Exception e) {
			currentIndex = -1;
		}
		try {
			old = stack.get(stack.indexOf(currentIndex) - 1);
			
		}catch (Exception e) {
			old = -1;
		}
		if(currentIndex < 0) {
			n = null;
		} else {
			n = array[currentIndex];
		}
		DepthFirstSearch(currentIndex, old, stack, processed, n, flip, visited, children);
		
	} else if(n.next.next != null) {
		n = n.next;
		DepthFirstSearch(currentIndex, old, stack, processed, n, flip, visited, children);
	}
}

	public void DepthFirstSearch() {
		
		int currentIndex = 0;
		int old = 0;
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> processed = new Stack<>();
		Node n = array[0];
		ArrayList<String> flip = new ArrayList<String>();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		Set<Integer> children[] = new HashSet[numVertices];
		
		for (int i = 0; i < numVertices; i++) {
			children[i] = new HashSet<Integer>();
			children[i].add(i);
		}
		DepthFirstSearch(currentIndex, old, stack, processed, n, flip, visited, children);
	}
	
	public void MinimumSpanningTree() {
		if(weighted == 0 || directed == 1) {
			System.out.println("Not applicable for non-weighted/directed graphs.");
		} else {
			PriorityQueue<Edge> sort = new PriorityQueue<Edge>(numVertices - 1, Comparator.comparingDouble(o -> o.weight));
			Set<Integer> set[] = new HashSet[numVertices];
			
			for(int i = 0; i < numVertices; i++) {
				Node n = array[i];
				set[i] = new HashSet<Integer>();
				set[i].add(i);
				
				float total = 0;
				while(n.next != null) {
					Edge e = sort.poll();
					if (!set[e.start].contains(e.destination)) {
						System.out.println("Edge (" + e.start + "," + e.destination + ") weight = " + e.weight);
						total += e.weight;
					}
					set[e.start].add(e.destination);
					set[e.destination].add(e.start);
					set[e.start].addAll(set[e.destination]);
					set[e.destination].addAll(set[e.start]);
					
					for(int num : set[e.start]) {
						set[num].addAll(set[e.start]);
					}
				}
				System.out.println("MST Cost = " + total);
			}
		}
	}

	
}

