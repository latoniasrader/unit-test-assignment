import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
				if(a <= 0 || b <= 0) {
						throw new IllegalArgumentException("Both parameters must be positive!");	
					}
		return a + b;
		
	}
	
    public  double groceryBudget(double perWeek, double overBudget) {
    	if(overBudget > 250.0)  {
    		throw new IllegalArgumentException("You spend over your grocery budget for this week.");
    		}else if(perWeek <= 250.0) {	
    			}
		return perWeek;
    		}
     
   public  int randomNumberSquared() {
	   int random = 1;
	   for(;random < 10;) {
   }
      return random;
   }
          
        	  int getRandomint() {
        		 
        	    Random random = new Random();
        			 return random.nextInt(10) + 1;
        	  	
		
    }
          }
   

		
	
	


