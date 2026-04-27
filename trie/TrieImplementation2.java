public class TrieImplementation2 {
    public static void main(String[] args) {
        Trie2 trie = new Trie2();
        trie.insert("apple");
        trie.insert("apple");
        System.out.println("Inserting strings 'apple' twice into Trie");
        System.out.println("Count Words Equal to 'apple': " + trie.countWordsEqualTo("apple"));
        System.out.println("Count Words Starting With 'app': " + trie.countWordsStartingWith("app"));
        System.out.println("Erasing word 'apple' from Trie");
        trie.erase("apple");
        System.out.println("Count Words Equal to 'apple': " + trie.countWordsEqualTo("apple"));
        System.out.println("Count Words Starting With 'app': " + trie.countWordsStartingWith("app"));
        System.out.println("Erasing word 'apple' from Trie");
        trie.erase("apple");
        System.out.println("Count Words Starting With 'app': " + trie.countWordsStartingWith("app"));
    }
}

class Trie2 {
    private TrieNode2 root;
    public Trie2() {
        root = new TrieNode2();
    }

    public void insert(String word) {
        TrieNode2 TrieNode2 = root;

        for(int i=0;i< word.length();i++){
            if(!TrieNode2.containsKey(word.charAt(i))){
                TrieNode2.put(word.charAt(i), new TrieNode2());
            }
            TrieNode2 = TrieNode2.get(word.charAt(i));
            TrieNode2.increasePrefix();
        }
        TrieNode2.increaseEnd();
    }

    public int countWordsEqualTo(String word) {
        TrieNode2 TrieNode2 = root;

        for(int i=0;i< word.length();i++){
            if(TrieNode2.containsKey(word.charAt(i))){
                TrieNode2 = TrieNode2.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        return TrieNode2.getEnd();
    }

    public int countWordsStartingWith(String prefix) {
        TrieNode2 TrieNode2 = root;

        for(int i=0;i< prefix.length();i++){
            if(TrieNode2.containsKey(prefix.charAt(i))){
                TrieNode2 = TrieNode2.get(prefix.charAt(i));
            }else{
                return 0;
            }
        }

        return TrieNode2.getPrefix();
    }

    public void erase(String word) {
        TrieNode2 TrieNode2 = root;

        for(int i=0;i< word.length();i++){
            if(TrieNode2.containsKey(word.charAt(i))){
                TrieNode2 = TrieNode2.get(word.charAt(i));
                TrieNode2.reducePrefix();
            }else{
                return;
            }
        }

        TrieNode2.deleteEnd();
    }
}

class TrieNode2{
    private TrieNode2[] links;
    private int countEndWith;
    private int countPrefix;

    public TrieNode2(){
        links = new TrieNode2[26];
        countEndWith =0;
        countPrefix =0;
    }

    public boolean containsKey(char ch){
        return links[ch-'a'] != null;
    }

    public TrieNode2 get(char ch){
        return links[ch-'a'];
    }

    public void put(char ch, TrieNode2 TrieNode2){
        links[ch-'a'] = TrieNode2;
    }

    public void increaseEnd(){
        countEndWith++;
    }

    public void increasePrefix(){
        countPrefix++;
    }

    public void deleteEnd(){
        countEndWith--;
    }

    public void reducePrefix(){
        countPrefix--;
    }

    public int getEnd(){
        return countEndWith;
    }

    public int getPrefix(){
        return countPrefix;
    }
}
