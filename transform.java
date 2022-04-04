/*
ID: wings201
LANG: JAVA
TASK: transform
 */
import java.util.*;
import java.io.*;
public class transform {
	public static boolean equals(char[][] first, char[][] second) {
		for(int i = 0;i<first.length;i++) {
			for(int j = 0;j<first[i].length; j++) {
				if(first[i][j]!=second[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	public static char[][] rotate(char[][] arr) {
		char[][] second = new char[arr.length][arr[0].length];
		for(int i = 0;i<arr.length;i++) {
			for(int p = 0;p<arr[0].length;p++) {
				second[p][arr.length-1-i] = arr[i][p];
			}
		}
		return second;
	}
	public static void test(char[][] first) {
		for(int i = 0;i<first.length;i++) {
			for(int p = 0;p<first[0].length;p++) {
				System.out.print(first[i][p] + " ");
			}
			System.out.println();
		}
	}
	public static char[][] reflect(char[][] arr) {
		char[][] ar2 = new char[arr.length][arr[0].length];
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j<arr[0].length;j++) {
				ar2[i][arr.length-1-j] = arr[i][j];
			}
		}
		return ar2;
	}
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		int N = Integer.parseInt(f.readLine());
		char [][] arr = new char[N][N];
		for(int i = 0;i<N;i++) {
			String line = f.readLine();
			for(int j = 0;j<N;j++) {
				arr[i][j] = line.charAt(j);
			}
		}
		char [][] next = new char[N][N];
		for(int i = 0;i<N;i++) {
			String line = f.readLine();
			for(int j = 0;j<N;j++) {
				next[i][j] = line.charAt(j);
			}
		}
		char[][] second = rotate(arr);
		char[][] third = rotate(second);
		char[][] fourth = rotate(third);
		char[][] ref = reflect(arr);
		if(equals(next, second)) {
			out.print(1);
		}
		else if(equals(next, third)) {
			out.print(2);
		}
		else if(equals(next, fourth)) {
			out.print(3);
		}
		else if(equals(next, ref)) {
			out.print(4);
		}
		else if(equals(next, rotate(ref)) || equals(next, rotate(rotate(ref))) || equals(next, rotate(rotate(rotate(ref))))) {
			out.print(5);
		}
		else if(equals(arr, next)) {
			out.print(6);
		}else {
			out.print(7);
		}
		out.println();
		out.close();
		f.close();
	}
}
