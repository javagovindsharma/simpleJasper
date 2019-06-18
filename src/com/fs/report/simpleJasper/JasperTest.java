package com.fs.report.simpleJasper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * @author govind.sharma
 *
 */
public class JasperTest 
{
    public static void main( String[] args )
    {
    	//printPdfReport();
    	printPdfWithMAPReport();
    }
    
    public static void  printPdfReport() {
    	 try {
         	String path=System.getProperty("user.dir");
         	System.out.println("PATH "+path); 
         	  JasperReport  jasperReport=JasperCompileManager.compileReport(path+"/reports/empReport1.jrxml");
               List<Empoloye> lists=new  DataBase().getEmployee();
               System.out.println(lists.size());
         	  
       
               JRBeanCollectionDataSource beanColDataSource =new JRBeanCollectionDataSource(lists);
 			  JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, null,beanColDataSource) ;
 			  JasperExportManager.exportReportToPdfFile(jasperPrint, "D:/filePf.pdf");
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
    }
    
    
    public static void  printPdfWithMAPReport() {
   	 try {
        	String path=System.getProperty("user.dir");
        	 
        	  JasperReport  jasperReport=JasperCompileManager.compileReport(path+"/reports/empRecords.jrxml");
              List<Empoloye> lists=new  DataBase().getEmployee();
              System.out.println(lists.size());
        	
              
              List<ChartData> cList = new ArrayList<ChartData>();
              cList.add(new ChartData("hoursNormal","JAN", 62.3)); //The use of resources or static text is beyond this example
              cList.add(new ChartData("hoursTravel","JAN", 13.2));
              cList.add(new ChartData("hoursOvertime","JAN", 21.3));
              cList.add(new ChartData("hoursNormal","FEB", 12.4));
              cList.add(new ChartData("hoursTravel","FEB", 15.2));
              cList.add(new ChartData("hoursOvertime","FEB", 64.1));
              
              cList.add(new ChartData("hoursNormal","MAR", 2.4));
              cList.add(new ChartData("hoursTravel","MAR", 8.2));
              cList.add(new ChartData("hoursOvertime","MAR", 6.1));
              
              cList.add(new ChartData("hoursNormal","APRIL", 2.4));
              cList.add(new ChartData("hoursTravel","APRIL", 8.2));
              cList.add(new ChartData("hoursOvertime","APRIL", 6.1));
              
              cList.add(new ChartData("hoursNormal","MAY", 22.4));
              cList.add(new ChartData("hoursTravel","MAY", 48.2));
              cList.add(new ChartData("hoursOvertime","MAY", 36.1));
              
              cList.add(new ChartData("hoursNormal","MAY", 12.4));
              cList.add(new ChartData("hoursTravel","MAY", 68.2));
              cList.add(new ChartData("hoursOvertime","MAY", 46.1));
           
              
              
              
              Map<String,Object> parameter=new HashMap<String,Object>();                         
              					 parameter.put("title","Jasper Report Of DBi");
              					 parameter.put("emp_rec","Employee Record In Tabular Format");
              					 parameter.put("companyName","Fresche Solutions");
						         parameter.put("author","developer");
						         parameter.put("path",path+"\\reports\\invoice_logo.png");
						         parameter.put("CHART_DATASET", new JRBeanCollectionDataSource(cList));
				System.err.println("Path  "+parameter.get("path")); 		         
						         
              JRBeanCollectionDataSource beanColDataSource =new JRBeanCollectionDataSource(lists);
			  JasperPrint jasperPrint=JasperFillManager.fillReport(jasperReport, parameter,beanColDataSource) ;
			  JasperExportManager.exportReportToPdfFile(jasperPrint, "D:/empRecords.pdf");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
   }
}
