package leetcode;
/**
 * ���������ַ�����һ���ֵ䣬���شӿ�ʼ�ַ��������ַ��������ֵ����С����
 * 	BFS��������������ʵ�����⣬��ȡ�ֵ����С����
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class WordLadder {

	public int ladderLength(String start, String end, HashSet<String> dict) {
		Set<String> startSet= new HashSet<>();
		startSet.add(start);
		//return solve(startSet, end, dict, 1);
		return solveNoRes(start, end, dict);
	}
	
	//���ر任��С�����г���
	public int solve(Set<String> start,String end,HashSet<String> dict,int step){
		if (start.isEmpty()) {
			return 0;
		}
		Set<String> next = new HashSet<String>();	//������������������һ�� BFS
		for(String s:start){
			if (isOneDiff(s, end)) {
				return step+1;
			}
			for(Iterator<String>it=dict.iterator();it.hasNext();){
				String str = it.next();	//��ȡ�ֵ��еĵ���
				if (isOneDiff(s, str)) {
					next.add(str);
					it.remove(); 	//�Ƴ����ֵ��е���һ����BFS
				}
			}
		}
		return solve(next, end, dict, step+1);
	}
	
	//�ǵݹ�ʵ��
	public int solveNoRes(String start,String end,HashSet<String> dict){
		int res = 1;
		LinkedList<String> queue = new LinkedList<>();
		queue.offer(start);
		while(!queue.isEmpty()){
			int size = queue.size();
			while(size>0){
				String s = queue.poll();
				size--;
				if (isOneDiff(s, end)) {
					return res+1;
				}
				for(Iterator<String> it=dict.iterator();it.hasNext();){
					String str = it.next();	//��ȡ�ֵ��еĵ���
					if (isOneDiff(s, str)) {
						queue.offer(str);
						it.remove(); 	//�Ƴ����ֵ��е���һ����BFS
					}
				}
			}
			res++;
		}
		return 0;
	}

	// str1��str2��ֻ��һ����ĸ����ͬ
	public boolean isOneDiff(String str1, String str2) {
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				count++;
			}
		}
		return count == 1 ? true : false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		System.out.println(new WordLadder().ladderLength("hit", "cog", set));
	}

}
