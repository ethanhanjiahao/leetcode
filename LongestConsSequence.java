package leetcode;

import java.util.HashMap;

/**
 * 返回无序数组中的最长的连续递增元素，要求时间复杂度为O（n）
 * 	Given[100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 * @author HJH
 * 遇到不能排序，又具有时间复杂度要求的问题的有序问题时候，只能增加空间复杂度，用hashmap或hashset解决问题
 *
 */
public class LongestConsSequence {
	public int longestConsecutive(int[] num) {
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int i:num){
			hashMap.put(i, 1);
		}
		int maxLength = 0;
		for(int i:num){
			int index = i;
			int length = 0;
			//向后遍历
			while(hashMap.containsKey(index) && hashMap.get(index)!=-1){
				hashMap.put(index, -1);
				length++;
				index++;
			}
			maxLength = Math.max(maxLength, length);
			//向前遍历
			index = i-1;
			while(hashMap.containsKey(index) && hashMap.get(index)!=-1){
				hashMap.put(index, -1);
				length++;
				index--;
			}
			maxLength = Math.max(maxLength, length);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {100, 4, 200, 1, 3, 2};
		System.out.println(new LongestConsSequence().longestConsecutive(num));
	}

}
