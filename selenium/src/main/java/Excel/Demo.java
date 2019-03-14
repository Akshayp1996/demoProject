package Excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelReport\\Test.xlsx");
		XSSFWorkbook wBook = new XSSFWorkbook(fis);
		XSSFSheet sheet = wBook.getSheet("FirstSheet");

	//	String data = sheet.getRow(0).getCell(0).getStringCellValue();
		//System.out.println(data);
		
		sheet.getRow(0).createCell(2).setCellValue("Pune");
		System.out.println("Value Set");
		FileOutputStream fout = new FileOutputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ExcelReport\\Test.xlsx");
		wBook.write(fout);
		wBook.close();

	}

}
