package com.orange.datadriven;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataDrivenUtil {

    private DataDrivenUtil(){}

    public static List<Map<String,String>> getLoginTestDataFromExcel(String filePath, String sheetName){
        List<Map<String,String>> list = null;
        try(FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

           list = new ArrayList<>();

            for(int i = 1; i<=rowCount; i++){
                Map<String, String> map = new HashMap<>();

                for(int j = 1; j<colCount; j++){

                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();

                    map.put(key, value);
                }
                    list.add(map);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}


