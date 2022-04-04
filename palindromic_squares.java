/*
ID: wings201
LANG: JAVA
TASK: palsquare
 */

import java.util.*;
import java.io.*;
public class palsquare {
	public static ArrayList<Character> base(int base, int num) {
		String map = "0123456789ABCDEFGHIJ";
		ArrayList<Character> n = new ArrayList<Character>();
			for(int i = num;i>0;i/=base) {
				n.add(map.charAt(i%base));
			}
		return n;
	}
	public static boolean palindrome(ArrayList<Character> n) {
		for(int i = 0;i<n.size()/2;i++) {
			if(n.get(i)!=n.get(n.size()-i-1)) {
				return false;
			}
		}
		return true;
	}
	public static String toString(ArrayList<Character> n) {
		String str = "";
		for(int i = 0;i<n.size();i++) {
			str += n.get(n.size()-i-1);
		}
		return str;
	}
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
		int N = Integer.parseInt(f.readLine());
		for(int i = 1;i<=300;i++) {
			if(palindrome(base(N, i*i))) {
//				System.out.print(i + " " + i*i);
				out.print(toString(base(N, i)) + " " + toString(base(N, i*i)));
				out.println();
			}
		}
		f.close();
		out.close();
	}
}
