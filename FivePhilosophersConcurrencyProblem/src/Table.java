
public class Table {
	final int size;
	Fork[] forks;
	Monk[] monks;
	
	public Table(int size){
		this.size = size;
		forks = new Fork[size];
		monks = new Monk[size];
		
		for (int i = 0; i < size; i++){
			forks[i] = new Fork();
			
			if (i == 0){
				monks[i] = new Monk(i,size-1,0);
			} else {
				monks[i] = new Monk(i,i-1,i);
			}
		}
	}
	
	public String toString(){
		String s = "";
		for (int i = 0; i < size; i++){
			s = s + monks[i].toString() + "\n";
		}
		return s;
	}

}
