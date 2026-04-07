class TrieNode{
    TrieNode[] link = new TrieNode[26];
    boolean flagatend = false;
}

class PrefixTree {
   private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
         TrieNode cur = root;
         for(int i = 0 ; i<word.length() ; i++){
            if(cur.link[word.charAt(i)-'a'] == null){
                  cur.link[word.charAt(i)-'a']= new TrieNode();
            }
            cur = cur.link[word.charAt(i)-'a'];
         }
         cur.flagatend = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0 ; i<word.length() ; i++){
            if(cur.link[word.charAt(i)-'a'] == null){
                return false;
            }
           cur = cur.link[word.charAt(i)-'a']; 

        }
      return cur.flagatend;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0 ; i<prefix.length() ; i++){
            if(cur.link[prefix.charAt(i)-'a'] == null){
                return false;
            }
           cur = cur.link[prefix.charAt(i)-'a']; 

        }
       return true;
    }
}
