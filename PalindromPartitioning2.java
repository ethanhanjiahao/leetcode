package leetcode;

/**
 * 给定一个字符串，返回最小的切割次数，使得每个子字符串是回文字符串
 * @author HJH
解题思路：动态规划问题。
  dp[i] - 表示子串（0，i）的最小回文切割，则最优解在dp[s.length-1]中。：
  1.初始化：当字串s.substring(0,i+1)(包括i位置的字符)是回文时，dp[i] = 0(表示不需要分割)；否则，dp[i] = i（表示至多分割i次）;
  2.对于任意大于1的i，如果s.substring(j,i+1)(j<=i,即遍历i之前的每个子串)是回文时，dp[i] = min(dp[i], dp[j-1]+1);
  3.如果s.substring(j,i+1)(j<=i)不是回文时，dp[i] = min(dp[i],dp[j-1]+i+1-j);
 *
 */
public class PalindromPartitioning2 {
	
	public int minCut(String s){
		int[] dp = new int[s.length()];	//dp[i]表示subString(0,i+1)即为(0-i)的最小回文切割数目
		for(int i=0;i<s.length();i++){
			dp[i] = isPalindrom(s.substring(0,i+1)) ? 0:i;
			if (dp[i] == 0) {	//为回文串时候，继续进行循环，依次进行判断之后的子字符串是否是回文串
				continue;
			}
			//动态规划，求解dp
			for(int j=1;j<=i;j++){
				if (isPalindrom(s.substring(j,i+1))) {	//从j-i的子字符串是回文的话
					dp[i] = Math.min(dp[i], dp[j-1]+1);
				}
				else {
					dp[i] = Math.min(dp[i], dp[j-1]+i-j+1);
				}
			}
		}
		return dp[s.length()-1];
	}
	
	//判断是否是回文字符串
	public boolean isPalindrom(String s){
		int i=0,j=s.length()-1;
		while(i<=j){
			if (s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new PalindromPartitioning2().minCut("aab"));
	}

}
