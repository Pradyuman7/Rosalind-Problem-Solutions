//http://rosalind.info/problems/lia/


import java.math.BigInteger;
import java.util.Scanner;

public class IndependentAlleles {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split(" ");
		int k = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);
		
		int organisms = (int) Math.pow(2, k); //kth generation has 2^k organisms
		double tempProb = 0;
		double totalProb = 0;
		
		//outer loop deals with the 'for each' clause, i.e. can be n or more heterozygous hybrid
		for(int i = n; i <= organisms; i++) {
			//inner loop simulates bernoulli trial
			int nCk = Integer.parseInt(choose(organisms, i).toString());
			for(int j = 0; j < nCk; j++)
				tempProb += ( Math.pow(0.25, i) * Math.pow(0.75, organisms - i) );
			totalProb += tempProb;
			tempProb = 0; //reset for next instance of N
		}
		
		totalProb = (double)Math.round(totalProb * 1000d) / 1000d; //round to 3 decimal places for rosalind to accept
		System.out.println(totalProb);
	}
	
	//since we are dealing with potentially huge numbers, use BigInteger class
	public static BigInteger factorial(BigInteger n) {
	       BigInteger fact = new BigInteger("1");
	       for (int i = 1; i <= Integer.parseInt(n.toString()); i++) {
	           fact = fact.multiply(new BigInteger(i + ""));
	       }
	       return fact;
	   }
	
	//simulate nCk
	public static BigInteger choose(int n, int k) {
		//use BigInteger class for dealing with huge numbers (results of factorials)
	       BigInteger n1 = new BigInteger(n+"");
	       BigInteger k1 = new BigInteger(k+"");
	       BigInteger numerator = factorial(n1);
	       BigInteger difference = n1.subtract(k1);
	       BigInteger denominator = factorial(k1).multiply(factorial(difference));
	       return numerator.divide(denominator);

	}

}
