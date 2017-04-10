import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class ProblemB {
	public static void main(String[] args) throws FileNotFoundException {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream("C:/Users/Rubn/workspace/ProblemB/bin/B-small.in"))));
	    int cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int caseID = 1; caseID <= cases; ++caseID) {
	      String str = in.next();
	      boolean tidy = false;
	      if(str.length()!=1){
	    	  for(int i=0;i<str.length()-1;i++){
	    		  if(Character.getNumericValue(str.charAt(i))>Character.getNumericValue(str.charAt(i+1))){
	    			  while(i-1>=0&&str.charAt(i)==str.charAt(i-1)){
	    				  i--;
	    			  }
	    			  char[] strChars = str.toCharArray();
	    			  strChars[i] = Character.forDigit((Character.getNumericValue(strChars[i])-1),10);
	    			  for(int j=i+1;j<str.length();j++){
	    				  strChars[j]='9';
	    			  }
	    			  if(strChars[0]=='0'){strChars =Arrays.copyOfRange(strChars, 1, strChars.length);}
	    			  str = String.valueOf(strChars);
	    		  }
	    	  }
	      }
	      System.out.printf("Case #%d: %s%n", caseID, str);
	    }
	}
}
