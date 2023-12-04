package Examen1.Classes;




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class FileManager {
	private String filepath;
	
	public void getData(ArrayList<Prestamo> listaPrestamos) {
		File file = new File(filepath);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while(line !=null) {
				
				
				
				
				String unformatedLine = line.toLowerCase().replaceAll("\n", ""); //regex para eliminar todos los caracteres especiales
				Prestamo prestamo = new Prestamo();
				switch(unformatedLine) {
					case "nombre":{
						line = br.readLine();
						unformatedLine = line.toLowerCase().replaceAll("\n", "");
						prestamo.setName(line.replace("\n", ""));
						break;
					}
					case "autor":{
						line = br.readLine();
						unformatedLine = line.toLowerCase().replaceAll("\n", "");
						prestamo.setAuthor(line.replace("\n", ""));
						break;
					}
					case "fecha de solicitud":{
						Date fecha;
						try {
							fecha = new SimpleDateFormat("dd/MM/yyyy").parse(line.replace("\n", ""));
							prestamo.setBorrowDate(fecha);
							
						} catch (ParseException e) {
							e.printStackTrace();
						}
						
						break;
					}
					case "fecha de entrega estipulada":{
						Date fecha;
						try {
							fecha = new SimpleDateFormat("dd/MM/yyyy").parse(line.replace("\n", ""));
							prestamo.setReturnDate(fecha);
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						break;
					}
					case "estado:":{
						prestamo.setBorrowState(unformatedLine);
						break;
					}
					case "dni":{
						prestamo.setDni(unformatedLine);
						break;
					}
					default:{
						System.out.println("Caso no contemplado: "+unformatedLine);
					}
					
					if(!prestamo.getDni().equals(null)) {
						prestamo.calcAllData();
					}
				}
				listaPrestamos.add(prestamo);
			}
			br.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void writeFile(String filepath, String text) {
		File file = new File(filepath);
		
		//si existe escribe
		if(dirExist(file)) {
			
			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(text);
				bw.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		//si no existe lo crea y vuelve a llamar a la funcion
		}else{
			try {
				file.createNewFile();
				writeFile(filepath, text);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	public void iterativeWriter(String filepath, String text, BufferedWriter bw) {
		File file = new File(filepath);
		
		//si existe escribe
		if(dirExist(file)) {
			
			try {
				bw.write(text);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		//si no existe lo crea y vuelve a llamar a la funcion
		}else{
			try {
				file.createNewFile();
				writeFile(filepath, text);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
	}
	
	public boolean dirExist(File dir) {
		return dir.exists();
	}

	
	public String getFilepath() {
		return filepath;
	}

	
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
}


