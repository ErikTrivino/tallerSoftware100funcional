package uniquindio.edu.co.trabajosoftware.persistence;


import uniquindio.edu.co.trabajosoftware.modelo.Hostal;


public class Persistencia {


	public static final String RUTA_ARCHIVO_MARKETPLACE_XML = "C://td//Hostal.xml";
	public static final String RUTA_ARCHIVO_LOG = "C://td//persistencia//log//Hostal_Log.txt";

	public static final String RUTA_ARCHIVO_MARKETPLACE_XML_RESPALDO = "C://td//HostalRespaldo.xml";



	public static void copiarArchivoRespaldoXml(){
		ArchivoUtil.copiarArchivoRespaldo(RUTA_ARCHIVO_MARKETPLACE_XML,RUTA_ARCHIVO_MARKETPLACE_XML_RESPALDO );
	}

	
//	----------------------LOADS------------------------
	/**
	 * GENERAR REGISTRO
	 * @param mensajeLog
	 * @param nivel
	 * @param accion
	 */
	public static  void guardaRegistroLog(String mensajeLog, int nivel, String accion) {
		ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
	}

	/**
	 * CARGAR RECURSO BINARIO
	 * @return
	 */
	public static Hostal cargarRecursoMarketplaceXML() {
		Object object = null;
		Hostal hostal = null;
		
		
		try {
			object = ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MARKETPLACE_XML);
			hostal = (Hostal) object;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return hostal;
	}

	public static  void guardarRecursoMarketplaceXML(Hostal hostal) {
		try {
			
			ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MARKETPLACE_XML, hostal);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
