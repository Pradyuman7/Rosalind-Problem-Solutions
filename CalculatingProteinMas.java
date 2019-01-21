//http://rosalind.info/problems/prtm/

import java.util.Scanner;

public class CalculatingProteinMas {

	//monoisotopic mass table
	static char[] proteins = new char[] {'A','C','D','E','F','G','H','I','K','L','M','N','P','Q','R','S','T','V','W','Y'};
	static double[] weights = new double[] {71.03711,103.00919,115.02694,129.04259,147.06841,57.02146,137.05891,113.08406,128.09496,113.08406,131.04049,114.04293,97.05276,128.05858,156.10111,87.03203,101.04768,99.06841,186.07931,163.06333};


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String protein = sc.nextLine();
		double mass = 0;

		for (int i = 0; i < protein.length(); i++) {
			char symbol = protein.charAt(i);
			int index = getIndex(symbol);
			mass += weights[index];
		}
		
		//add mass of water?
		//mass += 18.01056;
		
		mass = (double)Math.round(mass * 1000d) / 1000d; //round to 3 decimal places for rosalind to accept
		System.out.println(mass);
	}

	public static int getIndex(char c) {
		for (int i = 0; i < proteins.length; i++) {
			if(proteins[i] == c)
				return i;
		}
		return -1;
	}

}
