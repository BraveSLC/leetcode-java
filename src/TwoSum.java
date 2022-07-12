import java.util.HashMap;
import java.util.Map;

/**
 * @author slc
 */
public class TwoSum {

  /**
   * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
   *
   * You may assume that each input would have exactly one solution, and you may not use the same element twice.
   *
   * You can return the answer in any order.
   *
   * 来源：力扣（LeetCode）
   * 链接：https://leetcode.cn/problems/two-sum
   * @return
   */

  /**
   * 暴力遍历 注意后面的不需要和前面的匹配
   * 时间复杂度：o(n^2)
   * 空间复杂度：o(1)
   * @param nums
   * @param target
   * @return
   */
  public int[] solution1(int[] nums, int target) {
    int length = nums.length;
    for (int i = 0; i < length; i++) {
      // 注意 这里j初始值是 i + 1, 不然就是自己和自己加
      for (int j = i + 1; j < length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[0];
  }

  /**
   * 通过hashMap中的containsKey()来判断是否存在这样的数
   * 时间复杂度：o(n)
   * 空间复杂度：o(n)
   * @param nums
   * @param target
   * @return
   */
  public int[] solution2(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>(10);
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(target - nums[i])) {
        return new int[]{map.get(target - nums[i]), i};
      }
      map.put(nums[i], i);
    }
    return new int[0];
  }

}
