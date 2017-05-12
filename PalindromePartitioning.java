package leetcode;

import java.util.ArrayList;

/**
 * ���ַ����ָ�Ϊ���Ĵ��飬���������Ĵ��飬��list��ʽ���
 * ���� aab
 * ���
 *  [
	    ["aa","b"],
	    ["a","a","b"]
    ]
 * @author HJH
 *
 */
public class PalindromePartitioning {

	public static ArrayList<ArrayList<String>> partition(String s){
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		ArrayList<String> list = new ArrayList<>();
		getResult(result,list,s);
		return result;
	}
	
	//�ж��Ƿ��ǻ��Ĵ�
	public static boolean isPalindrime(String s){
		int i = 0;
		int j = s.length()-1;
		while(i<j){
			if (s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	//�ݹ�õ�resut���
	public static void getResult(ArrayList<ArrayList<String>> result,ArrayList<String> list,String str){
		//��str�ĳ���Ϊ0ʱ��list����Ҫ�󣬼�������
		if (str.length()==0) {
			result.add(new ArrayList<String>(list));
		}
		int len = str.length();
		//�����ж��Ƿ��ǻ��Ĵ������ǵĻ������Ӳ����ж��Ƿ�Ϊ���Ĵ�
		//�ݹ�ʵ��
		for(int i=1;i<=len;i++){
			String subStr = str.substring(0,i);
			if (isPalindrime(subStr)) {
				list.add(subStr);
				String tmpStr = str.substring(i);
				getResult(result, list, tmpStr);	//�ݹ����
				list.remove(list.size()-1);	//�Ƴ�list��Ԫ��
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partition("aab"));
	}

}
