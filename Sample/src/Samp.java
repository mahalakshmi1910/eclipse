import java.io.*;
import java.util.*;
public class Samp {

	public static void main(String args[])
	{
		FileReader fr;
		BufferedReader br;
		FileWriter fw;
		BufferedWriter bw=null;
		int flag=0,opencount=0,closecount=0;
		 try {
			 fr=new FileReader("/root/Desktop/datatest.txt");
			 br=new BufferedReader(fr);
			 fw=new FileWriter("/root/Desktop/output.txt");
			 bw=new BufferedWriter(fw);
			String input;
			String strarr[]=new String[15];
			String endstring[]=new String[2];
			StringBuffer sb=new StringBuffer("set");
			while((input=br.readLine())!=null)
			{
				 String after = input.trim().replaceAll(" +", " ");
				flag=0;opencount=0;closecount=0;
				//System.out.println(input);
				strarr=after.split("\\s");
				for(String s:strarr)
				{
					if((!s.endsWith(";"))&&(!s.contains("{"))&&(!s.contains("}")))
					{
						System.out.println("Inside Main If");
						flag=0;
						sb.append(" "+s);
					}
					else if(s.contains("{"))
					{
						opencount++;
					}
					else if(s.contains("}"))
					{
						closecount++;
						String sw=new String(sb);
						sb.delete(sb.lastIndexOf("\\s")+1,sb.length());
					}
					else
					{	
						System.out.println("String::"+s);
					if(s.endsWith(";"))
					{
						flag=1;
						endstring=s.split(";");
						sb.append(" "+endstring[0]);
						System.out.println("Inside if");
					}
					
					String sw=new String(sb);
					//System.out.println(sw);
					bw.write(sw);
					bw.newLine();
					}
					
					if(flag==1)
					{
						System.out.println("Inside flag::"+strarr[0]);
						System.out.println("Length::"+strarr.length);
						int i;
						if((i=sb.indexOf(strarr[0]))!=-1)
						{
						sb.delete(i,sb.length());
						System.out.println("Updated sb::"+sb);
						}
						/*else
						{
							System.out.println(sb+"::"+sb.indexOf("system"));
							sb.delete(sb.indexOf(strarr[0]),sb.length());
							System.out.println("Updated sb::"+sb);
						}*/
					}
						
				}
				
				
			}
			//System.out.println("final string::"+sb);
			
		} 
		 
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 finally{
			 try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 }
	}

}

