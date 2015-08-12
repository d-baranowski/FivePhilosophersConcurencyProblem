
public class Monk implements Runnable {
	private final int id;
	private final int leftFork;
	private final int rightFork;
	
	public Monk(int id, int left, int right){
		this.id = id;
		this.leftFork = left;
		this.rightFork = right;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	
	public String toString(){
		return "Monk Id: " + id + " Left Fork: " + leftFork + " Right Fork: " + rightFork;
	}

}
