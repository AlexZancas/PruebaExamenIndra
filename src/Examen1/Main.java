package Examen1;

import java.util.ArrayList;

import Examen1.Classes.FileManager;
import Examen1.Classes.Prestamo;

public class Main {

	public static void main(String[] args) {
		ArrayList<Prestamo> listaPrestamos = new ArrayList<Prestamo>();
		FileManager fileManager = new FileManager("D:\\INDRA\\Java\\ExamenFinal\\PruebaExamenIndra\\Biblioteca Nacional de España.txt");
		fileManager.getData(listaPrestamos);
		String text = getText(listaPrestamos);
		fileManager.writeFile("D:\\INDRA\\Java\\ExamenFinal\\PruebaExamenIndra\\Biblioteca Nacional de España.txt", text);
		
		

	}
	
	public static String getText(ArrayList<Prestamo> lista) {
		String text = "";
		
		for(int i=0; i<lista.size(); i++) {
			text += "Nombre: " + lista.get(i).getName()
					+"Author: "+ lista.get(i).getAuthor()
					+"Fecha peticion: "+ lista.get(i).getBorrowDate().getDate()
					+"Fecha de vuelta: " + lista.get(i).getBorrowDate().getDate()
					+"Ha sido prestado: " + lista.get(i).getBorrowState().toString()
					+"DNI: " + lista.get(i).getDni()
					+"Dias de retraso: "+ lista.get(i).getDelayDays()
					+"Dinero deuda: " + lista.get(i).getDebtMoney()
					+"Estado prestamo: " + lista.get(i).getBorrowState()
					+"Deudor: " + lista.get(i).isDefaulterClient();
		}
		return text;
		}

}
