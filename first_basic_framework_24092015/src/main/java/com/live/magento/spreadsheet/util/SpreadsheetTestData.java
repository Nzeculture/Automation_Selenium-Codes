package com.live.magento.spreadsheet.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class SpreadsheetTestData {
	
	
//	Sheet, Workbook, Cell, Row
	
	private transient Collection data = null;
	
	public SpreadsheetTestData(final InputStream excelInputStream) throws IOException {
		this.data = loadFromSpreadsheet(excelInputStream);
	}

	public Collection getData() {
		return data;
	}
	
	
	private Collection loadFromSpreadsheet(final InputStream excelFile) throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook(excelFile);
		
		data = new ArrayList();
		Sheet sheet = workbook.getSheetAt(0);
		int numberOfColumns = countNonEmptyColumns(sheet);
		List rows = new ArrayList();
		List rowData = new ArrayList();
		
		for(Row row : sheet) {
			if(isEmpty(row)) {
				break;
			}else {
				rowData.clear();
				for(int column = 0; column < numberOfColumns; column++) {
					Cell cell = row.getCell(column);
					rowData.add(objectFrom(workbook, cell));
				}
				rows.add(rowData.toArray());
			}
		}
		return rows;
	}

	private boolean isEmpty(final Row row) {
		Cell firstCell = row.getCell(0);
		boolean rowIsEmpty = (firstCell == null) || (firstCell.getCellType() == Cell.CELL_TYPE_BLANK);
		return rowIsEmpty;
	}

	private Object objectFrom(final HSSFWorkbook workbook,final Cell cell) {
		Object cellValue = null;
		if(cell.getCellType() == cell.CELL_TYPE_STRING) {
			cellValue = cell.getRichStringCellValue().getString();
		}else if(cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
			cellValue = getNumericCellValue(cell);
		}else if(cell.getCellType() == cell.CELL_TYPE_BOOLEAN) {
			cellValue = cell.getBooleanCellValue();
		}else if(cell.getCellType() == cell.CELL_TYPE_FORMULA) {
			cellValue = evaluateCellFormaula(workbook, cell);
		}
		return cellValue;
	}
	
	
	private Object getNumericCellValue(final Cell cell) {
		Object cellValue;
		if(DateUtil.isCellDateFormatted(cell)) {
			cellValue = new Date(cell.getDateCellValue().getTime());
		}else {
			cellValue = cell.getNumericCellValue();
		}
		return cellValue;
	}

	private Object evaluateCellFormaula(final HSSFWorkbook workbook, final Cell cell) {
		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		CellValue cellValue = evaluator.evaluate(cell);
		Object result = null;
		if(cellValue.getCellType() == cell.CELL_TYPE_BOOLEAN) {
			result = cellValue.getBooleanValue();
		}else if(cellValue.getCellType() == cell.CELL_TYPE_NUMERIC) {
			result = cellValue.getNumberValue();
		}else if(cellValue.getCellType() == cell.CELL_TYPE_STRING) {
			result = cellValue.getStringValue();
		}
		return result;
	}

	private int countNonEmptyColumns(final Sheet sheet) {
		Row firstRow = sheet.getRow(0);
		return firstEmptyCellPosition(firstRow);
	}

	private int firstEmptyCellPosition(final Row cells) {
		int columnCount = 0;
		for(Cell cell : cells) {
			if(cell.getCellType()== cell.CELL_TYPE_BLANK) {
				break;
			}
			columnCount++;
		}
		return columnCount;
	}
	
	
	

}
