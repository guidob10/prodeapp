package net.itinajero.app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
//import ar.com.jasperphp.cfe.reporte.Reporte;

public class RptProde extends Reporte {

	private String _username;
	protected Connection _cn;
	private String _titulo;

	protected JRDataSource _ds;
	
	public static RptProde obtenerInstancia(String nombre){
		return new RptProde();
	}

	@Override
	public boolean generar(String nombreReporte,HashMap<String, Object> parametros,String extension, String ambiente) {
		// _username = (String) parametros.get("username");
		return super.generar(nombreReporte,parametros, extension,ambiente);
	}
	
	@Override
	protected void abrirReportDesign() throws Exception {
		iniciarConneccion();
		super.abrirReportDesign();
	}
	
	protected void formatearNombreArchivoSalida(String extension){
		String unString = Long.toString(Calendar.getInstance().getTime().getTime());		
		_archivoSalida = _reporte + (_username == null ? "" : "_" + _username) + "_" + unString + "." + extension;
		
	}
	@Override
	protected void exportarReporte(String extension) throws Exception {
		formatearNombreArchivoSalida(extension);
		super.exportarReporte(extension);
		if (_cn != null)
			_cn.close();
	}
	
	@Override
	protected void llenarReporte() throws Exception {
		if (_ds == null)
			_parametros.put(JRParameter.REPORT_CONNECTION, _cn);
		else
			_parametros.put(JRParameter.REPORT_DATA_SOURCE, _ds);
			_parametros.put("titulo", _titulo);
		
		super.llenarReporte();
	}
	
	
	
    protected void iniciarConneccion() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {

    }

	public void setTitulo(String titulo) {
		_titulo = titulo;
	}
	
	public void setDs(JRBeanCollectionDataSource ds) {
		_ds = ds;
	}	

	
}
