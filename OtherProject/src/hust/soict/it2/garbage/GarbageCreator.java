package hust.soict.it2.garbage;

public class GarbageCreator {
	public static void main( String[] args) {
		String s = "v";
		for (int i=0; i<1000000; i++) {
			s += "as ";
		}
		System.out.println(s);
	}
}
