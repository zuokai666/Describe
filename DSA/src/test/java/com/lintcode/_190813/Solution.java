package com.lintcode._190813;

public class Solution {
	
	public static void main(String[] args) {
		String[] maze = {".....",
						 ".S...",
						 ".....",
						 "****.",
						 "T...."};
		System.err.println(new Solution().findHer(maze));
	}
	
	public boolean findHer(String[] maze) {
		for(int i=0;i<maze.length;i++){
			for(int j=0;j<maze[i].length();j++){
				char a = maze[i].charAt(j);
				if(a == 'S'){//牛郎
					char[][] chars = new char[maze.length][maze[i].length()];
					for(int x=0;x<maze.length;x++){
						chars[x] = maze[x].toCharArray();
					}
					chars[i][j] = '.';
					return findT(i, j, maze.length, maze[i].length(), chars);
				}
			}
		}
		return false;
    }
	
	private boolean findT(int i, int j, int n, int m, char[][] maze){
		if(i < 0 || n <= i){
			return false;
		}
		if(j < 0 || m <= j){
			return false;
		}
		if(maze[i][j] == '*' || maze[i][j] == 'S'){
			return false;
		}else if(maze[i][j] == '.'){
			maze[i][j] = 'S';
//			for(char[] _chars : maze){
//				System.err.println(Arrays.toString(_chars));
//			}
//			System.err.println("--------------------");
		}else if(maze[i][j] == 'T'){
			return true;
		}
		//上
		boolean s = findT(i - 1, j, n, m, maze);
		//右
		boolean y = findT(i, j + 1, n, m, maze);
		//下
		boolean x = findT(i + 1, j, n, m, maze);
		//左
		boolean z = findT(i, j - 1, n, m, maze);
		return s || x || z || y;
	}
}