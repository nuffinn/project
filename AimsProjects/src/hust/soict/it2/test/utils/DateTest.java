package hust.soict.it2.test.utils;

import hust.soict.it2.aims.utils.DateUtils;
import hust.soict.it2.aims.utils.MyDate;

public class DateTest {
	
	public static void main(String[] args) {
		MyDate date = new MyDate(28,6,2020);
		MyDate date1 = new MyDate(29,6,2020);
		MyDate date2 = new MyDate(27,6,2020);
		MyDate date3 = new MyDate(23,7,2020);
		MyDate dateList[] = {date, date1, date2, date3};
		DateUtils util = new DateUtils();
		util.sortDate(dateList);
		int i;
		for (i=0; i<dateList.length; i++) {
			dateList[i].printDate();
			System.out.print("\n");
		}
		boolean n = util.compareDate(date2, date3);
		System.out.println(n);
	}
}
