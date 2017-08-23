import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JavaParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr;
		BufferedReader br;
		FileWriter fw;
		BufferedWriter bw=null;
		int flag=0,opencount=0,closecount=0;
		 try {
			 fr=new FileReader("/root/Desktop/datatest.txt");
			 br=new BufferedReader(fr);
			 fw=new FileWriter("/root/Desktop/outputt.txt");
			 bw=new BufferedWriter(fw);
			 String input;
			 String output[]=new String[100];
			 String endstr[]=new String[2];
			 output[0]="set";
			 int j=1;
			 String arr[]=new String[15];
			 while((input=br.readLine())!=null)
			 {
				 String after = input.trim().replaceAll(" +", " ");
				 System.out.println("String::"+after);
				 arr=after.split("//s");
				 System.out.println("After splitting");
				 for(String s:arr)
				 {
					 if((!s.endsWith(";"))&&(!s.contains("{"))&&(!s.contains("}")))
					 {
						 output[j]=" "+s;
						 j++;
					 }
					 else if(s.contains("{"))
					 {
						 
					 }
					 else if(s.contains("}"))
					 {
						 System.out.println(output.length);
						 output[output.length-1]="";
					 }
					 else
					 {
						 if(s.endsWith(";"))
						 {
							endstr=s.split(";"); 
							output[j]=" "+endstr[0];
							j++;
							for(int i=0;i<output.length;i++)
							{
								bw.write(output[i]);
							}
						 }
					 }
				 }
			 }
		 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 finally
		 {
			 try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }

	}

}
