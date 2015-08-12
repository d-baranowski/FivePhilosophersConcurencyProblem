import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {
	private static final int SIZE = 50;
	public static void main(String[] args) {
		Table table = new Table(SIZE);
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(SIZE + 1);
		
				
		//Responsible for logging state of the program to console
		Runnable log = new Runnable() {
		    public void run() {
		    	System.out.println(table.toString() + "\n\n\n");
		    }
		};

		executor.scheduleAtFixedRate(log, 0, 1, TimeUnit.SECONDS);
		
//		File file = new File("out.txt");
//		FileOutputStream fos;
//
//		try {
//			fos = new FileOutputStream(file);
//			PrintStream ps = new PrintStream(fos);
//			System.setOut(ps);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		
		
		for (int i = 0; i < table.monks.length;i++){
			//executor.scheduleAtFixedRate(table.monks[i], 0, 500, TimeUnit.MILLISECONDS);
			executor.execute(table.monks[i]);
		}
		
		
		
		
		
	}

}
