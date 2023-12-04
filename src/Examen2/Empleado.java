package Examen2;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Empleado {
	private String nombre;
	private	String apellido;
	private Date fechaIngreso;
	private Date fechaSalida;
	private String sexo;
	private String ciudad;
	private String posicion;
	private int salarioBase;
	
	private double salarioNeto;
	private long antiguedadLaboral;
	private boolean isRotacion;
	
	public Empleado() {}
	
	public Empleado(String nombre, String apellido, Date fechaIngreso, Date fechaSalida, String sexo, String ciudad,
			String posicion, int salarioBase) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaIngreso = fechaIngreso;
		this.fechaSalida = fechaSalida;
		this.sexo = sexo;
		this.ciudad = ciudad;
		this.posicion = posicion;
		this.salarioBase = salarioBase;
		this.salarioNeto =  calcSalarioNeto();
		this.antiguedadLaboral = calcAntiguedadLaboral();
		this.isRotacion = calcRotacion();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public int getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(int salarioBase) {
		this.salarioBase = salarioBase;
	}
	public double getSalarioNeto() {
		return salarioNeto;
	}
	public void setSalarioNeto(double d) {
		this.salarioNeto = d;
	}
	public long getAntiguedadLaboral() {
		return antiguedadLaboral;
	}
	public void setAntiguedadLaboral(long antiguedadLaboral) {
		this.antiguedadLaboral = antiguedadLaboral;
	}
	public boolean isRotacion() {
		return isRotacion;
	}
	public void setRotacion(boolean isRotacion) {
		this.isRotacion = isRotacion;
	}
	
	public void calcAll() {
		setSalarioNeto(calcSalarioNeto());
		setAntiguedadLaboral(calcAntiguedadLaboral());
		setRotacion(calcRotacion());
	}
	
	public double calcSalarioNeto() {
		return this.salarioBase*0.83;
	} 
	
	public long calcAntiguedadLaboral() {
	
			LocalDate returnDate = this.fechaIngreso.toInstant()
				      .atZone(ZoneId.systemDefault())
				      .toLocalDate();
			
			LocalDate todayDate = LocalDate.now();		
			
			long antiguedad = ChronoUnit.DAYS.between(returnDate, todayDate);
		
		
		return antiguedad;
	}
	
	public boolean calcRotacion() {
		if(this.posicion.equals("Ingeniero")&&this.antiguedadLaboral>=2) {
			return true;
		}else if(this.posicion.equals("Ingeniero")&&this.antiguedadLaboral<2){
			return false;
		}else {
			return true;
		}
		
	}
}
