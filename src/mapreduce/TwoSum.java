package mapreduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Alan Lau
 * @Date 2020-01-14
 */
public class TwoSum {

    public static void main(String[] args) {

        int[] sums = { 2, 7, 11, 15 };
        int[] result = twoSum2(sums, 9);

        System.out.println(String.format("[%s,%s]", result[0], result[1]));
    }

    public static int[] twoSum(int[] nums, int target) {

        List list = Arrays.stream(nums).mapToObj(Integer::valueOf).collect(Collectors.toList());
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            int b = target - a;
            if (list.contains(b)) {
                int index = list.indexOf(b);
                if (i == index) {
                    continue;
                }
                result.add(i);
                result.add(index);
            }
        }

        return result.stream().mapToInt(Integer::valueOf).toArray();
    }

    //map中存值 key: index, value: value
    public static int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum2(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(target - nums[i])) {
                return new int[] { list.indexOf(target - nums[i]) - 1, i };
            }

            list.add(nums[i]);
        }

        throw new IllegalArgumentException("No solution.");
    }
}
