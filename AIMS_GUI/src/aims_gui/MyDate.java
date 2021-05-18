package aims_gui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;

public class MyDate {
	@SuppressWarnings("deprecation")
	public MyDate(String strDate) throws ParseException {
		super();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
		date = formatter.parse(strDate);
		this.day = date.getDate();
		this.month = date.getMonth() + 1;
		this.year = date.getYear() + 1900;
	}
	
	public MyDate() {
		super();
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		this.day = calendar.get(Calendar.DATE);
		this.month = calendar.get(Calendar.MONTH) + 1;
		this.year = calendar.get(Calendar.YEAR);
	}
	
	public MyDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	private int day;
	private int month;
	private int year;
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (day > 0 && day < 32 ) this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month >0 && month <13) this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year > 0) this.year = year;
	}
	
	public void accept() throws ParseException {
		System.out.println("Enter a date: ");
		Scanner scanner = new Scanner(System.in);
		String date1 = scanner.nextLine();
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MMM dd yyyy");
		date = formatter.parse(date1);
		this.day = date.getDate();
		this.month = date.getMonth() + 1;
		this.year = date.getYear() + 1900;
	}
	
	public void print() {
		Date date1 = new Date();
		date1.setMonth(this.month-1);
		DateFormat dateFormat = new SimpleDateFormat("MMMMM");
		System.out.println(dateFormat.format(date1) + " " + this.day + "th " + this.year);
	}
	
	public void printToFormat() {
		Date date2 = new Date(this.year-1900, this.month, this.day);
		DateFormat dft = new SimpleDateFormat("dd-MMM-yyyy");
		System.out.print(dft.format(date2));
	}
	
	public void printDate() {
		System.out.print(this.day + "/" + this.month + "/" + this.year);
	}
}

