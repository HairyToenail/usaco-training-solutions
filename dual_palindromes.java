/*
ID: wings201
LANG: JAVA
TASK: dualpal
 */
import java.util.*;
import java.io.*;
public class dualpal {
	public static ArrayList<String> base(int n) {
		ArrayList<String> nums = new ArrayList<String>();
		for(int i =2;i<=10;i++) {
			String d = "";
			for(int p = n;p>0;p/=i) {
				d += (p%i);
			}
			nums.add(d);
		}
		return nums;
	}
	public static boolean palindrome(ArrayList<String> arr) {
		int n = 0;
		for(int i = 0;i<arr.size();i++) {
			if(arr.get(i).length()==1) {
				n++;
			}else {
				boolean pal = true;
				for(int p = 0;p<arr.get(i).length()/2;p++) {
					if(arr.get(i).charAt(p)!=arr.get(i).charAt(arr.get(i).length()-p-1)) {
						pal = false;
						break;
					}
				}
				if (pal) n++;
			}
		}
		if(n>=2) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		StringTokenizer st = new StringTokenizer(f.readLine());
		int S = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int i = 0;
		ArrayList<Integer> d = new ArrayList<Integer>();
		while(i<S) {
			N++;
			if(palindrome(base(N))) {
				i++;
				d.add(N);
			}

		}

		for(int c = 0;c<d.size();c++) {
			out.println(d.get(c));
		}
		
		out.close();
		f.close();
	}
}
