import java.io.*;
import java.util.*;

class KattisTrainPassengers {
	public static void main(String[] args) {
		FastIO fio = new FastIO();
		boolean possible = true;
		int capacity = fio.nextInt();
		int noOfStation = fio.nextInt();
		int currentCapacity = 0;

		for (int i = 0; i < noOfStation; i++) {
			int left = fio.nextInt();
			int enter = fio.nextInt();
			int wait = fio.nextInt();

			currentCapacity = currentCapacity + enter - left;

			if (currentCapacity > capacity || currentCapacity < 0) {
				possible = false;
			}
			else if (currentCapacity < capacity && wait > 0) {
				possible = false;
			}
			else if (i == noOfStation - 1 && (wait > 0 || currentCapacity != 0 || enter > 0)) {
				possible = false;
			}
		}

		if (possible == true) {
			System.out.println("possible");
		}
		else {
			System.out.println("impossible");
		}

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

