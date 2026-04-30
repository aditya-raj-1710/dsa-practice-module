public class MaxXorInArray {
    public static void main(String[] args) {
        MaxXorInArraySolution solution = new MaxXorInArraySolution();

        //int[] nums = {3, 10, 5, 25, 2, 8};
        int[] nums = {3};

        System.out.print("Input: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int result = solution.findMaximumXOR(nums);
        System.out.println("Maximum XOR value: " + result);
    }
}

class MaxXorInArraySolution {
    public int findMaximumXOR(int[] nums) {
        TrieXor trie = new TrieXor();
        for(int num: nums){
            trie.insert(num);
        }

        int maxi=0;

        for(int num:nums){
            maxi = Math.max(maxi,trie.getMax(num));
        }
        return maxi;
    }
}

class TrieXor{
    private NodeTrieXor root;

    TrieXor(){
        root = new NodeTrieXor();
    }

    void insert(int num){
        NodeTrieXor node = root;

        for(int i=31;i>=0;i--){
            int bit = (num>>i) & 1;
            //System.out.println("bit"+bit);

            if(!node.containsKey(bit)){
                node.put(bit, new NodeTrieXor());
            }
            node = node.get(bit);
        }
    }

    int getMax(int num){
        NodeTrieXor node = root;

        int maxNum = 0;

        for(int i=31;i>=0;i--){
            int bit = (num>>i) & 1;

            if(node.containsKey(1-bit)){
                maxNum |= (1<<i);
                //System.out.println("maxNum"+maxNum);
                node = node.get(1-bit);
            }else{
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

class NodeTrieXor{
    NodeTrieXor[] links = new NodeTrieXor[2];

    boolean containsKey(int bit){
        return links[bit] != null;
    }

    void put(int bit, NodeTrieXor node){
        links[bit] = node;
    }

    NodeTrieXor get(int bit){
        return links[bit];
    }
}