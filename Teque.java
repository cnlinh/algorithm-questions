import java.util.*;
import java.io.*;

public class Teque<E> {
	HashMap<Integer, E> mapOne;
	HashMap<Integer, E> mapTwo;
	LinkedList<E> listOne;
	LinkedList<E> listTwo;
	int first;
	int last;
	int firstLast;
	int lastFirst;

	Teque() {
		mapOne = new HashMap<Integer, E>();
		mapTwo = new HashMap<Integer, E>();
		listOne = new LinkedList<E>();
		listTwo = new LinkedList<E>();
		first = 0;
		last = 0;
		firstLast = 0;
		lastFirst = 0;
	}

	public void push_back(E e) {
		listTwo.addLast(e);
		mapTwo.put(last, e);
		last++;

		balance();
	}

	public void push_front(E e) {
		listOne.addFirst(e);
		mapOne.put(-first, e);
		first++;

		balance();
	}

	public void push_middle(E e) {
		listTwo.addFirst(e);
		lastFirst++;
		mapTwo.put(-lastFirst, e);

		balance();
	}

	public E get(int i) {
		if (i < first + firstLast) {
			return mapOne.get(- first + 1 + i);
		}
		else {
			return mapTwo.get(- first - firstLast - lastFirst + i);
		}
	}

	public void balance() {
		if (last + lastFirst == first + firstLast + 1) {
			E e = listTwo.removeFirst();
			if (last + lastFirst == 1) {
				last = 0;
				lastFirst = 0;
				push_front(e);
			}
			else {
				lastFirst--;
				listOne.addLast(e);
				firstLast++;
				mapOne.put(firstLast, e);
			}
		}
		else if (first + firstLast == last + lastFirst + 2) {
			E e = listOne.removeLast();
			if (last + lastFirst == 0) {
				firstLast = 0;
				first = 1;
				mapOne.put(0, listOne.getFirst());
				push_back(e);
			}
			else {
				firstLast--;
				listTwo.addFirst(e);
				lastFirst++;
				mapTwo.put(-lastFirst, e);
			}
		}
		return;
	}

	public static void main(String[] args) {
		FastIO fio = new FastIO();
		int operNo = fio.nextInt();
		Teque<Integer> t = new Teque<Integer>();
		
		for (int i = 0; i < operNo; i++) {
			String s = fio.next();
			int num = fio.nextInt();
			if (s.equals("push_back")) {
				t.push_back(num);
			}
			else if (s.equals("push_front")) {
				t.push_front(num);
			}
			else if (s.equals("push_middle")) {
				t.push_middle(num);
			}
			else {
				fio.println(t.get(num));
			}
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
