package com.rameshsoft.automation.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileUtilities 
{
  private String filepath;
  private File file;
  private FileWriter fw;
  private BufferedWriter bw;
  private FileReader fr;
  private BufferedReader br;
  
  public TextFileUtilities(String filepath) throws IOException
  {
	 this.filepath=filepath;
	 file =new File(filepath);
	 file.createNewFile();
	 fw=new FileWriter(file);
	 bw=new BufferedWriter(fw);
	 fr=new FileReader(file);
	 br=new BufferedReader(fr);	 
  }
  public String getData() throws IOException
  {
  String value=null;
   if(br!=null)
   {
	   value=br.readLine();
      System.out.println("value is"+value);
   }
   else
   {
	   System.out.println("br is null....cross check once");
   }
  return value;
}
  
  public List<String> getAllData( ) throws IOException
  {
	  List<String>l=new ArrayList<String>();
	  if(br!=null)
	  {
		 while(br.ready()) 
		 {
			 String data=br.readLine( );
			 System.out.println("Data is:"+data); 
		 }
	  }
	else
	{
		System.out.println("br is null");
	}
	return l;
  }
  
  public void writeData(int data) throws IOException
  {
	    bw.write(data);
	    bw.flush();
  }
  
  public void writeData(String data) throws IOException
  {
	  bw.write(data);
	  bw.flush();
  }  
  }


