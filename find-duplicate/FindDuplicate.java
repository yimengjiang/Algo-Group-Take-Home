import java.util.*;

public class FindDuplicate {
    /*
     * Performance: 
     * Method1 is more efficient in time but requires additional space.
     * Method2 uses less space (if sorted in place), but requires more time.
     */

    // Method 1: find the duplicate using HashSet
    // Time complexity: O(n), space complexity: O(n)
    public static int findDuplicateUsingSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }

        return -1;
    }

    // Method 2: First sort the array then check the duplicate.
    // Time: O(nlogn), space: O(1)/O(n) depending on the sorting algorithm.
    public static int findDuplicateBySorting(int[] nums) {
        Arrays.sort(nums); //O(nlogn)
        for (int i = 0; i < nums.length; i++) { //O(n)
            if (nums[i] - i != 1) {
                return nums[i];
            }
        }

        return -1;
    }

    // Test the implementation
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 4, 2, 5, 3};
        System.out.println("Method 1 Duplicate: " + findDuplicateUsingSet(nums1)); //expected: 3
        System.out.println("Method 2 Duplicate: " + findDuplicateBySorting(nums1)); //expected: 3

        int[] nums2 = {5, 2, 3, 1, 4, 4, 6};
        System.out.println("Method 1 Duplicate: " + findDuplicateUsingSet(nums2)); //expected: 4
        System.out.println("Method 2 Duplicate: " + findDuplicateBySorting(nums2)); //expected: 4

        int[] nums3 = {1};
        System.out.println("Method 1 Duplicate: " + findDuplicateUsingSet(nums3)); //expected: -1
        System.out.println("Method 2 Duplicate: " + findDuplicateBySorting(nums3)); //expected: -1
    }
}