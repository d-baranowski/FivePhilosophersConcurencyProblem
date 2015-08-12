
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class Monk implements Runnable {
	public boolean alive;
	
	private final int id;
	
	private final int leftFork;
	private Fork leftHand;
	
	private final int rightFork;
	private Fork rightHand;
	
	public boolean eating;
	
	AtomicInteger totalAte;
	AtomicInteger ateCount;
	
	public AtomicInteger thinkCounter;
	
	private final Table table;
	
	public Monk(int id, int left, int right, Table table){
		totalAte = new AtomicInteger(0);
		ateCount = new AtomicInteger(0);
		alive = true;
		thinkCounter = new AtomicInteger(0);
		
		this.id = id;
		this.leftFork = left;
		this.rightFork = right;
		this.table = table;
	}

	@Override
	public void run() {
		while (alive){
			if (thinkCounter.intValue() > 0){
				putDownLeft();
				putDownRight();
				thinkCounter.decrementAndGet();
			} else {
				
				if (leftHand != null){
					if (rightHand != null){
						eating = true;
					}
				} else {
					eating = false;
				}
				
				if (eating){
					ateCount.incrementAndGet();
					totalAte.incrementAndGet();
				} else {
					pickUpLeft();
					pickUpRight();
				}
									
				if (ateCount.intValue() > 10){
					putDownLeft();
					putDownRight();
					ateCount.set(0);
				}
			}
			
			
		}
		
	}
			
	private synchronized void pickUpLeft(){
		leftHand = table.pickUpFork(leftFork);
		if (leftHand == null){
			putDownRight();
			think(1);
		}		
	}
	
	private void putDownLeft(){
		if (leftHand != null){
			table.placeFork(leftFork, leftHand);
			leftHand = null;
			eating = false;
		}
	}
	
	private void pickUpRight(){
		rightHand = table.pickUpFork(rightFork);
		if (rightHand == null){
			putDownLeft();
			think(1);
		}		
	}
	
	private synchronized void putDownRight(){
		if (rightHand != null){
			table.placeFork(rightFork, rightHand);
			rightHand = null;
			eating = false;
		}
	}
	
	private void think(int t){
		putDownLeft();
		putDownRight();
		thinkCounter.set(t);;
	}
	
	public String toString(){
		String s;
		s = "Monk Id: " + id + " Left Fork: " + leftFork + " Right Fork: " + rightFork + " Think for: " + thinkCounter + " Ate: " + totalAte.intValue() + " Eating: " + eating;
		
		if (leftHand != null){
			s = s + " L ";
		}
		
		if (rightHand != null){
			s = s + " R ";
		}
		
		return s;
	}

}
