import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {

	public static void main(String[] args) {
		Table table = new Table(5);
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(7);
		for (int i = 0; i < table.monks.length;i++){
			executor.scheduleAtFixedRate(table.monks[i], 0, 1, TimeUnit.SECONDS);
		}
		
		//Responsible for counting passed time
		Runnable clock = new Runnable() {
		    public void run() {
		    	for (int i = 0; i < table.monks.length;i++){
		    		if(table.monks[i].thinkCounter > 0){
		    			table.monks[i].thinkCounter--;
		    		}
		    	}
		    }
		};
		
		//Responsible for logging state of the program to console
		Runnable log = new Runnable() {
		    public void run() {
		    	System.out.println(table.toString() + "\n\n");
		    }
		};

		
		executor.scheduleAtFixedRate(clock, 0, 1, TimeUnit.SECONDS);
		executor.scheduleAtFixedRate(log, 0, 1, TimeUnit.SECONDS);
		
		
		
		
		
		
	}

}
