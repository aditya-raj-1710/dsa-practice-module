public class VersionComparison {
    public static void main(String[] args) {
        String s1 = "2.10.9.0";
        String s2 = "2.10.9";

        VersionComparisonSolution solution = new VersionComparisonSolution();

        System.out.println(solution.compareVersion(s1,s2));
    }
}

class VersionComparisonSolution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n= Math.max(s1.length,s2.length);

        for(int i=0;i< n;i++){
            int i1 = i< s1.length? Integer.parseInt(s1[i]):0;
            int i2 = i< s2.length? Integer.parseInt(s2[i]):0;

            if (i1>i2){
                return 1;
            }
            if(i1<i2){
                return -1;
            }
        }

        return 0;
    }
}
