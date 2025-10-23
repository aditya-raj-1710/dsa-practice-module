public class RepeatAndMissingNumbers {
    public static void main(String[] args) {
        RepeatAndMissSolution solution = new RepeatAndMissSolution();

        int[] nums = {3,4,2,2,6,5,8,7,9};
        int[] solutions = solution.findMissingRepeatingNumbers(nums);
        System.out.println("Repeat: "+ solutions[0]);
        System.out.println("Miss: "+ solutions[1]);
    }
}

class RepeatAndMissSolution {
    public int[] findMissingRepeatingNumbers(int[] nums) {
        int repeat = -1, miss = -1, n= nums.length;
        int[] hash = new int[n+1];
        for(int i=0;i<n;i++){
            hash[nums[i]]++;
        }

        for(int i=1;i<=n;i++){
            if(hash[i] ==2){
                repeat = i;
            }else if( hash[i] ==0){
                miss =i;
            }else if( repeat !=-1 && miss !=-1){
                break;
            }
        }

        return new int[]{repeat,miss};

    }
}