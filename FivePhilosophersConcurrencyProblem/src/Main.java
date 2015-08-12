import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {

	public static void main(String[] args) {
		
		//Responsible for counting passed time
		Runnable clock = new Runnable() {
		    public void run() {
		        
		    }
		};
		
		//Responsible for logging state of the program to console
		Runnable log = new Runnable() {
		    public void run() {
		        
		    }
		};

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(clock, 0, 500, TimeUnit.MILLISECONDS);
		executor.scheduleAtFixedRate(log, 0, 1, TimeUnit.SECONDS);
		
		Table table = new Table(5);
		System.out.println(table.toString());
		
	}

}
