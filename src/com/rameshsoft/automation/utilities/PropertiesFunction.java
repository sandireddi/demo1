package com.rameshsoft.automation.utilities;


import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesFunction 
{ 
	private String filepath;
	private FileInputStream fis;
	private FileOutputStream fos;
	private Properties properties;
    public PropertiesFunction(String filepath) throws IOException
    {
    	this.filepath=filepath;
    	fis=new FileInputStream(filepath);
    	properties=new Properties(); 
    	properties.load(fis);
    }
    public String getProperyvalue(String key) throws IOException
    {
         properties.load(fis);
         String value= properties.getProperty(key);
         System.out.println("value is:"+value);
		 return value; 	
    }
    public void  setProperty(String key,String value) throws IOException 
    {
    	 properties.setProperty(key, value);
    	 fos=new FileOutputStream(filepath);
    	 properties.store(fos, "key,value added sucessfully to a file"); 
    	 
    }
    
    public void removeProperty(String key) throws IOException 
    {
    	properties.load(fis);
    	properties.remove(key);
    	fos=new FileOutputStream(filepath);
    	properties.store(fos, "successfully deleted");		  
    }
    
    public Map<String,String> getAllPropeties() throws IOException
    {
    	properties.load(fis);
    	LinkedHashMap<String, String> l=new LinkedHashMap<String, String>();
    	Set<Object> allKeys=properties.keySet();
    	for (Object value : allKeys) 
    	{
			    String key=(String)value;
			    String value1=properties.getProperty(key);	    
		}
		return l;   	
    }
    
    
}
