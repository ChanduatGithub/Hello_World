import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class Mutect {

	public static void main(String[] args) throws IOException,NullPointerException {
		
		

		FileReader fr = new FileReader("/home/chandu/mutect_immediate.vcf");
		BufferedReader bufr = new BufferedReader(fr); 
		FileWriter fw=new FileWriter("/home/chandu/accepted.xls");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write("CHROM	POS	ID	REF	ALT	QUAL	FILTER	INFO	FORMAT	none	LungCancer \n");
		
		
		String line="#";
		
		
		String check,start,end;
		try
		{
		while(line != null)
		{
			line = bufr.readLine(); 
			
			if(line.charAt(0)=='#')
			{
				//System.out.println(line);
				
			}
			else
			{
				
				String[] s1=line.split("\\t");
				check=s1[1];
	

				FileReader fr1 = new FileReader("/home/chandu/truseq.bed");
				BufferedReader bufr1 = new BufferedReader(fr1); 
				String line1="ab";
				
				while(line1 != null)
				{
					line1 = bufr1.readLine(); 
					
					if(line1!=null)
					{
						String[] s2=line1.split("\\t");
				
						start=s2[1];
						end=s2[2];
						
		
						if(s1[0].equals(s2[0]))
						{
				
							
							if(Integer.parseInt(start)<Integer.parseInt(check) && Integer.parseInt(check)<Integer.parseInt(end))
							{
										
								bw.write(s1[0]+"	"+s1[1]+"	"+s1[2]+"	"+s1[3]+"	"+s1[4]+"	"+s1[5]+"	"+s1[6]+"	"+s1[7]+"	"+s1[8]+"	"+s1[9]+"\n");
								
							}
						
						}
					
					}
					
				
			}
				bufr1.close();
				
				
			}
		}
		}
		catch(NullPointerException e1)
		{
			bufr.close();
			

			//System.out.println(e);
		}
		
					
	}

}
