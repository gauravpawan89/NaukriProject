package UtilityPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadUtility {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;
	private FileInputStream fileInputStream;
	private String fPath;
	int rows;
	int cols;
	String cellValue;

	ReadUtility(String fPath, String sheetName) {
		this.fPath = fPath;
		try {
			fileInputStream = new FileInputStream(fPath);
			workbook = new XSSFWorkbook(fileInputStream);
			sheet = workbook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int countRows() {
		if (sheet != null) {
			rows = sheet.getLastRowNum();
		}
		return rows;

	}
	
	public int countColumns(int rows) {
		if(sheet!=null) {
			row =sheet.getRow(rows);
			cols =row.getLastCellNum();
		}
		return cols;
	}
	
	public String getData(int rows, int cells) {
		if(sheet!=null) {
			row= sheet.getRow(rows);
			cell = row.getCell(cells);
			switch (cell.getCellType()) {
			case STRING:
				cellValue = cell.getStringCellValue();
				break;
				
			case NUMERIC:
				cellValue = String.valueOf(cell.getNumericCellValue());
				
			}
			
		}
		return cellValue;
		
	}

}
