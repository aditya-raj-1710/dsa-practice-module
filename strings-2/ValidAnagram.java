import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagramSolution solution = new ValidAnagramSolution();

        String s1= "anagram";
        String s2= "nagaram";

        System.out.println(solution.anagramStrings(s1,s2));
    }
}

class ValidAnagramSolution {

    /// Array implementation - better than hashmap due to no hashing overhead
    public boolean anagramStrings(String s1, String s2) {
        if(s1.length() !=s2.length())
            return false;
        int[] dict = new int[26];
        for(char c: s1.toCharArray()){
            dict[c-'a'] +=1;
        }
        for(char c: s2.toCharArray()){
            dict[c-'a'] -=1;
            if(dict[c-'a']<0){
                return false;
            }
        }

        for(int i: dict){
            if(i<0){
                return false;
            }
        }
        return true;
    }

    /// Hashmap approach - hashing overhead but good when unicode data is present
    public boolean anagramStringsHash(String s1, String s2) {
        if(s1.length() !=s2.length())
            return false;
        HashMap<Character, Integer> cHashMap = new HashMap<>();
        for(char ch: s1.toCharArray()){
            cHashMap.put(ch, cHashMap.getOrDefault(ch, 0)+1);
        }
        for(char ch: s2.toCharArray()){
            cHashMap.put(ch, cHashMap.getOrDefault(ch, 0)-1);
        }

        for(int val: cHashMap.values()){
            if(val !=0)
                return false;
        }
        return true;
    }
}
