package com.rameshsoft.automation.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader 
{
	private String filepath;
    private FileInputStream fis;
    private Workbook wb;
    public ExcelReader(String filepath ) throws EncryptedDocumentException, InvalidFormatException, IOException
    {
         fis=new FileInputStream(filepath);
         wb=WorkbookFactory.create(fis); 	
    }
    public Sheet getSheet(String sheet_name )
    {
           Sheet sheet=wb.getSheet("Sheet_name");
           return sheet;
    }
    public int getRowCount(String sheet_name )
    {
    	     int  row_count =getSheet(sheet_name ).getLastRowNum( )+1;
    	     return row_count;
    }
    public Cell  getCelllValue(String sheet_name,int row_no,int cell_no)
    {
        Cell  cell_value=getSheet(sheet_name).getRow(row_no).getCell(cell_no);
		
        if(cell_value.getCellType()==cell_value.CELL_TYPE_NUMERIC)
        {
        	Double d=cell_value.getNumericCellValue( );
        }
        else if(cell_value.getCellType()==cell_value.CELL_TYPE_STRING)
        {
        	String s=cell_value.getStringCellValue( ); 	
        }
        else if(cell_value.getCellType()==cell_value.CELL_TYPE_BLANK)
        {
        	System.out.println("cell value is null plz cross check once");
        }
        return cell_value;
    }
    public void setCellValue(String sheet_name,int row_no,int cell_no,String value) throws IOException
    {
    	wb.getSheet(sheet_name).createRow(row_no).createCell(cell_no).setCellValue(value);
    	FileOutputStream fos=new FileOutputStream(filepath);
    	wb.write(fos);
    	
    }
}
