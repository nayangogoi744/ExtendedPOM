package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private static String filepath;
	
	public ExcelReader(String filepath) {
		this.filepath=filepath;
	}
	public static int getRowCount(String sheetname) throws IOException {
		int row = 0;
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\"+filepath));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetname);
		Iterator<Row> itr = sheet.rowIterator();
		while(itr.hasNext()) {
			itr.next();
			row++;
		}
		
		System.out.println("Total row " + row);
		return row;
	}
	
	public static int getColumnCount(String sheetname) throws IOException {
		int column = 0;
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\"+filepath));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetname);
		Iterator<Row> itr = sheet.rowIterator();
		Row rows = itr.next();
		Iterator<Cell> cell = rows.cellIterator();
		while(cell.hasNext()) {
			cell.next();
			column++;
		}
		
		System.out.println("Total columns " + column);
		return column;
	}
	
	public static String[][] getExcelData(String sheetname) throws IOException{
		int count=-1;
		String[][] arrayExcelData = null;
		DataFormatter fmt = new DataFormatter();
		FileInputStream fis = new FileInputStream(new File(System.getProperty("user.dir")+"\\"+filepath));
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(sheetname);
		int rows= ExcelReader.getRowCount(sheetname);
		int columns = ExcelReader.getColumnCount(sheetname);
		
		
		arrayExcelData = new String[rows-1][columns];
		Iterator<Sheet> sheetIterator = wb.sheetIterator();
		while(sheetIterator.hasNext()){
		    Sheet mysheet = sheetIterator.next();
		    String page = mysheet.getSheetName();
		    count++;
			
			 if(page.contains(sheetname)) {
				 for(int i=1;i<rows;i++) {
						for(int j=0;j<columns;j++) {
							Cell cel = wb.getSheetAt(count).getRow(i).getCell(j);
							//System.out.println(cel.toString());
							arrayExcelData[i-1][j]= fmt.formatCellValue(cel);
						}
						
					}
				 
			}
			 
		}
		
		return arrayExcelData;
		
		
		
	}

}
