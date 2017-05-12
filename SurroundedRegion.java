package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ����ά���������б���Χ��O�滻ΪX
 * @author HJH
 * ����������� BFS�������
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
	
	//�û���ά�����е�OΪX
	public void solve(char[][] board){
		Queue<Pair> queue = new LinkedList<>();	//��¼���в���Ҫ�滻��O
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				//���ܱ�Ե��O����Ҫ�滻ΪX
				if (i==0||i==board.length-1||j==0||j==board[0].length-1) {
					if (board[i][j]=='O') {
						queue.add(new Pair(i, j));
					}
				}
			}
		}
		//���ն��������ȳ����ص㣬�����жϣ�����ֱ�����ڵ�O�Ƿ���Ҫ�滻
		int x1,y1;
		//BFS�����ж�
		while(!queue.isEmpty()){	//ѭ����������
			Pair position = queue.poll();
			x1 = position.x;
			y1 = position.y;
			if (board[x1][y1]=='Y') {
				continue;
			}
			
			board[x1][y1] = 'Y';	//������Ҫ�滻��O��ʱ�滻ΪY��Ϊ֮�������Ҫ�����滻������
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
		//��board��ά�����е�����Y�滻ΪO������O�滻ΪX
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
