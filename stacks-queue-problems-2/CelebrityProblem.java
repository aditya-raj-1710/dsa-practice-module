public class CelebrityProblem {
    public static void main(String[] args) {
        CelebrityProblemSolution solution = new CelebrityProblemSolution();

        int[][] M ={{0, 1, 1, 0},
                {0, 0, 0, 0},
                {1, 1, 0, 0},
                {0, 1, 1, 0}};
        System.out.println(solution.celebrity(M));
    }
}

class CelebrityProblemSolution {

    public int celebrity(int[][] M) {
        int n= M.length;
        int top=0, down=n-1;

        while(top<down){
            if(M[top][down]==1){
                top++;
            }else if(M[down][top]==1){
                down--;
            }else{
                top++;
                down--;
            }
        }

        if(top>down){
            return -1;
        }

        for(int i=0;i<n;i++){
            if(i==top){
                continue;
            }

            if(M[top][i]==1 || M[i][top]==0){
                return -1;
            }
        }
        return top;

    }

    public int celebrityBrute(int[][] M) {
        int n= M.length;
        int[] knowsMe = new int[n];
        int[] iKnow = new int[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(M[i][j]==1){
                    iKnow[i]++;
                    knowsMe[j]++;
                }
            }
        }

        for(int i=0;i<n;i++){
            if(knowsMe[i]==n-1 && iKnow[i]==0){
                return i;
            }
        }
        return -1;

    }
}