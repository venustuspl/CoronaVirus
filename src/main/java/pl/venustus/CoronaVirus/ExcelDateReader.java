package pl.venustus.CoronaVirus;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import static org.apache.poi.ss.usermodel.CellType.NUMERIC;

/**
 * Simple Java Program to read and write dates from Excel file in Java.
 * This example particularly read Excel file in OLE format i.e.
 * Excel file with extension .xls, also known as XLS files.
 *
 * @author WINDOWS 8
 */
public class ExcelDateReader {

//    public static void main(String[] args) throws FileNotFoundException, IOException {
//        writeIntoExcel("birthdays.xls");
//        readFromExcel("birthdays.xls");
//    }

    /**
     * Java method to read dates from Excel file in Java.
     * This method read value from .XLS file, which is an OLE
     * format.
     *
     * @param file
     * @throws IOException
     */
//    public static void readFromExcel(String file) throws IOException {
//        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
//        HSSFSheet myExcelSheet = myExcelBook.getSheet("CSV_4_COMS");
//        HSSFRow row = myExcelSheet.getRow(0);
//
//        if (row.getCell(0).getCellType() == STRING) {
//            String name = row.getCell(0).getStringCellValue();
//            System.out.println("name : " + name);
//        }
//
//        if (row.getCell(1).getCellType() == NUMERIC) {
//            Date birthdate = row.getCell(1).getDateCellValue();
//            System.out.println("birthdate :" + birthdate);
//        }
//
//        myExcelBook.close();
//
//    }
    public static void readFromCSV_4_COMS(InputStream file) throws IOException {
        HSSFWorkbook myExcelBook = new HSSFWorkbook(file);
        HSSFSheet myExcelSheet = myExcelBook.getSheet("CSV_4_COMS");
        HSSFRow row = myExcelSheet.getRow(0);

        String country = row.getCell(1).getStringCellValue();
        Double count = 0.0;
        Map<String, Double> resultMap = new HashMap<>();
        for (Row rows : myExcelSheet) {

            if (rows.getCell(1).getStringCellValue().equals(country)) {
                //count += Double.parseDouble(rows.getCell(2).getStringCellValue());
                if (rows.getCell(2).getCellType() == NUMERIC) {
                    count = +rows.getCell(2).getNumericCellValue();
                }
            } else {
                resultMap.put(rows.getCell(1).getStringCellValue(), count);
                count = 0.0;
            }


        }
        for (Map.Entry<String, Double> result : resultMap.entrySet()) {
            System.out.println(result.getKey() + " " + result.getValue());
        }

        myExcelBook.close();

    }

    /**
     * Java method to write dates from Excel file in Java.
     * This method write value into .XLS file in Java.
     *
     * @param file, name of excel file to write.
     * @throws IOException
     * @throws FileNotFoundException
     */
    //  @SuppressWarnings("deprecation")
//    public static void writeIntoExcel(String file) throws FileNotFoundException, IOException {
//        Workbook book = new HSSFWorkbook();
//        Sheet sheet = book.createSheet("Birthdays");
//
//        // first row start with zero
//        Row row = sheet.createRow(0);
//
//        // we will write name and birthdates in two columns
//        // name will be String and birthday would be Date
//        // formatted as dd.mm.yyyy
//        Cell name = row.createCell(0);
//        name.setCellValue("John");
//
//        Cell birthdate = row.createCell(1);
//
//        // steps to format a cell to display date value in Excel
//        // 1. Create a DataFormat
//        // 2. Create a CellStyle
//        // 3. Set format into CellStyle
//        // 4. Set CellStyle into Cell
//        // 5. Write java.util.Date into Cell
//        DataFormat format = book.createDataFormat();
//        CellStyle dateStyle = book.createCellStyle();
//        dateStyle.setDataFormat(format.getFormat("dd.mm.yyyy"));
//        birthdate.setCellStyle(dateStyle);
//
//        // It's very trick method, deprecated, don't use
//        // year is from 1900, month starts with zero
//        birthdate.setCellValue(new Date(110, 10, 10));
//
//        // auto-resizing columns
//        sheet.autoSizeColumn(1);
//
//        // Now, its time to write content of Excel into File
//        book.write(new FileOutputStream(file));
//        book.close();}

}