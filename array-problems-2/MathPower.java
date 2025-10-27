public class MathPower {
    public static void main(String[] args) {
        MathPowerSolution solution = new MathPowerSolution();
        double value = solution.myPow(2,-2);
        System.out.println(value);
    }
}
class MathPowerSolution {
    public double myPow(double x, int n) {
        //your code goes here
        if(n<0){
            return 1/power(x,-n);
        }
        return power(x,n);

    }

    public double power(double x,int n){
        if(n==0){
            return 1;
        }else{
            if(n%2==0){
                return myPow(x*x,n/2);
            }
            return x*myPow(x,n-1);
        }
    }
}
