//http://rosalind.info/problems/dna/  &  http://rosalind.info/problems/ini/

import java.util.Scanner;

public class CountingNucleotides {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(output(s));
	}
	
	public static String output(String s){
		int A = 0;
		int C = 0;
		int G = 0;
		int T = 0;
		for (int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)){
			case 'A' : A++; break;
			case 'C' : C++; break;
			case 'G' : G++; break;
			case 'T' : T++; break;
			}
		}
		String v = A + " " + C + " "+ G+ " " + T;
		return v;
	}

}
