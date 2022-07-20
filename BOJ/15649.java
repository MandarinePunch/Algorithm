package practice;

import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 1~N개의 자연수
		M = Integer.parseInt(st.nextToken()); // 중복 없이 M개를 골라라

		arr = new int[M];
		visited = new boolean[N];

		dfs(0);
		
		System.out.println(sb);
	}

	public static void dfs(int depth) {
		if (depth == M) {
			for(int num : arr) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
			
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i + 1;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}
}














