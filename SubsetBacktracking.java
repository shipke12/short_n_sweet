
public class SubsetBacktracking {
	
	
	public void backtrack(int size) {
		boolean[] finished = new boolean[size];
		int index = 0;
		int numbers[] = new int[size];
		for(int i = 0; i<size; i++) {
			numbers[i] = i+1;
		}
		backtrack(finished, size, index, numbers);
	}
	
	private void backtrack(boolean finished[], int size, int index, int numbers[]) {
	
		if(index==size) {
			System.out.print("(");
			for(int i = 0; i<size; i++) {
				if(finished[i]) {
					System.out.print(numbers[i]);
				} else {
					System.out.print("-");
				}
			}
			System.out.print(")");
			//sets index back 1 and skips the last recursion call
			return;
		}
		//go through setting all to true
		finished[index] = true;
		backtrack(finished, size, index+1, numbers); 
		
		//set each one false at one point
		finished[index]= false;
		backtrack(finished, size, index+1, numbers);
	}		
}