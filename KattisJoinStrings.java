import java.io.*;
import java.util.*;

public class KattisJoinStrings {
	public static void printRecursively(FastIO fio, int i, String[] strings, ArrayList<ArrayList<Integer>> ops) {
		fio.print(strings[i]);
		for (int j : ops.get(i)) {
			printRecursively(fio, j, strings, ops);
		}
	}

	public static void main(String[] args) {
		FastIO fio = new FastIO();
		int stringNo = fio.nextInt();

		String[] strings = new String[stringNo];
		ArrayList<ArrayList<Integer>> ops = new ArrayList<>(stringNo);
		for (int i = 0; i < stringNo; i++) {
			strings[i] = fio.next();
			ops.add(i, new ArrayList<Integer>());
		}

		int n1 = 0;
		int n2 = 0; 
		int last = 0;

		for (int i = 0; i < stringNo - 1; i++) {
			n1 = fio.nextInt();
			n2 = fio.nextInt();
			n1--;
			n2--;
			last = n1;

			ops.get(n1).add(n2);
		}
		printRecursively(fio, last, strings, ops);
		fio.close();
	}
}

/**
 * Fast I/O
 * @source https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
 */
class FastIO extends PrintWriter 
{ 
	BufferedReader br; 
	StringTokenizer st;

	public FastIO() 
	{ 
		super(new BufferedOutputStream(System.out)); 
		br = new BufferedReader(new
				InputStreamReader(System.in));
	} 

	String next() 
	{ 
		while (st == null || !st.hasMoreElements()) 
		{ 
			try
			{ 
				st = new StringTokenizer(br.readLine()); 
			} 
			catch (IOException  e) 
			{ 
				e.printStackTrace(); 
			} 
		} 
		return st.nextToken(); 
	} 

	int nextInt() 
	{ 
		return Integer.parseInt(next()); 
	} 

	long nextLong() 
	{ 
		return Long.parseLong(next()); 
	} 

	double nextDouble() 
	{ 
		return Double.parseDouble(next()); 
	} 

	String nextLine() 
	{ 
		String str = ""; 
		try
		{ 
			str = br.readLine(); 
		} 
		catch (IOException e) 
		{ 
			e.printStackTrace(); 
		} 
		return str; 
	} 
}
