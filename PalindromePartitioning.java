package leetcode;

import java.util.ArrayList;

/**
 * 将字符串分割为回文串组，输出多个回文串组，以list形式输出
 * 例如 aab
 * 输出
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
	
	//判断是否是回文串
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
	
	//递归得到resut结果
	public static void getResult(ArrayList<ArrayList<String>> result,ArrayList<String> list,String str){
		//当str的长度为0时，list满足要求，加入结果集
		if (str.length()==0) {
			result.add(new ArrayList<String>(list));
		}
		int len = str.length();
		//依次判断是否是回文串，不是的话，增加步长判断是否为回文串
		//递归实现
		for(int i=1;i<=len;i++){
			String subStr = str.substring(0,i);
			if (isPalindrime(subStr)) {
				list.add(subStr);
				String tmpStr = str.substring(i);
				getResult(result, list, tmpStr);	//递归调用
				list.remove(list.size()-1);	//移除list中元素
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(partition("aab"));
	}

}
