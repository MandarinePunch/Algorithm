package practice;

import java.util.*;
import java.io.*;

public class Main {
	static int[][] arr;
	static boolean[][] visited;
	static int size;
	static int width = 0;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		size = Integer.parseInt(br.readLine());
		arr = new int[size][size];
		visited = new boolean[size][size];

		for (int i = 0; i < size; i++) {
			String str = br.readLine();
			for (int j = 0; j < size; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					dfs(i, j);
					list.add(width);
					width = 0;
				}
			}
		}

		Collections.sort(list);

		System.out.println(list.size());
		for (int ans : list) {
			System.out.println(ans);
		}
	}

	public static void dfs(int x, int y) {

		width++;

		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;

			if ((0 <= nx && nx < size) && (0 <= ny && ny < size)) {
				if (!visited[nx][ny] && arr[nx][ny] == 1) {
					visited[nx][ny] = true;
					dfs(nx, ny);
				}
			}
		}
	}
}
