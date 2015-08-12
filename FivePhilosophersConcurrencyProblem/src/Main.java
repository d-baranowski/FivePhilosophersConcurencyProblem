import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {

	public static void main(String[] args) {
		Runnable clock = new Runnable() {
		    public void run() {
		        System.out.println("1");
		    }
		};
		
		Runnable log = new Runnable() {
		    public void run() {
		        System.out.println("2");
		    }
		};

		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(clock, 0, 500, TimeUnit.MILLISECONDS);
		executor.scheduleAtFixedRate(log, 0, 1, TimeUnit.SECONDS);
		
	}

}
