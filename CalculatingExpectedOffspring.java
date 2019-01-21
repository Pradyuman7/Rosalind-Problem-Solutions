//http://rosalind.info/problems/iev/

import java.util.Scanner;

public class CalculatingExpectedOffspring {
	
	public static void main(String[] args) {
		
		System.out.println("Enter");
		
		Scanner sc = new Scanner(System.in);
		
		String[] s = sc.nextLine().split(" ");
		
		int[] input = new int[6];
		for (int i = 0; i < s.length; i++) 
			input[i] = Integer.parseInt(s[i]);		
		
		System.out.println( 2* (input[0] + input[1] + input[2] + input[3]*0.75 + input[4]*0.5) );
	}

}
