package net.itinajero.app.model;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.mysql.jdbc.Connection;

import jdk.nashorn.internal.parser.JSONParser;
import net.itinajero.app.controller.HomeController;
import net.itinajero.app.service.IParametrosService;
import net.itinajero.app.service.IPartidosService;
import net.itnajero.app.accesodatos.AccesoDB;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.FontKey;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.PdfFont;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JRReportTemplate;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignExpression;
import net.sf.jasperreports.engine.design.JRDesignParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;



@SuppressWarnings("deprecation")
public class Reporte {
	
	private final static Logger log = Logger.getLogger(HomeController.class);	
	
	protected JasperDesign _reportDesign; 
	protected JasperReport _reportCompile;
	protected JasperPrint _reportPrint;
	protected String _rutaReportes;
	protected String _rutaSalida;
	protected String _rutaJson;
	protected String _reporte; 
	protected String _archivo;	
	protected String _archivoSalida;
	protected HashMap<String, Object> _parametros; 
	protected HashMap<String, Reporte> _subreportes;
	protected Exception _exception;
	
	protected static String _ambiente; 	

	public void setRutaReporte(String sPath){
		_rutaReportes = sPath;
	}

	public void setRutaSalida(String sPath){
		_rutaSalida = sPath;
	}

	public void setRutaJson(String sPath){
		_rutaJson = sPath;
	}
	
	protected void formatearNombreArchivo(){
		_archivo = _reporte + ".jrxml";
		
	}
	 
	public void setAmbiente(String sPath){
		_ambiente = sPath;
	}	
	 
	
	public boolean generar(String nombreReporte, HashMap<String, Object> parametros, String extension, String ambiente){
		_reporte = nombreReporte;
		_ambiente = ambiente;
		formatearNombreArchivo();
		_archivoSalida = null;

		if (parametros == null)
			_parametros = new HashMap<String, Object>();
		else 
			_parametros = parametros;
		
			
		
		try {
			
			// agregarParametrosJson();
			
	//		agregarParametrosDefault();
			
			if (extension.equalsIgnoreCase("xls"))
				_parametros.put(JRParameter.IS_IGNORE_PAGINATION, true);

			abrirReportDesign();
			
			compilarReporte();
			
			llenarReporte();
			
			exportarReporte(extension);
			
			return true;
		} catch (Exception e) {
			_exception = e;
			return false;
		} 
	}
	
	protected void agregarParametrosDefault(){
		_parametros.put("RUTAREPORTES", _rutaReportes);
	}

	
	protected void abrirReportDesign() throws Exception{
	//	_reportDesign = JRXmlLoader.load(_rutaReportes + _archivo);
		
		String ruta = extraerRutaReportes();
				
		_reportDesign = JRXmlLoader.load(ruta + _archivo);

		// le agrega la ruta completa a los  templates
		JRReportTemplate templates[] = _reportDesign.getTemplates();
		if (templates != null)
			for (int i = 0; i < templates.length; i++){
				JRDesignExpression expresion = (JRDesignExpression) templates[i].getSourceExpression();
				expresion.setText("\"" + _rutaReportes.replace("\\", "\\\\") + "\" + " + expresion.getText());
			}

	}
	
    public static String extraerRutaReportes() {
        String dir = "";
     //   EntityManager unAcceso = AccesoDB.obtenerInstancia("Parametro");
        if (_ambiente == "desarrollo"){
        	
        }

// pregunta si esta en webapps, o sea servidor, si no busca en reporte de desarrollo parece.
        // baja directorios hasta llegar a webapps, ahi agrega nombre de app donde se esta ejecutando y queda en ruta
        //relativa.
        File f = new File(Reporte.class.getProtectionDomain().getCodeSource().getLocation().getFile());

        log.warn(f.getAbsoluteFile());
        log.warn(f.getName());
        while ((f != null) && !f.getName().equalsIgnoreCase("webapps")) {
                dir = f.getName();
                f = f.getParentFile();
        }
  

        if (f == null)
                //return  "C:\\Program Files\\Apache Software Foundation\\apache-tomcat-6.0.26\\webapps\\Sigue-Testing\\Inicio" //System.getProperty("user.dir")
        		return "C:\\Users\\GuidoB\\Desktop\\programacion\\sts-bundle\\workspaceprode\\prodeapp\\src\\main\\resources\\jasperreports\\";
                                //+ File.separator
                               // +"reportes"
                              //  + File.separator;
        else
        	    log.warn(f.getName()+ "F pos while");
                return  f.getAbsolutePath()
                                + File.separator
                                + dir
                                + File.separator
                                +"WEB-INF"
                                + File.separator
                                +"classes"
                                + File.separator
                                +"jasperreports"
                                + File.separator;
	}	

	protected void compilarReporte() throws Exception{
		compilarSubreportes();
		_reportCompile = JasperCompileManager.compileReport(_reportDesign);
	}
	
	protected void compilarSubreportes() throws Exception{
		_subreportes = new HashMap<String, Reporte>();
		JRParameter parametros[] = _reportDesign.getParameters();
		for (int i=0; i < parametros.length; i++){
			JRDesignParameter parametro = (JRDesignParameter) parametros[i];
			if (!parametro.isSystemDefined() && parametro.getValueClassName().equals("net.sf.jasperreports.engine.JasperReport") ){
			//	SubReporte subreporte = new SubReporte(this);
			//	subreporte.generarSubreporte(parametro.getName());
			//	_subreportes.put(parametro.getName(), subreporte);
			//	_parametros.put(parametro.getName(), subreporte._reportCompile);
				
			}
			
		}
	}
	
	protected void llenarReporte() throws Exception{
		_reportPrint = JasperFillManager.fillReport(_reportCompile, _parametros);
		 if (_reportPrint.getPages().size() == 0 ) throw new Exception("reportevacio");
	}

	protected void formatearNombreArchivoSalida(String extension){
		_archivoSalida  = _reporte + "." + extension;	
	}

	protected void exportarReporte(String extension) throws Exception{
		
		String _rutaSalida = extraerRutaReportes();
		/*
		String unaRutaSalida = archivoCompilado.getParentFile().getParent() 
				+ File.separatorChar 
				+ "output"
				+ File.separatorChar
				+ getNombre().toLowerCase() 
				+ "_" 
				+ "guido"
				+ "_"
				+ Long.toString(Calendar.getInstance().getTime().getTime())
				+ "." + extension ;		
		*/
		formatearNombreArchivoSalida(extension);
		
		if (_rutaSalida == null)
			_rutaSalida = _rutaReportes;
		
		String sPathCompleto = _rutaSalida + _archivoSalida;
		
		if (extension.equalsIgnoreCase("pdf"))
			exportarPdf(_reportPrint, sPathCompleto);
		else if (extension.equalsIgnoreCase("xls"))
			exportarXls(_reportPrint, sPathCompleto);
	}

	private void exportarPdf(JasperPrint jrPrint, String unaRutaSalida) throws JRException{
		JRPdfExporter exporter = new JRPdfExporter();
		Map<Object, Object> fontMap = new HashMap<Object, Object>();

		fontMap.put(new FontKey("SansSerif", false, false), new PdfFont("Helvetica","Cp1252",false));
		fontMap.put(new FontKey("SansSerif", true, false), new PdfFont("Helvetica-Bold","Cp1252",false));
		fontMap.put(new FontKey("SansSerif", false, true), new PdfFont("Helvetica-Oblique","Cp1252",false));
		fontMap.put(new FontKey("SansSerif", true, true), new PdfFont("Helvetica-BoldOblique","Cp1252",false));
						
		exporter.setParameter(JRExporterParameter.FONT_MAP,fontMap);
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jrPrint);
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, unaRutaSalida);
		
		exporter.exportReport();
		// exporter.exportReportToPdfFile()
		
	}
	
	private void exportarXls(JasperPrint jrPrint, String unaRutaSalida) throws JRException{
		JRXlsExporter exportador = new JRXlsExporter();
		exportador.setParameter(JRXlsExporterParameter.JASPER_PRINT, jrPrint);
		exportador.setParameter(JRXlsExporterParameter.OUTPUT_FILE_NAME, unaRutaSalida);
		exportador.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
		exportador.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		exportador.setParameter(JRXlsExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
		exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS, Boolean.TRUE);
		exportador.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);

		exportador.exportReport();
	}
	

	public Exception getException(){
		return _exception;
	}

	
	public String getStackTrace(){
		if (_exception == null)
			return "";
		StringWriter sw = new StringWriter(); 
		_exception.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

	public String getExceptionMessage(){
		if (_exception == null)
			return "";
		return _exception.getMessage();
	}

	public String getSalida(){
		return _archivoSalida;
	}

	
}

