package com.lintcode._191024;

public class Solution {

	public boolean reachEndpoint(int[][] map) {
        try{
            internal(map, 0, 0);
            return false;
        }catch(Exception e){
            return true;
        }
    }
    
    private void internal(int[][] map, int i, int j) throws Exception{
        int m = map.length;
        int n = map[0].length;
        if(0 <= i && i < m && 0 <= j && j < n){
            if(map[i][j] == 1){
                map[i][j] = 2;//踏足
            }
            if(map[i][j] == 0 || map[i][j] == 2){
                return;
            }
            if(map[i][j] == 9){
                throw new Exception();
            }
            internal(map, i, j - 1);
            internal(map, i, j + 1);
            internal(map, i + 1, j);
            internal(map, i - 1, j);
        }
    }
}
