package problem_statements;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
	//WITHOUT DIVISION OPERATOR
	public static void main(String[] args) {
		int count = 0;
		int multiple = 1;
//		int nums[] = {1,2,3,4};
		int nums[] = {-1,1,0,3,-3};
		int result[] = new int[nums.length];
		for(int i : nums) {
			if(i==0)
				count++;
			else
				multiple *= i;
		}
		if(count==0) {
			for(int i = 0;i<nums.length;i++) {
				result[i] = multiple/nums[i];
			}
		}
		else {
			for (int i = 0; i < nums.length ; i++) {
	               if (nums[i] == 0)
	                   result[i] = multiple;
			}
		}
	System.out.println(Arrays.toString(result));
	}

}
