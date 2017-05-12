package leetcode;
/**
 * 给定两个字符串和一个字典，返回从开始字符至结束字符经过的字典的最小长度
 * 	BFS广度优先搜索解决实际问题，获取字典的最小长度
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
	
	//返回变换最小的序列长度
	public int solve(Set<String> start,String end,HashSet<String> dict,int step){
		if (start.isEmpty()) {
			return 0;
		}
		Set<String> next = new HashSet<String>();	//定义广度优先搜索的下一跳 BFS
		for(String s:start){
			if (isOneDiff(s, end)) {
				return step+1;
			}
			for(Iterator<String>it=dict.iterator();it.hasNext();){
				String str = it.next();	//获取字典中的单词
				if (isOneDiff(s, str)) {
					next.add(str);
					it.remove(); 	//移除掉字典中的下一跳的BFS
				}
			}
		}
		return solve(next, end, dict, step+1);
	}
	
	//非递归实现
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
					String str = it.next();	//获取字典中的单词
					if (isOneDiff(s, str)) {
						queue.offer(str);
						it.remove(); 	//移除掉字典中的下一跳的BFS
					}
				}
			}
			res++;
		}
		return 0;
	}

	// str1和str2中只有一个字母不相同
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
