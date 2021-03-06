public class test1 {

	public static void main(String[] args) {
		
		int[] input = {1, 8, 2, 3, 5, 7}; // inputs to the system
		int sum = 10; // sum can be customized  
		int[] expected = {8, 2, 3, 7};
		
		pair_finder finderObject = new pair_finder(input, sum); // creating an new object 
		
		finderObject.finder(); // calling the method to find the pairs 
		finderObject.pair_tester(expected); // Unit test to verify the answer 
		
	}
	
}

public class pair_finder {
	
	private int[] input; 
	private int sum; 
	private int[] output = new int[0];
	private int size_of_output = 0;
	private int output_count = 0;
	
	public pair_finder(int[] array1, int check_sum){
		
		input = new int [array1.length]; // constructor initializing the input array.
		
		for(int i = 0; i < array1.length ; i++){			
			input[i] = array1[i];
		}		
		
		sum = check_sum; 	 //constructor initializing the sum. 
	}
	
	public void finder(){
		
		for(int i = 0; i < input.length; i++) {
			for(int j =i +1; j < input.length; j++) {
				if(input[i] + input[j] == sum) {
					output_count = output_count + 2;
					output_printer(input[i], input[j]); // employees nested for loops to find the pairs. 
					output_store(input[i], input[j]);
				}
			}
		}
	}
	
	public void output_printer(int a , int b){
		
		System.out.println(a +" and " + b + " adds upto " + sum); // printer method outputting the results. 
	}
	
	public void output_store (int a, int b) {
		
		size_of_output = size_of_output + 2;
		int[] new_output = new int [size_of_output];// dynamically allocating an array to store the results 
		
		for(int i = 0; i<output.length; i++) {
		new_output[i] = output[i];	
		}
		
		new_output[output.length] = a;
		new_output[output.length+1] = b;
		
		output = new_output;	// updating the output array
		
	}
	
	public void output_array_printer() {
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i]); // method to print the output 
		}
	}
	
public void pair_tester(int[] expected_values) { // unit test for the output
		for(int i = 0; i < expected_values.length; i++) {
			if(output[i] != expected_values[i]) {
				System.out.println("Error:");
				return;
			}				
		}
		System.out.println("Output is as expected");
	}
}

