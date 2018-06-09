package Generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {

	public static String getExcelCellValue(String path, String sheetName,int row, int cellNumber)
	{
		
		String cellValue = null;
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = new WorkbookFactory().create(fis);
			Sheet s1 = wb.getSheet(sheetName);
			Row r1 = s1.getRow(row);
			cellValue = r1.getCell(cellNumber).getStringCellValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellValue;
	}
	
	
	public static int getRowCount(String path, String sheetName)
	{
		
		int rowNumbers = 0;
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = new WorkbookFactory().create(fis);
			rowNumbers = wb.getSheet(sheetName).getLastRowNum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowNumbers;
	}
	
	public static int getCellCount(String path, String sheetName, int row)
	{
		
		int cellNumbers = 0;
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = new WorkbookFactory().create(fis);
			cellNumbers = wb.getSheet(sheetName).getRow(row).getLastCellNum();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellNumbers;
	}
	
	public static void writeDataToExcel(String path, String sheetName, int row, int cell, String value)
	{

		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = new WorkbookFactory().create(fis);
			wb.getSheet(sheetName).getRow(row).createCell(cell).setAsActiveCell();
			wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(value);
			
			FileOutputStream fos = new FileOutputStream(path);
			wb.write(fos);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
