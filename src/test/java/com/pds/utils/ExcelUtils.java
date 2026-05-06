package com.pds.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    public static List<Map<String,String>> readExcel(String filePath,String sheetName){


        List<Map<String,String>> recordList = new ArrayList<Map<String,String>>();

        try{
            // InputStream apprach deals with classpath, which uses realtive xpath
            // other approach is using Fileinputstream, which needed absolute xpath, but read file from anywhere. ExcelUtils.class - every Java class has a .class object created by JVM, holds the metadata about the class like class name

            ClassLoader loader = ExcelUtils.class.getClassLoader();
            InputStream inputStream = loader.getResourceAsStream(filePath);

            if (inputStream == null) {
                throw new RuntimeException("❌ Excel file not found on classpath: " + filePath);
            }
            Workbook workbook = WorkbookFactory.create(inputStream);

            Sheet sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("❌ Sheet not found: " + sheetName);
            }

            Row headerRow = sheet.getRow(0);

            for(int i=1;i<=sheet.getLastRowNum();i++){
                Row row = sheet.getRow(i);
                Map<String,String> record = new HashMap<String,String>();

                for (int j=0;j<headerRow.getLastCellNum();j++){
                    String key = headerRow.getCell(j).getStringCellValue();
                    String value = row.getCell(j).getStringCellValue();
                    record.put(key,value);
                }
                recordList.add(record);
            }
            workbook.close();


        } catch (IOException e) {
            throw new RuntimeException("Failed to read Excel file",e);
        }

        System.out.println("📊 Excel Data Read:");

        for (Map<String, String> row : recordList) {
            System.out.println("Row -----------------");
            for (Map.Entry<String, String> entry : row.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
        return recordList;
    }

}
