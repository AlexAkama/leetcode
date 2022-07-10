package leetcode.solution.ready;

//
// Слияние двух отсортированных массивов (по-возрастанию)
// Возможны не уникальные значения
//
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
//Memory Usage: 42.9 MB, less than 48.19% of Java online submissions for Merge Sorted Array.
public class Solution0088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = nums1.length - 1;
        m--;
        n--;
        while (n > -1) {
            if (m > -1 && nums1[m] > nums2[n]) {
                nums1[pos--] = nums1[m--];
            } else {
                nums1[pos--] = nums2[n--];
            }
        }
    }

}
