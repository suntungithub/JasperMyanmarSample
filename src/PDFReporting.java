/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author suntun
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
//import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;


public class PDFReporting {
        static final String fileName = "src/reports/UnicodeReport.jrxml";
	static final String outFile = "src/reports/UnicodeReport.pdf";
        public static void main(String[] args) throws JRException, FileNotFoundException {
            
            Map<String, Object> parameter = new HashMap<String, Object>();
            
                parameter.put("title", new String("Hello"));
            
            	JasperReport jasperDesign = JasperCompileManager.compileReport(fileName);
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperDesign, parameter, new JREmptyDataSource());

		File file = new File(outFile);
		OutputStream outputSteam = new FileOutputStream(file);
		JasperExportManager.exportReportToPdfStream(jasperPrint, outputSteam);


		System.out.println("Report Generated!");
                JasperViewer.viewReport(jasperPrint, false);

        }    
}
