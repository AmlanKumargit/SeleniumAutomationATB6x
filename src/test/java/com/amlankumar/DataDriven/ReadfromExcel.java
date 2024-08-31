package com.amlankumar.DataDriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ReadfromExcel {

    public static void main(String[] args) throws IOException {

        FileInputStream inputstream = new FileInputStream(new File("ExcelData.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();
        while(rowIterator.hasNext()){
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while(cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                if(cell.getCellType()== CellType.NUMERIC){
                    System.out.println(cell.getNumericCellValue());}
                if(cell.getCellType()== CellType.STRING){
                    System.out.println(cell.getStringCellValue());}
            }
            System.out.println("\n");
        }

    }
}
