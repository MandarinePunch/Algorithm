package practice;

import java.util.*;
import java.io.*;

public class Main {
	static int[] arr;
	static int[] newArr;
	static boolean[] visited;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		newArr = new int[N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0);

		System.out.println(max);
	}

	static void dfs(int cnt) {
		if (cnt == arr.length) {
			max = Math.max(max, randSum());
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				newArr[cnt] = arr[i];
				dfs(cnt + 1);
				visited[i] = false;
			}
		}
	}

	static int randSum() {
		int sum = 0;

		for (int i = 1; i < arr.length; i++) {
			sum += Math.abs(newArr[i] - newArr[i-1]);
		}

		return sum;
	}
}


















