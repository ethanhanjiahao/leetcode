package leetcode;

import java.util.HashMap;

/**
 * �������������е������������Ԫ�أ�Ҫ��ʱ�临�Ӷ�ΪO��n��
 * 	Given[100, 4, 200, 1, 3, 2],
	The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 * @author HJH
 * �������������־���ʱ�临�Ӷ�Ҫ����������������ʱ��ֻ�����ӿռ临�Ӷȣ���hashmap��hashset�������
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
			//������
			while(hashMap.containsKey(index) && hashMap.get(index)!=-1){
				hashMap.put(index, -1);
				length++;
				index++;
			}
			maxLength = Math.max(maxLength, length);
			//��ǰ����
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
