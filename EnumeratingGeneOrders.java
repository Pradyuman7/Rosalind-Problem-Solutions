//http://rosalind.info/problems/perm/

import java.util.Arrays;
import java.util.Scanner;

public class EnumeratingGeneOrders {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(factorial(n)); //number of permutations is n!
		
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++)
			arr[i] = i+1;
		
		permutations(n,arr);
	}
	
	//calculate factorial using recursion
	public static int factorial(int n) {
		if (n <= 1)
			return 1;
		else
			return n * factorial(n-1);
	}
	
	static void permutations(int n, int [] array)
	{
	    if (n == 1) {
	        for (int i = 0; i < array.length; i++) 
			System.out.print(array[i]+ " ");
			
	        System.out.println();
	        return;
	    }
	    for (int i = 0; i < n; i++) {
	        permutations(n - 1, array);
	        if ((n & 1) == 0) {
	            int tmp = array[i];
	            array[i]   = array[n-1];
	            array[n-1] = tmp;
	        } else {
	            int tmp = array[0];
	            array[0]   = array[n-1];
	            array[n-1] = tmp;
	        }
	    }
	}
}
