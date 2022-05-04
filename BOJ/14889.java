package practice;

import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static int N, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		arr = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);

		System.out.println(min);
	}

	static void dfs(int cnt, int idx) {
		if (cnt == N / 2) {
			differ();
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(cnt + 1, i + 1);
				visited[i] = false;
			}
		}
	}

	static void differ() {
		int start = 0;
		int link = 0;

		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (i != j) {
					if (visited[i] && visited[j]) {
						start += arr[i][j] + arr[j][i];
					} else if (!visited[i] && !visited[j]) {
						link += arr[i][j] + arr[j][i];
					}
				}
			}
		}

		min = Math.min(min, Math.abs(start - link));
	}
}
