package leetcode;
/**
 * һ�����������У�ÿһ��Ԫ�ض��������Σ�ֻ��һ��Ԫ�س���һ�Σ����������һ�ε�Ԫ��
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
