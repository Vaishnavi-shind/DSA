import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    //DSA
    public List<List<Integer>> threeSum(int[] nums) {
        // 1. Sort the array
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        // Iterate through the array, fixing the first element (a)
        for (int i = 0; i < nums.length - 2; i++) {
            
            // Optimization: If the fixed number is positive, the sum cannot be 0
            if (nums[i] > 0) {
                break; 
            }
            
            // Skip duplicates for the first element (a)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // 2. Two Pointers for the remaining elements (b and c)
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i]; // We need b + c = -a
            
            while (left < right) {
                int currentSum = nums[left] + nums[right];
                
                if (currentSum == target) {
                    // Found a triplet!
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Move pointers and skip duplicates for the second and third elements
                    // Crucial step to avoid duplicate triplets
                    left++;
                    right--;
                    
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++; // Skip duplicates for the left pointer
                    }
                    
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--; // Skip duplicates for the right pointer
                    }
                } else if (currentSum < target) {
                    // Sum is too small, need a larger number, move left pointer right
                    left++;
                } else { // currentSum > target
                    // Sum is too large, need a smaller number, move right pointer left
                    right--;
                }
            }
        }
        
        return result;
    }
}