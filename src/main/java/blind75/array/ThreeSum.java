
package blind75.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public class ThreeSum {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // Example 1:
    //
    //Input: nums = [-1,0,1,2,-1,-4]
    //Output: [[-1,-1,2],[-1,0,1]]
    //Explanation:
    //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
    //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
    //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
    //The distinct triplets are [-1,0,1] and [-1,-1,2].
    //Notice that the order of the output and the order of the triplets does not matter.
    //Example 2:
    //
    //Input: nums = [0,1,1]
    //Output: []
    //Explanation: The only possible triplet does not sum up to 0.
    //Example 3:
    //
    //Input: nums = [0,0,0]
    //Output: [[0,0,0]]
    //Explanation: The only possible triplet sums up to 0.
    //
    //
    //Constraints:
    //
    //3 <= nums.length <= 3000
    //-105 <= nums[i] <= 105

    public static void main(String[] args) {
        int[] ints = { -1, 0, 1, 2, -1, -4 };
        int[] ints2 = { 0, 1, 1 };
        int[] ints3 = { 0, 0, 0 };
        int[] ints4 = { -4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0 };

//        System.out.println(threeSum(ints));
//        System.out.println(threeSum(ints2));
//        System.out.println(threeSum(ints3));
        System.out.println(threeSum(ints4));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        //J-
        HashMap<Integer, Integer> numbersToIndicesMap = new HashMap<>();
        Set<List<Integer>> solutions = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numbersToIndicesMap.putIfAbsent(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int target = -nums[i];

            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                Integer indexOfDiffNum = numbersToIndicesMap.get(target - nums[j]);
                Integer indexOfFirstNum = i;
                Integer indexOfSecondNum = j;
                if ((indexOfDiffNum != null) && (indexOfDiffNum != i) && (indexOfDiffNum != j)) {
                    List<Integer> triplets = new ArrayList<>();
                    int firstNum = nums[i];
                    int secondNum = nums[j];
                    int thirdNum = nums[indexOfDiffNum];

                    Optional<List<Integer>> listContainingNumbers = solutions.stream()
                            .filter(list -> (list.contains(firstNum) && list.contains(secondNum)
                                    && list.contains(thirdNum) && indexOfDiffNum != indexOfFirstNum && indexOfDiffNum != indexOfSecondNum))
                            .findFirst();

                    if(listContainingNumbers.isEmpty()) {
                        triplets.add(firstNum);
                        triplets.add(secondNum);
                        triplets.add(thirdNum);
                        solutions.add(triplets);
                    }

                }
            }
        }

        return solutions.stream()
                .map(set -> set.stream().collect(Collectors.toList()))
                .collect(Collectors.toList());
        //J+
    }
}
