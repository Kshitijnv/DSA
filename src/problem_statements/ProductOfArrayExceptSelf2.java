package problem_statements;

import java.util.Arrays;

public class ProductOfArrayExceptSelf2 {
//WITHOUT DIVISION OPERATOR
	public static void main(String[] args) {
		int nums[] = {1,2,3,4};
//		int nums[] = {-1,1,0,3,-3};
		 int prefix = 1;
	        int suffix = 1;
	        int result[] = new int[nums.length];
	        for(int i = 0;i<nums.length;i++){
	            result[i] = prefix;
	            prefix = prefix * nums[i];
	        }
	        for(int i = nums.length-1;i>=0;i--){
	            result[i] = result[i] * suffix;
	            suffix = suffix * nums[i];
	        }
	System.out.println(Arrays.toString(result));
	}

}
