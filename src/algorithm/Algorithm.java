package algorithm;

public class Algorithm {

	private int [] memory = {10, 25, 18, 21, 31};
	private boolean [] isDone = {false, false, false, false, false};
	
	private boolean isFound;	
	private int ind = 0;
	
	public String firstFit(int x) {
		String str = "";
		int i = ind;
		
		while (i < 5) {
			isFound = false;
			if (x <= memory[i] && !isDone[i]) {
				str = "The " + (i+1) + "-memory is occupied. Done by First-Fit function.";
				isDone[i] = true;
				isFound = true;
				ind = i;
				break;
			}
			i++;
			if (i == 5)
				i = 0;
			if (i == ind)
				break;
		}
		if (isFound == false)
			str = "No available memory place";
		
		return str;
	}
	
	public String bestFit(int x) {
		String str = "";
		int indBest = -1;
		int i = ind;
		
		while (i < 5) {
			if (x <= memory[i] && !isDone[i]){
				if (indBest == -1)
					indBest = i;
				else if (memory[indBest] > memory[i])
					indBest = i;
			}
			i++;
			if (i == 5)
				i = 0;
			if (ind == i)
				break;
		}
		
		if (indBest != -1){
			str = "The " + (indBest+1) + "-memory is occupied. Done by Best-Fit function.";
			isDone[indBest] = true;
			ind = indBest;
		} else 			
			str = "No available memory space";
		
		return str;
	}
	
	public String nextFit(int x) {
		String str = "";
		isFound = false;
		int i = ind;
		
		while (i < 5) {
			isFound = false;
			if (x <= memory[i] && !isDone[i]){
				isFound = true;
				ind = i;
				break;
				
			}
			i++;
			if (i == 5) 
				i = 0;
			if (ind == i)
				break;
		}
		
		if (isFound){
			str = "The " + (i+1) + "-memory is occupied. Done by Next-Fit function.";
			isDone[i] = true;
		}
		else 
			str = "No available memory space";
		
		return str;
	}

}