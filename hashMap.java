import java.util.*;



public class hashMap {

    // static class HashMap<K, V> { // generic
    //     private class Node {
    //         K key;
    //         V value;

    //         public Node(K key, V value) {
    //             this.key = key;
    //             this.value = value;
    //         }
    //     }

    //     private int n; //n
    //     private int N;
    //     private LinkedList<Node> buckets[]; //N buckets.length

    //     @SuppressWarnings("unchecked")
    //     public HashMap() {
    //         this.N = 4;
    //         this.buckets = new LinkedList[4];
    //         for(int i = 0; i<4; i++) {
    //             this.buckets[i] = new LinkedList<>();
    //         }
    //     }

    //     private int hashFunction(K key) {
    //         int hc = key.hashCode();
    //         return Math.abs(hc) % N;
    //     }
    //     private int SearchInLL(K key, int bi) {
    //         LinkedList<Node> ll = buckets[bi];
    //         int di = 0;

    //         for(int i = 0; i<ll.size(); i++) {
    //             Node node = ll.get(i);
    //             if(node.key == key) {
    //                 return di;
    //             }
    //             di++;
    //         }
    //         return -1;

    //     }

    //     @SuppressWarnings("unchecked")
    //     private void rehash() {
    //         LinkedList<Node> oldBuck[] = buckets;
    //         buckets = new LinkedList[N*2];
    //         N = N*2;
    //         for(int i = 0; i<buckets.length; i++) {
    //             buckets[i] = new LinkedList<>();
    //         }

    //         //nodes -> add in bucket
    //         for(int i = 0; i<oldBuck.length; i++) {
    //             LinkedList<Node> ll = oldBuck[i];
    //             for(int j = 0; j<ll.size(); j++) {
    //                 Node node = ll.remove();
    //                 put(node.key, node.value);
    //             }
    //         }
    //     }
    //     public void put(K key, V value){
    //         int bi = hashFunction(key); //returns bucket index
    //         int di = SearchInLL(key, bi);//data index 

    //         if(di != -1) {
    //             Node node = buckets[bi].get(di);
    //             node.value = value;
    //         } else {
    //             buckets[bi].add(new Node(key, value));
    //             n++;
    //         }

    //         double lambda = (double)n/N;
    //         if(lambda > 2.0) {
    //             rehash();
    //         }
    //     }

    //     public boolean containsKey(K key) {
    //         int bi = hashFunction(key);
    //         int di = SearchInLL(key, bi);

    //         if(di != -1) {
    //             return true;
    //         } else {
    //             return false;
    //         }
    //     }

    //     public V get(K key) {
    //         int bi = hashFunction(key); //returns bucket index
    //         int di = SearchInLL(key, bi);//data index 

    //         if(di != -1) {
    //             Node node = buckets[bi].get(di);
    //             return node.value;
    //         } else {
    //             return null;
    //         }
    //     }

    //     public V remove(K key) {
    //         int bi = hashFunction(key); //returns bucket index
    //         int di = SearchInLL(key, bi);//data index 

    //         if(di != -1) {
    //             Node node = buckets[bi].remove(di);
    //             n--;
    //             return node.value;
    //         } else {
    //            return null;
    //         }
    //     }

    //     public ArrayList<K> keySet() {
    //         ArrayList<K> keys = new ArrayList<>();

    //         for(int i = 0; i<buckets.length; i++) {
    //             LinkedList<Node> ll = buckets[i];
    //             for (Node node : ll) {
    //                 keys.add(node.key);
    //             }
    //         }
    //         return keys;
    //     }

    //     public boolean isEmpty() {
    //         return n == 0;
    //     }

    // }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i = 0; i<t.length(); i++) {
            if(map.get(t.charAt(i)) != null) {
                if(map.get(t.charAt(i)) == 1) {
                    map.remove(t.charAt(i));
                } else {
                    map.put(t.charAt(i), map.get(t.charAt(i)-1));
                }
            } else {
                return false;
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {
        //Create a hashMap
       // HashMap<String, Integer> hm = new HashMap<>();

        // //inset-O(1)
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("US", 50);
        // System.out.println(hm);

        // // //get-O(1)
        // // int population = hm.get("India");
        // // System.out.println(population);
        // // System.out.println(hm.get("Indoneshia"));

        // // //containsKey-O(1)
        // // System.out.println(hm.containsKey("India"));//true
        // // System.out.println(hm.containsKey("Indoneshia")); //false

        // // //remove-O(1)
        // // System.out.println(hm.remove("China"));
        // // System.out.println(hm);

        // //Size
        // System.out.println(hm.size());
        
        // //Is Empty
        // hm.clear();
        // System.out.println(hm.isEmpty());

///////////////////////////////////////////////////////////////////////////////
        // HashMap<String, Integer> hm = new HashMap<>();
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("US", 50);
        // hm.put("Indonesia", 6);
        // hm.put("Nepal", 5);

        // //Iterate
        // Set<String> keys = hm.keySet();
        // System.out.println(keys);

        // for (String k : keys) {
        //     System.out.println("key= " +k+", value= "+hm.get(k));
        // }
//////////////////////////////////////////////////////////////////////////////////

        // HashMap<String, Integer> hm = new HashMap<>();
        // hm.put("India", 100);
        // hm.put("China", 150);
        // hm.put("US", 50);
        // hm.put("Indonesia", 6);
        // hm.put("Nepal", 5);
        
        // ArrayList<String> keys = hm.keySet();
        // for (String key : keys) {
        //     System.out.println(key);
            
        // }
////////////////////////////////////////////////////////////////////////////////

            // LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
            // lhm.put("India", 100);
            // lhm.put("China", 150);
            // lhm.put("US", 50);

            // HashMap<String, Integer> hm = new HashMap<>();
            // hm.put("India", 100);
            // hm.put("China", 150);
            // hm.put("US", 50);

            // System.out.println(lhm);
            // System.out.println(hm);
//////////////////////////////////////////////////////////////////////////

            // TreeMap<String, Integer> tm = new TreeMap<>();
            // tm.put("India", 100);
            // tm.put("China", 150);
            // tm.put("US", 50);
            // tm.put("Indonesia", 6);

            // HashMap<String, Integer> hm = new HashMap<>();
            // hm.put("India", 100);
            // hm.put("China", 150);
            // hm.put("US", 50);

            // System.out.println(tm);
                // System.out.println(hm);
/////////////////////////////////////////////////////////////////////////
            //QUESTIONS
            // // 1. Majority Element
            // int arr[] = {1, 3, 2, 5, 1, 3, 1, 5, 1};
            // HashMap<Integer, Integer> hm = new HashMap<>();

            // // for(int i = 0; i<arr.length; i++) {
            // //     if(hm.containsKey(arr[i])) {
            // //         hm.put(arr[i], hm.get(arr[i])+1);
            // //     } else {
            // //         hm.put(arr[i], 1);
            // //     }
            // // }
            // //Alternative
            // for(int i = 0; i<arr.length; i++) {
            //     hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
            // }

            // // Set<Integer> keySet = hm.keySet();
            // // for (Integer key : keySet) {    
            // //     if(hm.get(key) > arr.length/3) {
            // //         System.out.println(key);
            // //     }
                
            // // }
            // //Alternative shortcut
            // for (Integer key : hm.keySet()) {
            //     if(hm.get(key) > arr.length/3){
            //         System.out.println(key);
            //     }
            // }
////////////////////////////////////////////////////////////////////////////
                // VALID ANAGRAM
                String s = "race";
                String t = "care";

                System.err.println(isAnagram(s, t)  );

//////////////////////////////////////////////////////////////////////////////




















    }
}
