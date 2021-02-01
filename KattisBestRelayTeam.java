import java.io.*;
import java.util.*;

class KattisBestRelayTeam {
	public static void main(String[] args) {
		FastIO fio = new FastIO();
		int count = fio.nextInt();
		String[] finalist = new String[4];
		Runner[] runner = new Runner[count];
		double totalTime = 1000.0;

		for (int i = 0; i < count; i++) {
			String name = fio.next();
			double first = fio.nextDouble();
			double last = fio.nextDouble();
			runner[i] = new Runner(name, first, last);
		}

		Arrays.sort(runner);

		for (int i = 0; i < count; i++) {
			double trialTime = runner[i].first;
			String[] trialList = new String[4];
			trialList[0] = runner[i].name;
			int index = 0;

			for (int j = 0; j < 4; j++) {
				if (index == 3) {
					break;
				}
				if (j != i) {
					trialList[index+1] = runner[j].name;
					trialTime += runner[j].last;
					index++;
				}
			}

			if (trialTime < totalTime - Math.pow(10, -9)) {
				totalTime = trialTime;
				finalist = trialList;
			}
		}
		System.out.println(totalTime);

        for (int i = 0; i < 4; i++) {
            System.out.println(finalist[i]);
        }
		fio.close();
	}
}

class Runner implements Comparable<Runner> {
	public String name;
	public double first;
	public double last;

	public Runner(String n, double f, double l) {
		name = n;
		first = f;
		last = l;
	}

	public int compareTo(Runner r) {
		if (this.last < r.last - Math.pow(10, -9)) {
			return -1;
		}
		else if (this.last > r.last + Math.pow(10, -9)) {
			return 1;
		}
		else {
			return 0;
		}
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

