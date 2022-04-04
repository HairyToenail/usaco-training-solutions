/*
ID: wings201
LANG: JAVA
TASK: beads
 */

import java.util.*;
import java.io.*;
public class beads {
	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
		int N =Integer.parseInt(f.readLine());
		String beads = f.readLine();
		int right, left;
		int ans = 0;
		for(int i = beads.length()-1;i>=0;i--) {
			int countR = 0;
			int countB = 0;
			for(int j = i;j<i+N;j++) {
				int k = j%N;
				if(beads.charAt(k)=='b' || beads.charAt(k)=='w') {
					countB++;
				}else {
					break;
				}
			}
			for(int j = i;j<i+N;j++) {
				int k = j%N;
				if(beads.charAt(k)=='r' || beads.charAt(k)=='w') {
					countR++;
				}else {
					break;
				}
			}
			right = Math.max(countR, countB);
			countR = 0;
			countB = 0;
			for(int j = i-1;j>i-N;j--) {
				int k = (j+N)%N;
				if(beads.charAt(k)=='b' || beads.charAt(k)=='w') {
					countB++;
				}else {
					break;
				}
			}
			
			for(int j = i-1;j>i-N;j--) {
				int k = (j+N)%N;
				if(beads.charAt(k)=='r' || beads.charAt(k)=='w') {
					countR++;
				}else {
					break;
				}
			}
			left = Math.max(countR, countB);
			ans = Math.max(ans, right+left);
		}
		if(ans > N) {
			ans = N;
		}
		out.println(ans);
		f.close();
		out.close();
	}
}
