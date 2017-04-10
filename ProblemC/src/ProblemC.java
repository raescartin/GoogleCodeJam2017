import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class ProblemC {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/Rubn/workspace/ProblemC/bin/C-small-1-attempt0.in"))));
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int caseID = 1; caseID <= cases; ++caseID) {
	      long n = in.nextLong();
	      long k = in.nextLong();
	      long max = getMax(n,k); 
	      long min = getMin(n,k);
		  System.out.printf("Case #%d: %d %d%n", caseID, max, min);
	    }
	}

	private static long getMax(long n, long k) {
		if(k==1){
			return n/2;
		}else{
			 if(k%2==1){//odd number
		    	  return getMin(n,k/2)/2;
		      }else{
		    	  return getMax(n,k/2)/2;
		      }
		}
	}

	private static long getMin(long n,long k) {
		if(k==1){
			return (n-1)/2;
		}else{
			 if(k%2==1){//odd number
		    	  return (getMin(n,k/2)-1)/2;
		      }else{
		    	  return (getMax(n,k/2)-1)/2;
		      }
		}
	}
}
