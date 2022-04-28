package practice;

import java.util.*;
import java.io.*;

public class Main {
	static int[] beads;
	static int N, M;
	static int lower = 0, upper = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 구슬 수
		M = Integer.parseInt(st.nextToken()); // 그룹 수

		beads = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			beads[i] = Integer.parseInt(st.nextToken());
			lower = Math.max(lower, beads[i]);
			upper += beads[i];
		}

		binarySearch();
		System.out.println(lower);

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += beads[i];
			if (sum > lower) {
				M--;
				sum = beads[i];
				sb.append(cnt).append(" ");
				cnt = 1;
			} else {
				cnt++;
			}
			
			if(M == N - i) break;
		}

		while(M-- > 0) {
			sb.append(cnt).append(" ");
			cnt = 1;
		}
		
		System.out.println(sb);
	}
	
	static void binarySearch() {
		int mid = 0;
		
		while (upper >= lower) {
			mid = (upper + lower) / 2;
			int cnt = cntBeadsBundle(mid);

			if (cnt > M) {
				lower = mid + 1;
			} else {
				upper = mid - 1;
			}
		}
	}

	static int cntBeadsBundle(int mid) {
		int sum = 0;
		int cnt = 1;

		for (int i = 0; i < N; i++) {
			sum += beads[i];
			if (sum > mid) {
				cnt++;
				sum = beads[i];
			}
		}

		return cnt;
	}
}
