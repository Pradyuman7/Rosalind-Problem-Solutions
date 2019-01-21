//http://rosalind.info/problems/gc/

import java.io.*;

public class ComputingGCContent {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String currentID = "";
		String currentDNA = "";
		double currentGC = 0;
		String topID = "";
		double topGC = 0;
		boolean firstTime = true;
		
		//input is up to 10 strings in FASTA format, i.e. 2-20 lines
		while ( true ) {
			String s = br.readLine();
			
			if(s.length() == 0) {
				if(currentGC > topGC) {
					topGC = currentGC;
					topID = currentID;
				}
				System.out.println(topID);
				System.out.println(topGC);
				return;
			}
			
			if(s.charAt(0) == '>') {
				currentDNA = "";
				if(firstTime) {
					firstTime = false;
					currentID = s.substring(1);
				}
				else {
					if(currentGC > topGC) {
						topGC = currentGC;
						topID = currentID;
					}
					currentID = s.substring(1);
				}	
			}
			
			else {
				currentDNA += s;
				currentGC = gc(currentDNA);
			}
		}	
	}
	
	public static double gc(String s) {
		int gc = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'G' || s.charAt(i) == 'C')
				gc++;
		}
		return ( gc/(double)s.length() )*100;
	}
}
