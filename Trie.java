public class Trie {

    // static class Node {
    //     Node children[] = new Node[26];
    //     boolean eow = false;

    //    public  Node() {
    //         for(int i = 0; i<26; i++) {
    //             children[i] = null;
    //         }
    //     }
    // }

    // public static Node root = new Node();

    // public static void insert(String word) { //O(l)
    //     Node curr = root;
    //     for(int level = 0; level<word.length(); level++) {
    //         int idx = word.charAt(level) - 'a';
    //         if(curr.children[idx] == null) {
    //             curr.children[idx] = new Node();
    //         }
    //         curr = curr.children[idx];
    //     }
    //     curr.eow = true;
    // }

    // public static boolean search(String key) {
    //     Node curr = root;
    //     for(int level = 0; level<key.length(); level++) {
    //         int idx = key.charAt(level) - 'a';
    //         if(curr.children[idx] == null) {
    //             return false;
    //         }
    //         curr = curr.children[idx];
    //     }
    //     return curr.eow == true;
    // }

    // public static boolean wordBreak(String key) {
    //     if(key.length() == 0) {
    //         return true;
    //     }
    //     for(int i = 1; i<=key.length(); i++) {
    //         if(search(key.substring(0, i)) &&
    //             wordBreak(key.substring(i))) {
    //                 return true;
    //             }
    //     }
    //     return false;
    // }

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

       public  Node() {
            for(int i = 0; i<26; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) { //O(l)
        Node curr = root;
        for(int level = 0; level<word.length(); level++) {
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                 curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public static void findPrefix(Node root, String ans) {
        if(root == null) {
            return;
        }

        if(root.freq == 1) {
            System.out.println(ans);
            return;
        }

        for(int i = 0; i<root.children.length; i++) {
            if(root.children[i] != null) {
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }
    public static void main(String[] args) {
        // String words[] = {"the", "a", "there", "their", "any", "thee"};
        // for(int i = 0; i<words.length; i++){
        //     insert(words[i]);
        // }

        // System.out.println(search("thee"));
        // System.out.println(search("thor"));

        // String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        // for(int i = 0; i<arr.length; i++) {
        //     insert(arr[i]);
        // }

        // String key = "ilikesamsung";
        // System.out.println(wordBreak(key));

        String arr[] = {"zebra", "dog", "dove", "duck"};
        for(int i = 0; i<arr.length; i++) {
            insert(arr[i]);
        }
        root.freq = -1;
        findPrefix(root, "");
    }
}
