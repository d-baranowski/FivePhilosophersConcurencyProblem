
public class Monk implements Runnable {
	public boolean alive;
	
	private final int id;
	
	private final int leftFork;
	private Fork leftHand;
	
	private final int rightFork;
	private Fork rightHand;
	
	public boolean eating;
	public int ateCount;
	
	public int thinkCounter;
	
	private final Table table;
	
	public Monk(int id, int left, int right, Table table){
		ateCount = 0;
		alive = true;
		thinkCounter = id;
		
		this.id = id;
		this.leftFork = left;
		this.rightFork = right;
		this.table = table;
	}

	@Override
	public void run() {
		while (alive){
			if (thinkCounter > 0){
				
			} else {
				pickUpLeft();
				pickUpRight();
				eat();
				
				if (ateCount > 10){
					putDownLeft();
					putDownRight();
					ateCount = 0;
				}
			}
		}	
	}
	
	private void eat(){
		if (leftHand != null && rightHand != null){
			ateCount++;
		}
	}
	
	private synchronized void pickUpLeft(){
		leftHand = table.pickUpFork(leftFork);
		if (leftHand == null){
			putDownRight();
			think(id);
		}		
	}
	
	private void putDownLeft(){
		if (leftHand != null){
			table.placeFork(leftFork, leftHand);
		}
	}
	
	private void pickUpRight(){
		rightHand = table.pickUpFork(rightFork);
		if (rightHand == null){
			putDownLeft();
			think(id);
		}		
	}
	
	private synchronized void putDownRight(){
		if (rightHand != null){
			table.placeFork(rightFork, rightHand);
		}
	}
	
	private void think(int t){
		putDownLeft();
		putDownRight();
		thinkCounter = t;
	}
	
	public String toString(){
		String s;
		s = "Monk Id: " + id + " Left Fork: " + leftFork + " Right Fork: " + rightFork + " Think for: " + thinkCounter + " Ate: " + ateCount;
		
		if (leftHand != null){
			s = s + " L ";
		}
		
		if (rightHand != null){
			s = s + " R ";
		}
		
		return s;
	}

}
