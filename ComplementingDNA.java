//http://rosalind.info/problems/revc/

import java.util.Scanner;

public class ComplementingDNA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String dna = sc.nextLine();
		System.out.println(output(dna));
	}

	public static String output(String dna){
		String reverse = "";
		for(int i = dna.length()-1; i >= 0; i--)
			reverse += dna.charAt(i);
		String result = "";
		for (int i = 0; i < reverse.length(); i++) {
			switch(reverse.charAt(i)){
			case 'A' : result += 'T'; break;
			case 'C' : result += 'G'; break;
			case 'G' : result += 'C'; break;
			case 'T' : result += 'A'; break;
			}
		}
		return result;
	}

}
