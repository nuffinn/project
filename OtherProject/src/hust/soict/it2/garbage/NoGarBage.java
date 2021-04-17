package hust.soict.it2.garbage;

public class NoGarBage {
	public static void main( String[] args) {
		StringBuffer s = new StringBuffer();
		for (int i=0; i<1000000; i++) {
			s.append("vs ");
		}
		String str = s.toString();
		System.out.println(str);
	}
}
