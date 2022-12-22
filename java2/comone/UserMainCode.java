package ty.comone;

public class UserMainCode {
	
	public static int sumOfOddEvenPosition(int number) {
		int temp=number;
	    int count=0;	    
		while(number!=0){
			
			count++;
			number=number/10;	
		}
		int given[]=new int[count];
		
		for(int i=count-1;i>=0;i--) {
			int index=temp%10;
			given[i]=index;
			temp=temp/10;
		}
		

		int sum=0;
		int even=0;
		for(int i=0;i<given.length;i++) {
			if(i%2==0) {
				sum=sum+given[i];
				
			}
			else
				even=even+given[i];
		}
		if(even==sum) {
			return 1;
		}
		else
			return -1;
		
	}
	}
