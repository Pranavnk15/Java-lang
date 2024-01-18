import java.util.ArrayList;

import javax.swing.plaf.synth.SynthStyle;

public class BST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if(root == null) {
            root = new Node(val);
            return root;
        }

        if(root.data > val) {
            //left Subtree
            root.left = insert(root.left, val);
        } else {
            //right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static void inorder(Node root) {
        if(root == null) {
            return ;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search(Node root, int key) {
        //TIME COMPLEXITY --> O(H)
        if(root == null) {
            return false;
        }

        if(root.data == key) {
            return true;
        }

        if(root.data > key) {
            return search(root.left, key);
        }

        else {
            return search(root.right, key);
        }

    }

    public static Node delete(Node root, int val) {
        if(root.data < val) {
            root.right = delete(root.right, val);
        }
        else if(root.data > val) {
            root.left = delete(root.left, val);
        }
        else { //voila
            //case 1 - leaf node
            if(root.left == null && root.right == null) {
                return null;
            }
            
            //case 2 - single child
            if(root.left == null) {
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case 3 - both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);

        }
        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;  
    }

    public static void printInRange(Node root, int k1, int k2){
        if(root == null) {
            return;
        }
        if(root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        else if(root.data < k1) {
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void printPath(ArrayList<Integer> path) {
        for(int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "-> ");
        }
        System.out.println("Null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if(root == null) {
            return;
        }

        path.add(root.data);
        if(root.left == null && root.right == null) {
            printPath(path);
        }
        printRoot2Leaf(root.left, path);
        printRoot2Leaf(root.right, path);
        path.remove(path.size()-1);
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if(root == null) {
            return true;
        }
        if(min != null && root.data <= min.data) {
            return false;
        }
        else if(max != null && root.data >= max.data) {
            return false;
        }

        return isValidBST(root.left, min, root) 
                && isValidBST(root.right, root, max);
    }


    public static void preorder(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static Node createMirror(Node root) { //O(n)
        if(root == null) {
            return null;
        }

        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static Node createBST(int arr[], int st, int end) {

        if(st > end) {
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(arr[mid]);
        root.left = createBST(arr, st, mid-1);
        root.right = createBST(arr, mid+1, end);
        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder){
        if(root == null) {
            return;
        }

        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);

    }
    public static Node createBST(ArrayList<Integer> inorder, int st, int end) {

        if(st > end) {
            return null;
        }
        int mid = (st+end)/2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, st, mid-1);
        root.right = createBST(inorder, mid+1, end);
        return root;
    }

    public static Node balancedBST(Node root){ //O(n)
        //inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);

        //sorted inorder -> balanced BST
        root = createBST(inorder, 0, inorder.size()-1);
        return root;
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if(root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        Info leftInfo = largestBST(root.left);
        Info rightInfo = largestBST(root.right);
        int size = leftInfo.size + rightInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, rightInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, rightInfo.max));

        if(root.data <= leftInfo.max || rightInfo.max >= root.data) {
            return new Info(false, size, min, max);
        }

        if(leftInfo.isBST && rightInfo.isBST) {
            maxBST = Math.max(maxBST, size);
           return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);
    }




    public static Node mergeBSTs(Node root1, Node root2) {
        //step1
        ArrayList<Integer> arr1 = new ArrayList<>();
        getInorder(root1, arr1);;

        //step2
        ArrayList<Integer> arr2 = new ArrayList<>();
        getInorder(root2, arr2);

        //merge
        int i = 0, j= 0;
        ArrayList<Integer> finalArr = new ArrayList<>();
        while(i<arr1.size() && j<arr2.size()){
            if(arr1.get(i) <= arr2.get(j)) {
                finalArr.add(arr1.get(i));
                i++;
            } else {
                finalArr.add(arr2.get(j));
                j++;
            }
        }

        while(i<arr1.size()) {
            finalArr.add(arr1.get(i));
            i++;
        }
        while(j<arr2.size()) {
            finalArr.add(arr2.get(j));
            j++;
        }

        //soted Al to balanced BST
        return createBST(finalArr, 0, finalArr.size()-1);
    }
    public static void main(String[] args) {
       // int values[] = {1, 1, 1};
       // Node root = null;

    //     for(int i = 0; i<values.length; i++) {
    //         root = insert(root, values[i]);
    //     }
    //   //  inorder(root);
    //     System.out.println();

        // root = delete(root, 14);
        // System.out.println();

       // printInRange(root, 5, 12);

       //printRoot2Leaf(root, new ArrayList<>());

    //    if(isValidBST(root, null, null)) {
    //         System.out.println("Valid BST");
    //    } else {
    //     System.out.println("Not Valid BST");
    //    }

        
        // /*          8  
        //  *         / \
        //  *        5   10
        //  *       / \   \
        //  *      3   6  11
        //  */
        //     Node root = new Node(8);
        //     root.left = new Node(5);
        //     root.right = new Node(10);
        //     root.left.left = new Node(3);
        //     root.left.right = new Node(6);
        //     root.right.right = new Node(11);

        //     /*         8
        //               / \
        //             10   5
        //            /    / \
        //           11   6   3
        //           MIRROR BST
        //      * 
        //      */
        //     root = createMirror(root);
        //     preorder(root);

        //     int arr[] = {3, 5, 6, 8, 10, 11, 12};
            
        // // /*          8  
        // //  *         /  \
        // //  *        5    11
        // //  *       / \   / \
        // //  *      3   6  10 11
        //         // Expected BST

        //     Node root = createBST(arr, 0, arr.length-1);
        //     preorder(root);

        // /*              8
        //               /  \
        //             6     10
        //            /       \
        //           5        11
        //          /          \
        //         3           12
        //         given BST
        //  */
        //     Node root = new Node(8);
        //     root.left = new Node(6);
        //     root.left.left = new Node(5);
        //     root.left.left.left = new Node(3);

        //     root.right = new Node(10);
        //     root.right.right = new Node(11);
        //     root.right.right.right = new Node(12);

        // // // /*          8  
        // // //  *         /  \
        // // //  *        5    11
        // // //  *       / \   / \
        // // //  *      3   6  10 12
        // //         // Expected BST

        //     root = balancedBST(root);
        //     preorder(root);


                // //         50
                // //        /  \
                // //       30   60
                // //      /  \  /  \
                // //     5   20 45 20
                // //               / \ 
                // //              65  80

                // // GIVEN BT

                // Node root = new Node(50);
                // root.left = new Node(30);
                // root.left.left = new Node(5);
                // root.left.right = new Node(20);

                // root.right = new Node(60);
                // root.right.left = new Node(45);
                // root.right.right = new Node(20);
                // root.right.right.left = new Node(65);
                // root.right.right.right = new Node(80);


                //     //         60
                //     //        /  \
                //     //       45  70
                //     //           / \
                //     //          65  80
                //     // expected BST: size = 5
       
                // Info info = largestBST(root);
                // System.out.println("largest BST size = " + maxBST);

                /*              2
                 *             / \
                 *            1   4
                 *          BST 1
                 */
                    Node root1 = new Node(2);
                    root1.right = new Node(4);
                    root1.left = new Node(1);

                    /*          9
                     *         / \
                     *        3   12
                     *          BST 2
                     */
                    Node root2 = new Node(9);
                    root2.left = new Node(3);
                    root2.right = new Node(12);

                    /*         3
                     *        / \
                     *       1   9
                     *        \ / \
                     *        2 4  12
                     *      final BST
                     */
                    Node root = mergeBSTs(root1, root2);
                    preorder(root);
    }
}
