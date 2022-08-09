package practice;

import java.util.*;

public class DividePowerGrid {
	class Solution {
	    // 1. 사용하기 편하게 행렬 재구성
	    // 2. bfs로 간선이 끊어졌을 때, 송전탑 개수 차이 가져오기
	    int[][] arr;
	    
	    public int solution(int n, int[][] wires) {
	        int answer = 100;
	        
	        arr = new int[n + 1][n + 1];
	        
	        for(int[] wire : wires){
	            arr[wire[0]][wire[1]] = 1;
	            arr[wire[1]][wire[0]] = 1;
	        }
	        
	        for(int[] wire : wires){
	            int i = wire[0];
	            int j = wire[1];
	            
	            arr[i][j] = 0;
	            arr[j][i] = 0;
	            
	            answer = Math.min(answer, bfs(n, i));
	            
	            arr[i][j] = 1;
	            arr[j][i] = 1;
	        }
	        
	        return answer;
	    }
	    
	    public int bfs(int n, int start){
	        Queue<Integer> q = new LinkedList<>();
	        boolean[] visited = new boolean[n + 1];
	        int count = 1;
	        
	        q.offer(start);
	        
	        while(!q.isEmpty()){
	            int node = q.poll();
	            visited[node] = true;
	            
	            for(int i = 1; i < n + 1; i++){
	                if(!visited[i] && arr[node][i] == 1){
	                    q.offer(i);
	                    count++;
	                }
	            }
	        }
	        
	        return Math.abs(2 * count - n);
	    }
	}
}
