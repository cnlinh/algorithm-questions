import java.io.*;
import java.util.*;

class KattisLadice {
	public static void main(String[] args) {
		FastIO fio = new FastIO();
		int item = fio.nextInt();
		int drawer = fio.nextInt();
		
		UnionFind uf = new UnionFind(300005);
		for (int i = 0; i < item; i++) {
			int first = fio.nextInt();
			int second = fio.nextInt();
			uf.unionSet(first, second);
			if (uf.used(first)) fio.println("LADICA");
			else fio.println("SMECE");
		}

		fio.close();
	}
}

class UnionFind {                                              
	public int[] p;
	public int[] rank;
	public int numSets;
	public int[] size;
	public int[] usage;

	public UnionFind(int N) {
		p = new int[N];
		rank = new int[N];
		size = new int[N];
		usage = new int[N];
		numSets = N;
		for (int i = 0; i < N; i++) {
			p[i] = i;
			usage[i] = 0;
			size[i] = 1;
			rank[i] = 0;
		}
	}

	public int findSet(int i) { 
		if (p[i] == i) return i;
		else {
			p[i] = findSet(p[i]);
			return p[i]; 
		} 
	}

	public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

	public void unionSet(int i, int j) { 
		if (!isSameSet(i, j)) { 
			numSets--; 
			int x = findSet(i), y = findSet(j);
			// rank is used to keep the tree short
			if (rank[x] > rank[y]) {
				p[y] = x;
				usage[x] += usage[y];
				size[x] += size[y];
			}
			else { 
				p[x] = y;
				usage[y] += usage[x];
				size[y] += size[x];
				if (rank[x] == rank[y]) rank[y] = rank[y] + 1; 
			} 
		} 
	}
	
	boolean used(int i) {
		int j = findSet(i);
		usage[j]++;
		if (usage[j] <= size[j]) return true;
		else {
			usage[j]--;
			return false;
		}
	}

	public int numDisjointSets() { return numSets; }
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


