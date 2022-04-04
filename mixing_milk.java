/*
ID: wings201
LANG: JAVA
TASK: barn1
 */
import java.util.*;
import java.io.*;
public class barn1 {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int [] arr = new int[C];
		for(int i = 0;i<C;i++) {
			arr[i] = Integer.parseInt(f.readLine());
		}
		Arrays.sort(arr);
		ArrayList<Integer> gap = new ArrayList<Integer>();
		for(int i = 0;i<C-1;i++) {
			gap.add(arr[i+1]-arr[i]);
		}
		Collections.sort(gap);
		int p = 0;
		for(int i = 0;i<C-M;i++) {
			p+=gap.get(i);
		}
		p += M;
		out.println(p);
		f.close();
		out.close();
	}
}
