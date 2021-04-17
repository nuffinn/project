package hust.soict.it2.aims.utils;

public class DateUtils {
	public DateUtils() {
		super();
	}

	public boolean compareDate(MyDate date7, MyDate date8) {
		int a,b,c,d,e,f;
		a= date7.getDay();
		b= date7.getMonth();
		c= date7.getYear();
		d= date8.getDay();
		e= date8.getMonth();
		f= date8.getYear();
		if (c<f) {
			return true;
		}else if (c>f) {
			return false;
		}else if (c==f) {
			if(b<e) {
				return true;
			}else if(b>e) {
				return false;
			}else if(b==e) {
				if(a<d) {
					return true;
				}else if(a>d) {
					return false;
				}else if(a==d) {
					date7.printToFormat();
					System.out.print(" = ");
					date8.printToFormat();
				}
			}
		}
		return true;
		
	}
	
	public void sortDate(MyDate[] dateList) {
		int i,j;
		for (i=0; i <dateList.length; i++) {
			for (j=i+1; j < dateList.length; j++) {
				if(compareDate(dateList[i],dateList[j])) {
					MyDate tmp = new MyDate();
					tmp = dateList[i];
					dateList[i] = dateList[j];
					dateList[j] = tmp;
				}
			}
		}
	}
}

