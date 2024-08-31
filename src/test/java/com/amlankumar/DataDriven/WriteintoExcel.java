package com.amlankumar.DataDriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class WriteintoExcel {

    public static void main(String[] args) throws IOException {
        Map<String, Object> data = new TreeMap<>();
        data.put("1", new Object[]{"LoginId", "Username", "Password"});
        data.put("2", new Object[]{"AX002", "Amlan", "Amlan@123"});
        data.put("3", new Object[]{"DX003", "Slap", "Slap@321"});
        data.put("4", new Object[]{"EX005", "George", "George@456"});

        CreateExcel("ExcelSheetData.xlsx", data);
    }

    public static String CreateExcel(String name, Map data) throws IOException {

            Set<String> keyset = data.keySet();
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Main");

            int rownum =0;

            for(String key:keyset){
                Row r = sheet.createRow(rownum++);
                Object[] obj = (Object[]) data.get(key);
                int cellnum=0;
                for(Object o:obj){
                    Cell c = r.createCell(cellnum++);
                    if(o instanceof String) {
                        c.setCellValue((String) o);}
                    if(o instanceof Integer){
                        c.setCellValue((Integer)o);}
                }
            }
            FileOutputStream fileoutputstream = new FileOutputStream(new File(name));
            workbook.write(fileoutputstream);
            fileoutputstream.close();

            return name;
        }

}
