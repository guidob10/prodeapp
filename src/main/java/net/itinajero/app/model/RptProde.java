package net.itinajero.app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRParameter;
//import ar.com.jasperphp.cfe.reporte.Reporte;

public class RptProde extends Reporte {

	private String _username;
	protected Connection _cn;

	protected JRDataSource _ds;

	private String db_url;
	private String db_driver;
	private String db_name;
	private String db_username;
	private String db_password;
	
	public static RptProde obtenerInstancia(String nombre){
		return new RptProde();
	}

	@Override
	public boolean generar(String nombreReporte,HashMap<String, Object> parametros,String extension) {
		// _username = (String) parametros.get("username");
		return super.generar(nombreReporte,parametros, "pdf");
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
		_cn.close();
	}
	
	@Override
	protected void llenarReporte() throws Exception {
		if (_ds == null)
			_parametros.put(JRParameter.REPORT_CONNECTION, _cn);
		else
			_parametros.put(JRParameter.REPORT_DATA_SOURCE, _ds);
		
		super.llenarReporte();
	}
	
	
    protected void iniciarConneccion() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
    {
    	
    	
		//$db_name = "siga";
		//$db_driver = 'net.sourceforge.jtds.jdbc.Driver';
		//$db_url = "jdbc:jTDS:sqlserver://192.168.1.243/";
		 
    	String url = "jdbc:mysql://localhost:3306/";
//		String url = "mysql:host=localhost/";
		
//		String dbName = db_name;
    	String dbName = "prode";
//		String driver = db_driver;
    	String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "root";
		
		Class.forName(driver).newInstance();
		_cn = DriverManager.getConnection(url+dbName,userName,password);
    }

	public void setDb_url(String dbUrl) {
		db_url = dbUrl;
	}

	public void setDb_driver(String dbDriver) {
		db_driver = dbDriver;
	}

	public void setDb_name(String dbName) {
		db_name = dbName;
	}

	public void setDb_username(String dbUsername) {
		db_username = dbUsername;
	}

	public void setDb_password(String dbPassword) {
		db_password = dbPassword;
	}

	
}
