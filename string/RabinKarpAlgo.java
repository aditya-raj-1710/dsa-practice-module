import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgo {
    public static void main(String[] args) {
        String a = "abcd";
        String b ="cdabcdab";

        RabinKarpAlgoSolution solution = new RabinKarpAlgoSolution();

        System.out.println(solution.repeatedStringMatch(a,b));
        System.out.println(solution.search(a,b));
        System.out.println(solution.searchBrute(a,b));
    }
}

class RabinKarpAlgoSolution {
    /// LeetCode solution - repeated-string-match
    public int repeatedStringMatch(String a, String b) {
        if(a.equals(b)){
            return 1;
        }
        String sourceA = a;
        int count=1;

        while(sourceA.length() < b.length()){
            count++;
            sourceA += a;
        }

        if(sourceA.equals(b)){
            return count;
        }

        if(!search(b,sourceA).isEmpty()){
            return count;
        }

        if(!search(b,sourceA+a).isEmpty()){
            return count+1;
        }
        return -1;
    }

    ///  TUF solution
    public List<Integer> search(String pat, String txt) {
        List<Integer> ans = new ArrayList<>();

        int m=txt.length();
        int n=pat.length();

        int p=7,mod=101;

        int hashPat = 0, hashText =0;
        int pRight =1, pLeft=1;

        for(int i=0;i<n;i++){
            hashPat = (hashPat + ((pat.charAt(i)-'a'+1)*pRight)%mod)%mod;
            hashText = (hashText + ((txt.charAt(i)-'a'+1)*pRight)%mod)%mod;

            pRight = (pRight*p)%mod;
        }

        for(int i=0;i<=m-n;i++){
            if(hashPat == hashText){
                if(txt.substring(i,i+n).equals(pat)){
                    ans.add(i);
                }
            }

            if(i<m-n){
                hashText = (hashText - ((txt.charAt(i)-'a'+1)*pLeft)%mod+mod)%mod;
                hashText = (hashText + ((txt.charAt(i+n)-'a'+1)*pRight)%mod)%mod;
                hashPat = (hashPat*p)%mod;

                pLeft = (pLeft*p)%mod;
                pRight = (pRight*p)%mod;

            }
        }

        return ans;
    }

    /// Brute solution
    public List<Integer> searchBrute(String pat, String txt) {
        List<Integer> ans = new ArrayList<>();

        int m=txt.length();
        int n=pat.length();

        for(int i=0;i<=m-n;i++){
            boolean flag=true;
            for(int j=0;j<n;j++){
                if(pat.charAt(j) != txt.charAt(i+j)){
                    flag = false;
                    break;
                }
            }

            if(flag){
                ans.add(i);
            }
        }
        return ans;
    }
}
