
package blind75.array;

public class ContainerWithMostWater {

    //~ ----------------------------------------------------------------------------------------------------------------
    //~ Methods 
    //~ ----------------------------------------------------------------------------------------------------------------

    // You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    //
    //Find two lines that together with the x-axis form a container, such that the container contains the most water.
    //
    //Return the maximum amount of water a container can store.
    //
    //Notice that you may not slant the container.
    //
    //
    //
    //Example 1:
    //
    //
    //Input: height = [1,8,6,2,5,4,8,3,7]
    //Output: 49
    //Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
    //Example 2:
    //
    //Input: height = [1,1]
    //Output: 1
    //
    //
    //Constraints:
    //
    //n == height.length
    //2 <= n <= 105
    //0 <= height[i] <= 104
    public static void main(String[] args) {
        int[] heights = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int[] heights2 = { 1, 1 };
        int[] heights3 = { 2, 3, 4, 5, 18, 17, 6 };
        int[] heights4 = { 1, 2, 3, 4, 5, 25, 24, 3, 4 };
        int[] heights5 = { 1, 8, 100, 2, 100, 4, 8, 3, 7 };

        System.out.println(maxArea(heights));
        System.out.println(maxArea(heights2));
        System.out.println(maxArea(heights3));
        System.out.println(maxArea(heights4));
        System.out.println(maxArea(heights5));
    }

    public static int maxArea(int[] height) {
        //J-
        int left = 0;
        int right = height.length - 1;
        int maxVolume = Math.min(height[left], height[right]) * (right - left);

        while(left < right) {
            int currentVolume = Math.min(height[left], height[right]) * (right - left);

            if(currentVolume > maxVolume) {
                maxVolume = currentVolume;
            }

            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        //J+

        return maxVolume;
    }
}
