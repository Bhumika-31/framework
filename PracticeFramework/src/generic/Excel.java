package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getData(String path, String sheetName, int row, int col)
	{
		String value="";
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			value=wb.getSheet(sheetName).getRow(row).getCell(col).toString();
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	public static int rowCount(String path, String sheetName)
	{
		int rc=0;
		try {
			Workbook wb=WorkbookFactory.create(new File(path));
			rc=wb.getSheet(sheetName).getLastRowNum();
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rc;
	}
	
	public static int colCount(String path, String sheetName, int row)
	{
		int cc=0;
		Workbook wb;
		try {
			wb = WorkbookFactory.create(new File(path));
			cc=wb.getSheet(sheetName).getRow(row).getLastCellNum();
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cc;
	}

}
