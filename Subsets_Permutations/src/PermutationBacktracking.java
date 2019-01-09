
public class PermutationBacktracking {

	public void backtrack(int size) {
		int index = 0;
		int numbers[] = new int[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = i + 1;
		}
		backtrack(size, index, numbers);
	}

	private void backtrack(int size, int index, int numbers[]) {

		if (index == size-1) {
			System.out.print("(");
			for (int i = 0; i < size; i++) {
				System.out.print(numbers[i]);
			}
			System.out.print(")");
		} else {

			for (int i = index; i < size; i++) {
				//swap index with i
				int temp = numbers[i];
				numbers[i] = numbers[index];
				numbers[index] = temp;
				backtrack(size, index + 1, numbers);
				//swap index with i
				int temp2 = numbers[i];
				numbers[i] = numbers[index];
				numbers[index] = temp2;
			}
		}
	}
}
