/*
ID: wings201
LANG: JAVA
TASK: milk2
 */
import java.util.*;
import java.io.*;
public class milk2 {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		int N = Integer.parseInt(f.readLine());
		int [][] arr = new int[N][2];
		for(int i = 0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, (a, b) -> a[0]-b[0]);
		int start = arr[0][0];
		int end = arr[0][1];
		int milk = 0;
		int idle = 0;
		for(int i = 1;i<N;i++) {
			if(arr[i][0]>end) {
				if(arr[i][0]-end>idle) {
					idle = arr[i][0]-end;
				}
				if(milk<end-start) {
					milk = end-start;
				}
				end = arr[i][1];
				start = arr[i][0];
			}else {
				if(arr[i][1]>end) {
					end = arr[i][1];
				}
			}
		}
		if(end-start>milk) {
			milk = end-start;
		}
		out.println(milk + " " + idle);
		f.close();
		out.close();
	}
}
