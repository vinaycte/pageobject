package com.driv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import k.Keywords;

public class Driver extends Keywords {
	static FileInputStream f2;
	static ArrayList data2;
	static XSSFWorkbook w2;
	static XSSFSheet s2;
	static{
		   try{
			   data2 = new ArrayList();
			   f2 = new FileInputStream("F://Allmodules.xlsx");
			    w2 = new XSSFWorkbook(f2);
			   s2 = w2.getSheet("First");
			   Iterator <Row> rowitr = s2.iterator();
			   while (rowitr.hasNext()){
				   Row rowall = rowitr.next();
				   Iterator <Cell>cellallitr = rowall.cellIterator();
				   while (cellallitr.hasNext()){
					   Cell call =cellallitr.next();
					   if(call.getCellTypeEnum().equals(CellType.STRING)){
						   data2.add(call.getStringCellValue());
						    }
				   if(call.getCellTypeEnum().equals(CellType.NUMERIC)){
						  data2.add(call.getNumericCellValue()) ;
					   }
			 if(call.getCellTypeEnum().equals(CellType.BOOLEAN)){
						  data2.add(call.getBooleanCellValue()) ;
					   }
				   }
			   }
			   
			   
			   
		   }catch(Exception e){
			   System.out.println(e);
		   }
	}
@Test
	public void test() throws Exception {
	 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./reportses/aut.html");
     ExtentReports extent = new ExtentReports();
     extent.attachReporter(htmlReporter);

     ExtentTest test = extent.createTest("contacts", "automating contacts feacure");
//test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
  //  test.addScreenCaptureFromPath("screenshot.png");
     extent.flush();
		Keywords dm = new Keywords();
	   for(int i= 0;i<data2.size();i++){
			   if(data2.get(i).equals("Leads")&& data2.get(i+1).equals("Yes")){
				   ArrayList data3 = new ArrayList();
				   FileInputStream file3 = new FileInputStream("F://Zleads.xlsx");
				   XSSFWorkbook w3 = new XSSFWorkbook(file3);
				   XSSFSheet s3= w3.getSheet("First");
				   Iterator <Row> rowitr1 = s3.iterator();
				   while(rowitr1.hasNext()){
					   Row rowall1 = rowitr1.next();
					   Iterator<Cell>cellallitr1=rowall1.iterator();
					   while(cellallitr1.hasNext()){
						   Cell call1 = cellallitr1.next();
						   if(call1.getCellTypeEnum().equals(CellType.STRING)){
							data3.add(call1.getStringCellValue());   
						   }
						   if(call1.getCellTypeEnum().equals(CellType.NUMERIC)){
								data3.add(call1.getNumericCellValue());   
						   }
						   if(call1.getCellTypeEnum().equals(CellType.BOOLEAN)){
							data3.add(call1.getBooleanCellValue());   
							   }
					   }
				   }
				   for(int j =0;j<data3.size();j++){
					   if(data3.get(j).equals("openbrowser")){
						   String keyword = (String)data3.get(j);
						   String data = (String)data3.get(j+1);
						   String objectname = (String)data3.get(j+2);
						   String runmode = (String)data3.get(j+3);
						   System.out.println(keyword);
						   System.out.println(data);
						   System.out.println(objectname);
						   System.out.println(runmode);
                           dm.openbrowser();
						   
						}
					   if(data3.get(j).equals("navigate")){
						   String keyword = (String)data3.get(j);
						   String data = (String)data3.get(j+1);
						   String objectname = (String)data3.get(j+2);
						   String runmode = (String)data3.get(j+3);
						   System.out.println(keyword);
						   System.out.println(data);
						   System.out.println(objectname);
						   System.out.println(runmode);
                           dm.navigate(data);
						   
						}
					   if(data3.get(j).equals("input")){
						   String keyword = (String)data3.get(j);
						   String data = (String)data3.get(j+1);
						   String objectname = (String)data3.get(j+2);
						   String runmode = (String)data3.get(j+3);
						   System.out.println(keyword);
						   System.out.println(data);
						   System.out.println(objectname);
						   System.out.println(runmode);
                           dm.input(data,objectname);
						   
						}
					   if(data3.get(j).equals("click")){
						   String keyword = (String)data3.get(j);
						   String data = (String)data3.get(j+1);
						   String objectname = (String)data3.get(j+2);
						   String runmode = (String)data3.get(j+3);
						   System.out.println(keyword);
						   System.out.println(data);
						   System.out.println(objectname);
						   System.out.println(runmode);
                           dm.click(objectname);
						   
						}
						if(data3.get(j).equals("droupdown")){
							   String keyword = (String)data3.get(j);
							   String data = (String)data3.get(j+1);
							   String objectname = (String)data3.get(j+2);
							   String runmode = (String)data3.get(j+3);
							   System.out.println(keyword);
							   System.out.println(data);
							   System.out.println(objectname);
							   System.out.println(runmode);
							   if(runmode.equals("yes")){
								   dm.droupdown(data,objectname);
							   }
							}
						
						if(data3.get(j).equals("box")){
							   String keyword = (String)data3.get(j);
							   String data = (String)data3.get(j+1);
							   String objectname = (String)data3.get(j+2);
							   String runmode = (String)data3.get(j+3);
							   System.out.println(keyword);
							   System.out.println(data);
							   System.out.println(objectname);
							   System.out.println(runmode);
							   if(runmode.equals("yes")){
								   dm.box(objectname);
							   }
							   }
					   
						   if(data3.get(j).equals("exit")){
							   String keyword = (String)data3.get(j);
							   String data = (String)data3.get(j+1);
							   String objectname = (String)data3.get(j+2);
							   String runmode = (String)data3.get(j+3);
							   System.out.println(keyword);
							   System.out.println(data);
							   System.out.println(objectname);
							   System.out.println(runmode);
	                           dm.exit();
						   
							}
						   
						   if(data3.get(j).equals("title")){
							   String keyword = (String)data3.get(j);
							   String data = (String)data3.get(j+1);
							   String objectname = (String)data3.get(j+2);
							   String runmode = (String)data3.get(j+3);
							   System.out.println(keyword);
							   System.out.println(data);
							   System.out.println(objectname);
							   System.out.println(runmode);
	                         String actualvalue=  dm.title();
							   Assert.assertEquals(actualvalue, data);
							   
							}
						   if(data3.get(j).equals("verifytext")){
							   String keyword = (String)data3.get(j);
							   String data = (String)data3.get(j+1);
							   String objectname = (String)data3.get(j+2);
							   String runmode = (String)data3.get(j+3);
							   System.out.println(keyword);
							   System.out.println(data);
							   System.out.println(objectname);
							   System.out.println(runmode);
	                         String actualvalue =  dm.verifytext(objectname);
	                         Assert.assertEquals(actualvalue, data);   
							}
						   if(data3.get(j).equals("verieditbox")){
							   String keyword = (String)data3.get(j);
							   String data = (String)data3.get(j+1);
							   String objectname = (String)data3.get(j+2);
							   String runmode = (String)data3.get(j+3);
							   System.out.println(keyword);
							   System.out.println(data);
							   System.out.println(objectname);
							   System.out.println(runmode);
	                          String actualvalue = dm.verieditbox(objectname);
	                          Assert.assertEquals(actualvalue, data);
							   
							}
						     
			   }
				   
				   
	   }
		   }


	}

}
