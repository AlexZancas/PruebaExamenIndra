package Examen2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;


public class Main {

	public static void main(String[] args) {
		ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
		Scanner sc = new Scanner(System.in);
		int opcion = 10;
		
		while(opcion !=3 ) {
			System.out.println("Pulse 1 para añadir un nuevo empleado\nPulse 2 para generar un .json\nPulse 3 para salir");
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch(opcion) {
				case 1:{
					createNewEmployee(listaEmpleados, sc);
					break;
				}
				case 2:{
					generateJSON(listaEmpleados);
					break;
				}
				case 3:{
					System.exit(0);
				}
				default:{
					System.out.println("Esta opción no está contemplada");
				}
			}
		}

	}
	Gson gson = new Gson();
	public static void generateJSON(ArrayList<Empleado> listaEmpleados) {
		//Pasar de ArrayList a JSON directamente
		String json = new Gson().toJson(listaEmpleados);
		File file = new File("mis_empleados.json");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(json);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public static void createNewEmployee(ArrayList<Empleado> listaEmpleados, Scanner sc) {
		Empleado empleado = new Empleado();
		
		System.out.println("Introduzca el nombre del empleado");
		empleado.setNombre(sc.nextLine());
		
		System.out.println("Introduzca el apellido del empleado");
		empleado.setApellido(sc.nextLine());
		
		System.out.println("Introduzca la fecha de ingreso del empleado, con formato dd/MM/yyyy");
		String strFechaIngreso = sc.nextLine();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date ingresoDate = simpleDateFormat.parse(strFechaIngreso);
			empleado.setFechaIngreso(ingresoDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		System.out.println("Introduzca la fecha de salida del empleado, con formato dd/MM/yyyy");
		String strFechaSalida = sc.nextLine();
		try {
			Date salidaDate = simpleDateFormat.parse(strFechaSalida);
			empleado.setFechaSalida(salidaDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Introduzca el sexo del empleado");
		empleado.setSexo(sc.nextLine());
		
		System.out.println("Introduzca la ciudad del empleado");
		empleado.setCiudad(sc.nextLine());
		
		System.out.println("Introduzca el salario base del empleado");
		empleado.setSalarioBase(sc.nextInt());
		sc.nextLine();
		
		System.out.println("Introduzca la posicion del empleado");
		empleado.setPosicion(sc.nextLine());
		
		empleado.calcAll();
		listaEmpleados.add(empleado);
		
		System.out.println("\n¡Empleado añadido!\n");
		
	}

}
