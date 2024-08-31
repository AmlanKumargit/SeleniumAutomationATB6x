package com.amlankumar.DataDriven;


import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelReader {

    String path;
    ExcelReader(String path)
    {
        this.path=path;
    }

    public String[][] getDatafromSheet(String workBookLocation, String sheetName) throws IOException {

        XSSFWorkbook workBook = new XSSFWorkbook(System.getProperty("user.dir")+"/"+workBookLocation);
        XSSFSheet workSheet = workBook.createSheet(sheetName+1);

        int noOfRows = workSheet.getLastRowNum()+1;
        /*int noOfCols = workSheet.getRow(0).getLastCellNum();*/
        String[][] dataTable = new String[noOfRows][3];

        int i,j;
        for(i=workSheet.getFirstRowNum();i<workSheet.getLastRowNum();i++)
        {
            Row row = workSheet.getRow(i);
            for(j=row.getFirstCellNum();j<row.getLastCellNum();j++)
            {
                Cell cell = row.getCell(j);
                dataTable[i][j]=cell.getStringCellValue();
            }
        }
        workBook.close();
        return dataTable;
    }
}
