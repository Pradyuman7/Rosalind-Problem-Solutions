//http://rosalind.info/problems/rna/

import java.util.Scanner;

public class TranscribingDNAintoRNA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(output(s));
	}
	
	public static String output(String dna){
		String rna = "";
		for (int i = 0; i < dna.length(); i++) {
			if(dna.charAt(i) == 'T')
				rna += 'U';
			else
				rna += dna.charAt(i);
		}
		return rna;
	}
}
