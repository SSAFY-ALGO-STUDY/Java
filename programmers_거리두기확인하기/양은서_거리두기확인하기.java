package Programmers;

import java.util.*; 
class Solution_거리두기확인하기 {
    static char [][] map ; 
    public int[] solution(String[][] places) {
        int[] answer = new int [places.length];
        Arrays.fill(answer,1);
        for(int i = 0 ; i < places.length; i ++){
            String [] p = places[i]; 
            map = new char[5][5];
            for(int j = 0 ; j < 5; j ++){
                map[j] = p[j].toCharArray(); 
            }
            for(int r = 0 ; r < 5; r ++){
                for(int c = 0 ; c < 5; c ++){
                    if(map[r][c] == 'P') 
                        if(!search(r,c)){
                            answer[i] = 0;
                            break;
                        }
                }
            }
        }        
        return answer;
    }
    static int [] dx = {1,-1,0,0}; 
    static int [] dy = {0,0,1,-1};
    static int [] dx2 = {1,1,-1,-1};
    static int [] dy2= {1,-1,1,-1};
    public boolean search(int x, int y){
        for(int i = 0 ; i < dx.length; i ++){
            int nx = x + dx[i]; 
            int ny = y + dy[i]; 
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue; 
            if (map[nx][ny] == 'P') {
                return false;
            }
        }
        for(int i = 0 ; i < dx.length; i ++){
            int nx = x + (dx[i] * 2); 
            int ny = y + (dy[i] * 2);
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue; 
            if (map[nx][ny] == 'P' && map[x+ dx[i]][y + dy[i]] != 'X') {
                return false; 
            }
        }
        for(int i = 0 ; i < dx2.length; i ++){
            int nx = x + dx2[i]; 
            int ny = y + dy2[i]; 
            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue; 
            if ( map[nx][ny] == 'P' && (map[x][ny] == 'O' || map[nx][y] == 'O')) {
                return false; 
            }
        }
        return true; 
        
    }
}