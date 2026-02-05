import java.util.Arrays;
import java.util.List;

public class ReverseWords {
    public static void main(String[] args) {
        ReverseWordsSolution solution = new ReverseWordsSolution();

        String s = "  hello  world  ";

        String reverse = solution.reverseWords(s);
        System.out.println(reverse);
    }
}

class ReverseWordsSolution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        int left =0, right= words.length-1;
        while(left < right){
            String temp = words[left].trim();
            words[left]=words[right];
            words[right]= temp;
            left++;
            right--;
        }

        return String.join( " ",words);

    }
}

