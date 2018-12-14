package com.ww.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

/**
 * @author WangWei
 * @Title: ExcelUtils
 * @ProjectName gril
 * @Description: TODO
 * @date 2018/10/10 10:10
 */
public class ExcelUtils {

    //文件路径
    private String path = null;

    public ExcelUtils() {}
    public ExcelUtils(String path) {
        this.path = path;
    }

    /**
     * 作用：读取Excel表格指定列中数据
     * @param column 要读取Excel表格的哪一列，从0开始
     * @return 返回列中数据
     */
    public List<String> readColContentFromExcel(int column) {
        List<String> content = new ArrayList<String>();
        FileInputStream input = null;
        try {
            input = new FileInputStream(this.path);
            XSSFWorkbook workBook = new XSSFWorkbook(input);
            XSSFSheet sheet = workBook.getSheetAt(0);
            String cellContent = null;
            for(int i=1; i<sheet.getPhysicalNumberOfRows(); i++) {
                XSSFCell cell = sheet.getRow(i).getCell(column);
                if(cell != null) {
                    cellContent = sheet.getRow(i).getCell(column).toString();
                    if(!StringUtils.isEmpty(cellContent)) {
                        content.add(cellContent);
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content;
    }

    /**
     * 作用：向Excel表格指定列中写入数据
     * @param contents 要添加到Excel表格指定列中的数据
     * @param column 指定列
     */
    public void writeResultAtExcel(List<String> contents, int column) {
        FileInputStream input = null;
        FileOutputStream output = null;
        try {
            input = new FileInputStream(this.path);
            XSSFWorkbook workBook = new XSSFWorkbook(input);
            XSSFSheet sheet = workBook.getSheetAt(0);
            for(int i=1; i<=contents.size(); i++) {
                XSSFCell cell = sheet.getRow(i).createCell(column);
                cell.setCellValue(contents.get(i-1));
                output = new FileOutputStream(path);
                workBook.write(output);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 比较firstColumn列与secondColumn列中数据，并将比对结果存入Excel表格的resultColumn列
     * @param firstColumn Excel表格的列，从0开始
     * @param secondColumn 表格的列，从0开始
     * @param resultColumn 表格的列，从0开始
     */
    public void compareColumnsContent(int firstColumn, int secondColumn, int resultColumn) {
        List<String> results = new ArrayList<String>();
        List<String> first = this.readColContentFromExcel(firstColumn);
        List<String> second = this.readColContentFromExcel(secondColumn);
        for(Iterator<String> firstColumnContent=first.iterator(); firstColumnContent.hasNext(); ) {
            String result = "Not Equal";
            String str1 = firstColumnContent.next();
            for(Iterator<String> secondColumnContent=second.iterator(); secondColumnContent.hasNext(); ) {
                String str2 = secondColumnContent.next();
                if(!StringUtils.isEmpty(str2)) {
                    if(str2.equals(str1)) {
                        result = "Equal";
                        break;
                    }
                }
            }
            results.add(result);
        }
        //将比较结果写入到Excel
        this.writeResultAtExcel(results, resultColumn);
        //System.out.println(results);
    }


        public static void main(String[] args) {
            ExcelUtils test = new ExcelUtils("F:\\temp\\ExcelTest.xlsx");
            test.compareColumnsContent(1, 3, 5);
        }
}
