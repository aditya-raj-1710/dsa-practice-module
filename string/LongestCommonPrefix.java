import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] str= {"flowers", "flow", "fly", "flight" };

        LongestCommonPrefixSolution solution = new LongestCommonPrefixSolution();
        System.out.println(solution.longestCommonPrefix(str));
    }

}

class LongestCommonPrefixSolution {
    public String longestCommonPrefix(String[] str) {
        Arrays.sort(str);

        StringBuilder result = new StringBuilder();

        String firstS = str[0];
        String secondS = str[str.length-1];

        for(int i=0;i < Math.min(firstS.length(),secondS.length());i++){
            if(firstS.charAt(i) != secondS.charAt(i)){
                break;
            }
            result.append(firstS.charAt(i));
        }

        return result.toString();
    }
}