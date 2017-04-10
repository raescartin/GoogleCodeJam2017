import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ProblemA {
	private static boolean[] flip(boolean[] happy, int size, int i) {
		for(int j=i;j<i+size;j++){
			if(happy[j]){
				happy[j]=false;
			}else{
				happy[j]=true;
			}
		}
		return happy;
	}
	private static boolean isHappy(boolean[] happy){
		for(int i=0;i<happy.length;i++){
			if(happy[i]==false) return false;
		}
		return true;
	}
	public static void main(String[] args) throws FileNotFoundException {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/Rubn/workspace/ProblemA/bin/A-small-practice.in"))));
	    int cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int caseID = 1; caseID <= cases; ++caseID) {
	      int flips = 0;
	      String str = in.next();
	      int size = in.nextInt();
			boolean[] happy = new boolean[str.length()];
			for(int i=0;i<str.length();i++){
				happy[i]=str.charAt(i)=='+';
			}
			for(int i=0;i<=happy.length-size;i++){
					if(!happy[i]){
						flip(happy,size,i);
						flips++;
					}
			}
			if(isHappy(happy)){
				System.out.printf("Case #%d: %d%n", caseID, flips);
			}else{
				System.out.printf("Case #%d: IMPOSSIBLE%n", caseID);
			}
	    }
	}
}