/*
ID: wings201
LANG: JAVA
TASK: namenum
 */
import java.util.*;
import java.io.*;

public class namenum {
	public static void main(String args[]) throws Exception {
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		BufferedReader d = new BufferedReader(new FileReader("dict.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
		//int N = Integer.parseInt(f.readLine());
		String nums = f.readLine();
		ArrayList<String> arr = new ArrayList<String>();
		String stri = null;
		boolean b = false;
		while((stri = d.readLine()) != null) {
			arr.add(stri);
		}
		d.close();
		int [] alphabet = new int[128];
		alphabet['A'] = alphabet['B'] = alphabet['C'] = 2;
		alphabet['D'] = alphabet['E'] = alphabet['F'] = 3;
		alphabet['G'] = alphabet['H'] = alphabet['I'] = 4;
		alphabet['J'] = alphabet['K'] = alphabet['L'] = 5;
		alphabet['M'] = alphabet['N'] = alphabet['O'] = 6;
		alphabet['P'] = alphabet['R'] = alphabet['S'] = 7;
		alphabet['T'] = alphabet['U'] = alphabet['V'] = 8;
		alphabet['W'] = alphabet['X'] = alphabet['Y'] = 9;
		for(String s : arr) {
			if(s.length()!=nums.length()) {
				continue;
			}
			String variable = "";
			for(int i =0;i<s.length();i++) {
				variable += alphabet[s.charAt(i)];
			}
			if(variable.equals(nums)) {
				out.println(s);
				b = true;
			}
		}
		if(!b) {
			out.println("NONE");
		}
		f.close();
		out.close();
	}
}
