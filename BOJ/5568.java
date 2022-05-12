package practice;

import java.util.*;
import java.io.*;

public class Main {
	static int n, k;
	static int[] card;
	static boolean[] visited;
	static HashSet<String> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine()); // 카드 매수
		k = Integer.parseInt(br.readLine()); // 선택 카드 수

		card = new int[n];
		visited = new boolean[n];
		set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(br.readLine());
		}

		dfs(0, "");

		System.out.println(set.size());
	}

	static void dfs(int cnt, String str) {
		if (cnt == k) {
			set.add(str);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(cnt + 1, str + card[i]);
				visited[i] = false;
			}
		}
	}
}
