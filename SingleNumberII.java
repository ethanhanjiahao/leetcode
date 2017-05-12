package leetcode;
/**
 * 一个整型数组中，每一个元素都出现三次，只有一个元素出现一次，求这个出现一次的元素
 * @author HJH
 *
 */
public class SingleNumberII {

	  public int singleNumber(int[] A) {
	        int result=0;
	        for(int i=0;i<32;i++){
	        	int sum =0;
	        	for(int j=0;j<A.length;j++){
	        		sum+=(A[j]>>i)&1;
	        	}
	        	if(sum%3!=0){
	        		result = result|(1<<i);
	        	}
	        }
	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
