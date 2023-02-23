//Importing required packages
package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class TestDataReader {
    //Declaring variables
    private static HashMap<String, HashMap<String,String >> data;
    private static XSSFWorkbook workbook = null;
    public static void main(String[] args) {
        //Main method
        init();
    }
    //Initialization method to read data from excel
    private static void init(){
        if(workbook==null) {
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream("src/test/resources/testdata.xlsx");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            try {
                workbook = new XSSFWorkbook(fileInputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            //Accessing the required sheet
            XSSFSheet sheet = workbook.getSheet("Sheet1");

            data = new HashMap<>();
            //Reading each row and column and storing the data in hashmap
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
    //Method to return data for a specific key
    public static HashMap<String, String> getData(String key){
        init();
        return data.get(key);
    }
}