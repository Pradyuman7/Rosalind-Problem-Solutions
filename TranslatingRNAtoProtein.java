//http://rosalind.info/problems/prot/

import java.util.Scanner;

public class TranslatingRNAtoProtein {
	
	static boolean stop = false;
	static String protein = "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s = findStart(s);
		for (int i = 0; i <= s.length()-3; i+=3) {
			if(stop) break;
			translate(s.substring(i,i+3));
		}
		System.out.println(protein);
	}
	
	public static String findStart(String s) { //start codon is AUG
		int tally = 0; //how many desired codons found in correct order so far
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			switch(s.charAt(i)) {
			case 'A': if(tally == 0) tally++; else tally = 0; break;
			case 'U': if(tally == 1) tally++; else tally = 0; break;
			case 'G': if(tally == 2) {protein += "M"; return s.substring(i+1);} else tally = 0; break;
			}
		}
		return result;
	}
	
	//manually coded codon table
	public static void translate(String s) {
		switch(s) {
		case "AUG": protein += "M"; break;
		case "UGG": protein += "W"; break;
		case "UUU": case "UUC": protein+="F"; break;
		case "GAU": case "GAC": protein+="D"; break;
		case "GAA": case "GAG": protein+="E"; break;
		case "UAU": case "UAC": protein+="Y"; break;
		case "UGU": case "UGC": protein+="C"; break;
		case "CAU": case "CAC": protein+="H"; break;
		case "CAA": case "CAG": protein+="Q"; break;
		case "AAU": case "AAC": protein+="N"; break;
		case "AAA": case "AAG": protein+="K"; break;
		case "AUU": case "AUC": case "AUA": protein+="I"; break;
		case "CCU": case "CCC": case "CCA": case "CCG": protein+="P"; break;
		case "ACU": case "ACC": case "ACA": case "ACG": protein+="T"; break;
		case "GUU": case "GUC": case "GUA": case "GUG": protein+="V"; break;
		case "GCU": case "GCC": case "GCA": case "GCG": protein+="A"; break;
		case "GGU": case "GGC": case "GGA": case "GGG": protein+="G"; break;
		case "UUA": case "UUG": case "CUU": case "CUC": case "CUA": case "CUG": protein+="L"; break;
		case "UCU": case "UCC": case "UCA": case "UCG": case "AGU": case "AGC": protein+="S"; break;
		case "CGU": case "CGC": case "CGA": case "CGG": case "AGA": case "AGG": protein+="R"; break;
		default: stop = true;
		}
	}
}
