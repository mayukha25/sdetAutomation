package com.crm.vitiger.GenericUtils;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
public class ExcelUtility1{
	
public String getExcelData(String sheetName, int rownum, int cellnum) throws Throwable {
		
		
		FileInputStream file=new FileInputStream(IpathConstant1.EXCELPATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		return cell.getStringCellValue();
		}
		
		/**
		 * 
		 * @param sheetname
		 * @return
		 * @throws Throwable
		 */
		
		public Object[][] getExcelData(String sheetname) throws Throwable{
			
		FileInputStream file=new FileInputStream(IpathConstant1.EXCELPATH);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetname);
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				data[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;

		
	}
		/**
		 * 
		 * @param sheetname
		 * @param rownum
		 * @param column
		 * @param value
		 * @throws Throwable
		 */
		
	public void writeExcelData(String sheetname, int rownum,int column, String value) throws Throwable {
		
	FileInputStream file=new FileInputStream(IpathConstant1.EXCELPATH);
	Workbook workbook=WorkbookFactory.create(file);
	workbook.createSheet(sheetname).createRow(rownum).createCell(column).setCellValue(value);
	FileOutputStream writeFile=new FileOutputStream(IpathConstant1.EXCELPATH);
	workbook.write(writeFile);
	workbook.close();
	}
		


	}
