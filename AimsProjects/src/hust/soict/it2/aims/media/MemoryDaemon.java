package hust.soict.it2.aims.media;

public class MemoryDaemon implements java.lang.Runnable {

	public MemoryDaemon() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		Runtime rt = Runtime.getRuntime();
		long used;
		
		while(true) {
			used =rt.totalMemory() - rt.freeMemory();
			if (used != memoryUsed) {
				System.out.println("\tMemory used = " + used);
				memoryUsed =used;
			}
		}
	}

	long memoryUsed = 0;
}
