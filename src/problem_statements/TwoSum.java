package problem_statements;

import java.util.ArrayList;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int []nums1 = {2,7,11,15};
		int target1  = 9;
		int []nums2 = {3,2,4};
		int target2  = 6;
		int []nums3 = {3,3};
		int target3  = 6;
		int []arr = twoSum(nums1, target1);
		for(int i = 0;i<arr.length;i++)
			System.out.println("Target 1 Index are: " +arr[i]);
		arr = twoSum(nums2, target2);
		for(int i = 0;i<arr.length;i++)
			System.out.println("Target 2 Index are: " +arr[i]);
		arr = twoSum(nums3, target3);
		for(int i = 0;i<arr.length;i++)
			System.out.println("Target 3 Index are: " +arr[i]);
	}
	public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){ 
            map.put(nums[i],i);
    }
    for(int i = 0 ;i<nums.length;i++){
        int complement  = target - nums[i];
        if((map.containsKey(complement))&&(map.get(complement)!=i))
            return new int[] {i,map.get(complement)};
    }
    return null;
    }

}
