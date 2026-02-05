public class StringToNumber {
    public static void main(String[] args) {
        String num="-12345.08 words";
        StringToNumberSolution solution = new StringToNumberSolution();
        System.out.println(solution.myAtoi(num));
    }
}

class StringToNumberSolution {
    public int myAtoi(String input) {
        int i=0,n=input.length();

        while (i<n && input.charAt(i)==' '){
            i++;
        }
        int sign=1;
        if(i<n && input.charAt(i)=='-'){
            sign=-1;
            i++;
        }else if(i<n && input.charAt(i)=='+'){
            i++;
        }
        long total=0;

        while(i<n && Character.isDigit(input.charAt(i))){
            total = total*10+ (input.charAt(i)-'0');

            if(total*sign > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if(total*sign < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            i++;
        }

        return (int)total*sign;
    }
}
