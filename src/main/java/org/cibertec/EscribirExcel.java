package org.cibertec;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EscribirExcel {
	public static void crearPartirDeArrayList() {
		ArrayList<Persona> personas = new ArrayList<>();
		personas.add(new Persona("Carlos Trillo","https://www.CarlonchoTroncho.com",53));
		personas.add(new Persona("Ever Silva","https://www.Everaady.newt",53));
		personas.add(new Persona("Jual Alvites","https://www.jaunvitz.com",70));
		Workbook libro = new XSSFWorkbook();
		final String nombreArchivo = "Personas.xlsx";
		Sheet hoja = libro.createSheet("Personas");
		
		
		String[] encabezados = {"Nombre", "Web", "Edad"};
		int indiceFila = 0;
		
		Row fila=hoja.createRow(indiceFila);
		for (int i= 0; i< encabezados.length; i++ ) {
			String encabezado = encabezados[i];
			Cell celda = fila.createCell(i);
			celda.setCellValue(encabezado);
		}
		indiceFila++;
		for (int i = 0; i < personas.size(); i++) {
			fila = hoja.createRow(indiceFila);
			Persona persona = personas.get(i);
			fila.createCell(0).setCellValue(persona.getNombre());
			fila.createCell(1).setCellValue(persona.getWeb());
			fila.createCell(2).setCellValue(persona.getEdad());
			indiceFila++;
			
		}
		
		//Guardamos
		
		File directoriolActual = new File(".");
		String ubicacion = directoriolActual.getAbsolutePath();
		String ubicacionArchivoSalida = ubicacion.substring(0,ubicacion.length()-1)+nombreArchivo;
		
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(ubicacionArchivoSalida);
			libro.write(outputStream);
			libro.close();
			System.out.println("Libro de personas guardado correctamente");
		} catch (FileNotFoundException ex) {
			System.out.println("Error de fienotfound");
			
		} catch (IOException ex) {
			System.out.println("Error de IOException");
		}	
		
	}
	
	public static void main (String[] args) {
		crearPartirDeArrayList();
	}

}
