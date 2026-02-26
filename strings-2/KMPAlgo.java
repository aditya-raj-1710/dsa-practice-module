import java.util.ArrayList;
import java.util.List;

public class KMPAlgo {
    public static void main(String[] args) {
        KMPAlgoSolution solution = new KMPAlgoSolution();

        String txt = "abracadabra";
        String pat = "abra";

        System.out.println(solution.search(pat,txt));
    }
}

class KMPAlgoSolution {

    public List<Integer> search(String pat, String txt) {
        String s = pat+ "$"+ txt;

        int[] LPS = computeLPS(s);

        int n = txt.length(), m=pat.length();

        List<Integer> ans = new ArrayList<>();

        for(int i = m+1;i< s.length();i++){
            if(LPS[i] == m){
                ans.add(i-2*m);
            }
        }
        return ans;
    }

    /// Optimal
    private int[] computeLPS(String s){
        int n = s.length();

        int[] LPS = new int[n];
        int i=1,j=0;

        while(i<n){
            if(s.charAt(i) == s.charAt(j)){
                LPS[i]=j+1;
                i++;
                j++;
            }else{
                while(j>0 && s.charAt(i) != s.charAt(j)){
                    j = LPS[j-1];
                }
                if(s.charAt(i) == s.charAt(j)){
                    LPS[i] = j+1;
                    j++;
                }
                i++;
            }
        }
        return LPS;
    }

    /// Brute
    private int[] computeLPSBrute(String s){
        int n = s.length();

        int[] LPS = new int[n];

        for(int i=1;i<n;i++){
            for(int len =1; len< i;len++){
                if(s.substring(0,len).equals(s.substring(i-len+1,i+1))){
                    LPS[i] = len;
                }
            }
        }
        return LPS;
    }

}

