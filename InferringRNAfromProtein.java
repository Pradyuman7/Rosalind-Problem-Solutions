//http://rosalind.info/problems/mrna/

import java.util.Scanner;

public class InferringRNAfromProtein {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String protein = sc.nextLine();
		int possibleRNAstrings = 1;
		for(int i = 0; i < protein.length(); i++) {
			possibleRNAstrings *= codons(protein.charAt(i));
			if (possibleRNAstrings > 1000000) possibleRNAstrings %= 1000000;  //final answer should be mod 1 mil
		}
		
		if(possibleRNAstrings > 0)
			System.out.println((3*possibleRNAstrings)%1000000); //add 3 stop codons as last element not present in protein string
		else
			System.out.println("ERROR: Unrecognized Protein");
		
		
	}
	
	//return number of possible RNA codons for each protein
	public static int codons(char c) {
		switch(c) {
		case 'M': case 'W' : return 1;
		case 'F': case 'D': case 'E': case 'Y': case 'C': case 'H': case 'Q': case 'N': case 'K': return 2;
		case 'I': return 3;
		case 'P': case 'T': case 'V': case 'A': case 'G': return 4;
		case 'L': case 'S': case 'R': return 6;
		default: return -1;
		}
	}

}
