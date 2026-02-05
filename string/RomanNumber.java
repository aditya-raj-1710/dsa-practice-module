import java.util.HashMap;
import java.util.Map;

public class RomanNumber {
    public static void main(String[] args) {
        String s = "DCCCXC";
        RomanNumberSolution solution = new RomanNumberSolution();
        System.out.println(solution.romanToInt(s));
    }
}

class RomanNumberSolution {
    /*  I = 1
        V = 5
        X = 10
        L = 50
        C = 100
        D = 500
        M = 1000
    */
    public int romanToInt(String s) {
        Map<Character,Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        var total=0;
        for(int i=0;i<s.length();i++){
            if(i+1 < s.length() && map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                total-=map.get(s.charAt(i));
            }else {
                total += map.get(s.charAt(i));
            }
        }
        return total;
    }
}