package com.live.magento.spreadsheet.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
//	Sheet, Workbook, Cell, Row
	
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
//	method to Setup and load the excel file
	public static void setExcelFile(String PATH, String SheetName) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(PATH);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
	//		ExcelWSheet = ExcelWBook.getSheetAt(0);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		}catch(Exception e) {
			throw(e);
		}	
	}
	
//  This method will get the data from excel sheet
	public static String getCellData(int RownNum, int ColNum) {
		try {
			Cell = ExcelWSheet.getRow(RownNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		}catch(Exception e) {
			return "";
		}
	}
	
	
//  This method will get the data from excel sheet
	public static void setCellData(String result, int RownNum, int ColNum) throws Exception {
		try {
			Row = ExcelWSheet.getRow(RownNum);
			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);
			if(Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(result);
			}else {
				Cell.setCellValue(result);
			}
			
			FileOutputStream fileOut = new FileOutputStream(Constant.Path_TestData+Constant.file_TestData);
			ExcelWBook.write(fileOut);
//			fileOut.flush();
			fileOut.close();
			
		}catch(Exception e) {
			throw e;
		}
	}
	
	

}
