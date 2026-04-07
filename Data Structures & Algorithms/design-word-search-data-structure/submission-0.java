class TrieNode{
    TrieNode[] link = new TrieNode[26];
    boolean flagatend = false;
}
class WordDictionary {
     private TrieNode root;
     
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
         for(int i = 0 ; i<word.length() ; i++){
            if(cur.link[word.charAt(i)-'a'] == null){
                  cur.link[word.charAt(i)-'a']= new TrieNode();
            }
            cur = cur.link[word.charAt(i)-'a'];
         }
         cur.flagatend = true;
    }
    public boolean search(String word){
     return dfs(word, 0 , root);
    }

    public boolean dfs(String word , int j , TrieNode root) {
       TrieNode cur = root;
        for(int i = j ; i<word.length() ; i++){
         if(word.charAt(i)== '.'){
            for(TrieNode child : cur.link){
                 if(child != null && dfs(word , i+1 , child)){
                    return true;
                 }
            }
           return false ;     
         }  
         else{
            if(cur.link[word.charAt(i)-'a'] == null){
                return false;
            }
           cur = cur.link[word.charAt(i)-'a']; 
         }
        }
      return cur.flagatend;
    }
}
