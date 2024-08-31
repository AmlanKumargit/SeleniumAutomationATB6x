package com.amlankumar.DataDriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddDataintoExcel {

    public static void main(String[] args) throws IOException {


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        Row row = sheet.createRow(1);
        Cell cell = row.createCell(1);
        cell.setCellValue("Amlan");

        FileOutputStream fileoutputstream = new FileOutputStream(new File("CellSpecification.xlsx"));
        workbook.write(fileoutputstream);
        fileoutputstream.close();
    }
}
