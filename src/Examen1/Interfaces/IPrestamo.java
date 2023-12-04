package Examen1.Interfaces;

public interface IPrestamo {
	long calcDelayDays();
	int calcDebtMoney();
	String calcBorrowState();
	boolean calcDefaulterClient();
	void calcAllData();
	
	
}
