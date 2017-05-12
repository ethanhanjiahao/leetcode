package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将二维数组中所有被包围的O替换为X
 * @author HJH
 * 广度优先搜索 BFS解决问题
 */
public class SurroundedRegion {
	
	class Pair{
		int x;
		int y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
	//置换二维数组中的O为X
	public void solve(char[][] board){
		Queue<Pair> queue = new LinkedList<>();	//记录所有不需要替换的O
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				//四周边缘的O不需要替换为X
				if (i==0||i==board.length-1||j==0||j==board[0].length-1) {
					if (board[i][j]=='O') {
						queue.add(new Pair(i, j));
					}
				}
			}
		}
		//按照队列先入先出的特点，进行判断，与其直接相邻的O是否需要替换
		int x1,y1;
		//BFS进行判断
		while(!queue.isEmpty()){	//循环结束条件
			Pair position = queue.poll();
			x1 = position.x;
			y1 = position.y;
			if (board[x1][y1]=='Y') {
				continue;
			}
			
			board[x1][y1] = 'Y';	//将不需要替换的O暂时替换为Y，为之后程序需要进行替换做考虑
			//up
			int index = x1-1;
			if(index>=0 && board[index][y1]=='O'){
				queue.add(new Pair(index, y1));
			}
			//right
			index = y1+1;
			if (index<=board[0].length-1 && board[x1][index]=='O') {
				queue.add(new Pair(x1, index));
			}
			//down
			index = x1+1;
			if (index<=board.length-1 && board[index][y1]=='O') {
				queue.add(new Pair(index, y1));
			}
			//left
			index = y1-1;
			if (index>=0 && board[x1][index]=='O') {
				queue.add(new Pair(x1, index));
			}
		}
		//将board二维数组中的所有Y替换为O，所有O替换为X
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[i].length;j++){
				if (board[i][j]=='O') {
					board[i][j] = 'X';
				}else if (board[i][j]=='Y') {
					board[i][j]='O';
				}
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] a = {{'X','X','X','X'},
						{'X','O','O','X'},
						{'X','X','O','X'},
						{'X','O','X','X'}};
		new SurroundedRegion().solve(a);
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

}
