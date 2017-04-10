import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;


public class ProblemD {
	public static void main(String[] args) {
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int cases = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
	    for (int caseID = 1; caseID <= cases; ++caseID) {
	      int n = in.nextInt();
			boolean[] used = new boolean[10];
			int p = 0;
			long res = -1;
			for (int i = 1; i < 1000000; i++) {
				long a = n * i;
				while (a > 0) {
					int b = (int)(a % 10);
					if (!used[b]) {
						used[b] = true;
						p++;
					}
					a /= 10;
				}
				if (p == 10) {
					res = n * i;
					break;
				}
			}
			if (res >= 0) System.out.printf("Case #%d: %d%n", caseID, res);
			else System.out.printf("Case #%d: INSOMNIA%n", caseID);
	    }
	}
}
