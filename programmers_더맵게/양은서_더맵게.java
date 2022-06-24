package Programmers;

import java.util.*;
class Solution_더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue <Integer> pq = new PriorityQueue<>(); 
        for(int i = 0 ; i < scoville.length; i ++){
            pq.add(scoville[i]); 
        }
        
        while ( pq.size() > 0 && pq.peek() < K){
            if (pq.size() == 1 && pq.peek() < K ) {
                answer = -1; 
                break; 
            } 
            int n1 = pq.poll(); 
            int n2= pq.poll(); 
            pq.add(n1 + (n2*2)); 
            answer ++; 
        }
        return answer;
    }
}