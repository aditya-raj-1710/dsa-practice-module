public class TrapWaterProblem {
    public static void main(String[] args) {
        int[] height = //{4, 2, 0, 3, 2, 5};
                 {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        TrapWaterProblemSolution solution = new TrapWaterProblemSolution();
        solution.printArray(height);
        int water = solution.trap(height);
        System.out.println(water);
        water = solution.trapBrute(height);
        System.out.println(water);
    }
}

class TrapWaterProblemSolution {

    /// Optimal approach without extra O(n) space
    public int trap(int[] height) {
        int n = height.length;
        int totalWater =0;

        int leftMax=0;
        int rightMax=0;
        int left =0;
        int right = n-1;

        while(left < right){
            if(height[left] <= height[right]){
                if(leftMax > height[left]){
                    totalWater += leftMax-height[left];
                }else{
                    leftMax = height[left];
                }
                left++;
            }else{
                if(rightMax > height[right]){
                    totalWater += rightMax - height[right];
                }else{
                    rightMax = height[right];
                }
                right --;
            }
        }


        return totalWater;
    }

    /// Brute force : O(n) with extra space O(n)
    public int trapBrute(int[] height) {
        int n = height.length;
        int totalWater =0;

        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] =height[0];
        suffixMax[n-1] = height[n-1];

        for(int i=1;i<n;i++){
            prefixMax[i] = Math.max(prefixMax[i-1],height[i]);
        }

        for(int i=n-2;i>=0;i--){
            suffixMax[i] = Math.max(suffixMax[i+1],height[i]);
        }

        for(int i=0;i<n;i++){
            if(height[i] < prefixMax[i] && height[i] < suffixMax[i]){
                totalWater += (Math.min(prefixMax[i],suffixMax[i])-height[i]);
            }
        }

        return totalWater;
    }

    public void printArray(int[] height){
        for (int i:height){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
