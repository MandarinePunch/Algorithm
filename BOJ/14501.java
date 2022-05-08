package practice;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		int[] dp = new int[N + 2];

		for (int i = 1; i < N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i]);

			if (i + T[i] < N + 2) {
				dp[i + T[i]] = Math.max(P[i] + dp[i], dp[i + T[i]]);
			}
		}

		System.out.println(Math.max(dp[N], dp[N + 1]));
	}
}
