package Examen1.Classes;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.time.temporal.ChronoUnit;

import Examen1.Interfaces.IPrestamo;

public class Prestamo implements IPrestamo{
	private String name;
	private String author;
	private Date borrowDate;
	private Date returnDate;
	private boolean isBorrowed;
	private String dni;

	
	private long delayDays;
	private int debtMoney;
	private String borrowState;
	private boolean defaulterClient;
	
	public Prestamo() {};
	
	public Prestamo(String name, String author, Date borrowDate, Date returnDate, boolean isBorrowed, String dni) {
		super();
		this.name = name;
		this.author = author;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.isBorrowed = isBorrowed;
		this.dni = dni;
		
		this.delayDays = calcDelayDays();
		this.debtMoney = calcDebtMoney();
		this.borrowState = calcBorrowState();
		this.defaulterClient = calcDefaulterClient();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public boolean isBorrowed() {
		return isBorrowed;
	}
	public void setBorrowed(boolean isBorrowed) {
		this.isBorrowed = isBorrowed;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public long getDelayDays() {
		return delayDays;
	}
	public void setDelayDays(int delayDays) {
		this.delayDays = delayDays;
	}
	public int getDebtMoney() {
		return debtMoney;
	}
	public void setDebtMoney(int debtMoney) {
		this.debtMoney = debtMoney;
	}
	public String getBorrowState() {
		return borrowState;
	}
	public void setBorrowState(String borrowState) {
		this.borrowState = borrowState;
	}
	public boolean isDefaulterClient() {
		return defaulterClient;
	}
	public void setDefaulterClient(boolean defaulterClient) {
		this.defaulterClient = defaulterClient;
	}
	
	
	
	@Override
	public long calcDelayDays() {
		LocalDate returnDate = this.returnDate.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate();
		
		LocalDate todayDate = LocalDate.now();		
		
		long delayedDays = ChronoUnit.DAYS.between(returnDate, todayDate);
		return delayedDays;
	}
	
	@Override
	public String calcBorrowState() {
		if(this.delayDays>=10) {
			return "VENCIDO";
		}else {
			return "EN REGLA";
		}
		
	}
	
	@Override
	public int calcDebtMoney() {
		int debtMoney = (int) delayDays;
		return debtMoney;
	}
	
	@Override
	public boolean calcDefaulterClient() {
		if(this.borrowState.equals("VENCIDO")) {
			return true;
		}else {
			return false;
		}
		
		
	}

	@Override
	public void calcAllData() {
		this.delayDays = calcDelayDays();
		this.debtMoney = calcDebtMoney();
		this.borrowState = calcBorrowState();
		this.defaulterClient = calcDefaulterClient();
		
	}
	
	
	
}
