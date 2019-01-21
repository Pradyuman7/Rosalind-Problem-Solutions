//http://rosalind.info/problems/splc/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RNASplicing {
	
	static String dna = "";

	public static void main(String[] args) {

		//handle input as text file
		String fileName = "/Users/pd/Documents/splc.txt";
		String label = null;
		ArrayList<String> introns = new ArrayList<String>();

		try {
			FileReader fileReader =  new FileReader(fileName);
			BufferedReader br = new BufferedReader(fileReader);
			
			 label = br.readLine(); //ignore first line as dna label is unimportant
			 dna = br.readLine();
			
			//loop over all provided introns (can be any # of them), and ignore labels
			while((label = br.readLine()) != null) 
				introns.add(br.readLine()); //line after label is the desired intron dna sequence
			
			//splice introns one-by-one
			for (int i = 0; i < introns.size(); i++) 
				splice(introns.get(i));
			
			String rna = transcribe(); 		//transcribe DNA into mRNA
			String protein = translate(rna);	//translate mRNA into Protein
			System.out.println(protein);
			br.close();         
		}
		catch(FileNotFoundException ex) {
			System.out.println(	"Cannot find file '" + fileName + "'");                
		}
		catch(IOException ex) {
			System.out.println( "Error reading file '" + fileName + "'");                  
		}

	}
	
	//check for intron in dna strand and 'splice'
	public static void splice(String intron) {
		for (int i = 0; i <= (dna.length() - intron.length()); i++) {
			if(dna.charAt(i) == intron.charAt(0)) {
				if(dna.substring(i, i+intron.length()).equals(intron)) {
					String tmp = dna;
					dna = tmp.substring(0, i) + tmp.substring(i+intron.length());
				}
			}
		}
	}
	
	//transcribe DNA to mRNA
	public static String transcribe(){
		String rna = "";
		for (int i = 0; i < dna.length(); i++) {
			if(dna.charAt(i) == 'T')
				rna += 'U';
			else
				rna += dna.charAt(i);
		}
		return rna;
	}
	
	//translate RNA to protein
	public static String translate(String rna) {
		String protein = "";
		int i;
		//look for start codon AUG to begin protein translation
		for (i = 0; i <= rna.length()-3; i++) {
			if(rna.substring(i,i+3).equals("AUG")) {
				protein += 'M';	
				break;
			}	
		}
		//check that start codon was actually found
		if(i < rna.length()-3) {
			boolean stop = false; //set true if stop codon is found
			//go through codons one at a time
			for(i = i + 3; i <= rna.length()-3 && !stop; i += 3) {
				String codon = rna.substring(i, i+3);
				
				//manually coded codon table
				switch(codon) {
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
		return protein;
	}

}
