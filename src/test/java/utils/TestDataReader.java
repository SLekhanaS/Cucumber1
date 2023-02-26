// This code is a Java class that reads data from an Excel file using Apache POI library.
// Importing required libraries
package utils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class TestDataReader {
    // Declaring required class level variables
    private static HashMap<String, HashMap<String,String >> data;
    private static XSSFWorkbook workbook = null;
    // Main method of the class
    public static void main(String[] args) {
        init(); // Initializing the workbook
    }

    private static void init(){
        if(workbook==null) {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream("src/test/resources/testdata.xlsx");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
// A private method that initializes the workbook and reads data from Excel file
            try {
                workbook = new XSSFWorkbook(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            data = new HashMap<>();
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                String key = row.getCell(0).getStringCellValue();
                HashMap<String, String> rowData = new HashMap<>();

                for (int j = 1; j < row.getLastCellNum(); j++) {
                    String columnName = sheet.getRow(0).getCell(j).getStringCellValue();
                    rowData.put(columnName, row.getCell(j).getStringCellValue());
                }
                data.put(key, rowData);
            }
        }

    }
    // A public method that returns data for a given key
    public static HashMap<String, String> getData(String key){
        init(); // Initializing the workbook
        return data.get(key); // Returning data for given key
    }
}