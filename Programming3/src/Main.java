import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException{
		SubsetBacktracking b = new SubsetBacktracking();
		PermutationBacktracking t = new PermutationBacktracking();
		
		Scanner in = new Scanner(System.in);
		int x = 0;
		int input = 0;
		
		while(x!=3) {
			System.out.println("Choose one of the following options: ");
			System.out.println("1- Subset");
			System.out.println("2- Permutation");
			System.out.println("3- Exit");
			x = in.nextInt();
			if(x<1 || x>3) {
				System.out.println("Invalid Input");
			} else if(x==1) {
				//subset
				System.out.println("Choose a number larger than 1: ");
				input = in.nextInt();
				b.backtrack(input);
				System.out.println();
				System.out.println();
			} else if(x==2) {
				//permutation
				System.out.println("Choose a number larger than 1: ");
				input = in.nextInt();
				t.backtrack(input);
				System.out.println();
				System.out.println();
			}
		}
		
		in.close();
	}
}
