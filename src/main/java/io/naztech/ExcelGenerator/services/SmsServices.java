package io.naztech.ExcelGenerator.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;


import io.naztech.ExcelGenerator.model.Sms;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class SmsServices {
	public Sms processData(Sms sms) {
		
		
		
		log.debug("RestApi Is cxalled");
		return generateExcell()?new Sms():null;
	}
	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return dateFormat.format(date);
	}
	public boolean generateExcell() {

		File f = new File("C:\\\\TempFile\\"+getDate()+".xlsx");
		 int rowNum=0;
		 XSSFWorkbook workbook = null;
		 XSSFSheet sheet = null;
		if (f.isFile() && f.canRead()) {
			log.debug("File Found");
		  try {
		    FileInputStream myxls = new FileInputStream(f);
		    workbook = new XSSFWorkbook(myxls);
		    sheet = workbook.getSheetAt(0);
		    rowNum=sheet.getLastRowNum();
		
		  } catch (IOException ex) {
			  log.error(ex.toString());
		  }
		}else {
			log.debug("FileNot Found");
			 workbook = new XSSFWorkbook(); 
			 sheet = workbook.createSheet("student Details"); 	
		}
		if(!workbook.equals(null) && !sheet.equals(null)) {
			
		     // This data needs to be written (Object[]) 
	        Map<String, Object[]> data = new TreeMap<String, Object[]>(); 
	        data.put("1", new Object[]{ "ID", "NAME", "LASTNAME" }); 
	        data.put("2", new Object[]{ 1, "Pankaj", "Kumar" }); 
	        data.put("3", new Object[]{ 2, "Prakashni", "Yadav" }); 
	        data.put("4", new Object[]{ 3, "Ayan", "Mondal" }); 
	        data.put("5", new Object[]{ 4, "Virat", "kohli" }); 
	        Row row ;
	        Cell cell;
	        int cellNum=0;
	        for(Entry<String, Object[]> s:data.entrySet()) {
	             row = sheet.createRow(rowNum++); 
	             for(Object t:s.getValue()) {
	            	 cell=row.createCell(cellNum++);
	                 if (t instanceof String)
	                    cell.setCellValue((String)t);
	                 else if (t instanceof Integer) 
	                	cell.setCellValue((Integer)t); 
	             }
	             cellNum=0;  
	             }
	        try { 
	        	
	        	log.debug("\nC:\\TempFile\\"+getDate()+".xlsx");
	            FileOutputStream out = new FileOutputStream(new File("C:\\TempFile\\"+getDate()+".xlsx")); 
	            workbook.write(out); 
	            out.close(); 
	            log.debug("gfgcontribute.xlsx written successfully on disk.");
	            System.out.println(""); 
	        } 
	        catch (Exception e) { 
	            e.printStackTrace(); 
	        } 
			return true;
		}else {
			log.error("\nError And Return False");
			return false;
		}

	}
}
