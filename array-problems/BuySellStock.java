public class BuySellStock {
    public static void main(String[] args) {
        BuySellStockSolution solution = new BuySellStockSolution();
        int[] nums = {869,526,775,424,138,615,144,179,854,856,420,362,947,
                830,772,988,687,65,787,435,407,303,16,181,515,76,742,845};
        int profit = solution.stockBuySell(nums, nums.length);
        System.out.println(profit);
        System.out.println(988-138);
    }
}
class BuySellStockSolution {
    public int stockBuySell(int[] nums, int n) {
        int mini = nums[0];
        int maxProfit = 0;
        for(int i=1;i<n;i++){
            int currentProfit = nums[i] - mini;
            maxProfit = Math.max(maxProfit,currentProfit);
            mini = Math.min(mini,nums[i]);
        }
        return maxProfit;
    }
}