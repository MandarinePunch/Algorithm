package practice;

import java.util.*;
import java.io.*;

public class Main {
	static int[][] flavor;
	static int min = Integer.MAX_VALUE;
	static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		flavor = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			flavor[i][0] = Integer.parseInt(st.nextToken()); // 신맛 (곱)
			flavor[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛 (합)
		}
		
		dfs(0,1,0);
		
		System.out.println(min);
	}
	
	static void dfs(int cnt, int sour, int bitter) {
		if(cnt == N) {
			if(bitter != 0) {
				min = Math.min(min, Math.abs(sour - bitter));
			}
			
			return;
		}
		
		dfs(cnt + 1, sour, bitter);
		dfs(cnt + 1, sour * flavor[cnt][0], bitter + flavor[cnt][1]);
	}
}
