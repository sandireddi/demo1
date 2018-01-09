package com.rameshsoft.automation.pojoutility;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.internal.PropertiesFile;

import com.rameshsoft.automation.utilities.ExcelReader;
import com.rameshsoft.automation.utilities.PropertiesFunction;
import com.rameshsoft.automation.utilities.TextFileUtilities;

public class PojoUtility 
{
    private static String configFile ="C:\\mounika\\Framework\\config.properties";
    private static String browserUtilFile ="C:\\mounika\\Framework\\browser.utilities";
    private static String orFile ="C:\\mounika\\Framework\\src\\com\\rameshsoft\\automation\\objectrepository";
    private static String excelFile="C:\\mounika\\Framework\\src\\com\\rameshsoft\\automation\\testdata";
    private static String textFile="C:\\mounika\\Framework\\src\\com\\rameshsoft\\automation\\envappdata";
    
    public static PropertiesFunction getConfigFile() throws IOException
    {
    	PropertiesFunction pf=new PropertiesFunction(configFile);
		return pf;   	
    }   
    public static PropertiesFunction getBrowserUtilFile() throws IOException
    {
    	PropertiesFunction pf=new PropertiesFunction(browserUtilFile);
		return pf;   	
    }
    public static PropertiesFunction getOrFile() throws IOException
    {
    	PropertiesFunction pf=new PropertiesFunction(orFile);
		return pf;   	
    }
    public static ExcelReader getExcelFile() throws EncryptedDocumentException, InvalidFormatException, IOException 
    {
    	ExcelReader er=new ExcelReader(excelFile);
		return er;
    }
   public static TextFileUtilities getTextFile() throws IOException
   {
	   TextFileUtilities tf=new TextFileUtilities(textFile);
	   return tf;
   }
    
}
