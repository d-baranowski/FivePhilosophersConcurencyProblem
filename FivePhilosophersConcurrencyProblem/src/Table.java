
import java.util.Arrays;

public class Table {
	final int size;
	private Fork[] forks;
	Monk[] monks;
	
	public Table(int size){
		this.size = size;
		forks = new Fork[size];
		monks = new Monk[size];
		
		for (int i = 0; i < size; i++){
			forks[i] = new Fork(i);
			
			if (i == 0){
				monks[i] = new Monk(i,size-1,0,this);
			} else {
				monks[i] = new Monk(i,i-1,i,this);
			}
		}
	}
	
	public synchronized Fork[] getForks(){
		return forks;
	}
	
	public Fork pickUpFork(int i){
		Fork f = null;
		if (forks[i] != null){
			f = forks[i];
			forks[i] = null;
			return f;
		} else {
			return f;
		}
	}
	
	public void placeFork(int i, Fork fork){
		if (forks[i] == null){
			forks[i] = fork;
		} 
	}
	
	public String toString(){
		String s = "";
		for (int i = 0; i < size; i++){
			s = s + monks[i].toString() + "\n";
		}
		
		return s + Arrays.toString(forks);
	}

}
