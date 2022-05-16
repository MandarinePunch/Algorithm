package practice;

import java.util.*;
import java.io.*;

public class Main {
	static char[] alpha;
	static char[] password;
	static int L, C;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken()); // 패스위드 수
		C = Integer.parseInt(st.nextToken()); // 알파벳 수

		alpha = new char[C];
		password = new char[L];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alpha[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(alpha);

		dfs(0, 0);
		
		System.out.println(sb);
	}

	static void dfs(int start, int idx) {
		if (idx == L) {
			int vowel = 0; 		// 모음
			int consonant = 0; 	// 자음

			for (char c : password) {
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
					vowel++;
				} else {
					consonant++;
				}
			}
			
			if(vowel >= 1 && consonant >= 2) {
				sb.append(password).append("\n");
			}

			return;
		}

		for (int i = start; i < C; i++) {
			password[idx] = alpha[i];
			dfs(i + 1, idx + 1);
		}
	}
}
