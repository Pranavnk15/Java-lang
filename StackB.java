import java.util.*;

public class StackB {

    // static class Node {
    //     int data;
    //     Node next;
    //     Node(int data) {
    //         this.data = data;
    //         this.next = null;
    //     }
    // }
    // static class Stack {
    //     static Node head = null;

    //     public static boolean isEmpty() {
    //         return head == null;
    //     }
    //     //push
    //     public static void push(int data){
    //         Node newNode = new Node(data);
    //         if(isEmpty()) {
    //             head = newNode;
    //             return;
    //         }
    //         newNode.next = head;
    //         head = newNode;

    //     }
    //     //pop
    //     public int pop() {
    //         if(isEmpty()) {
    //             return -1;
    //         }
    //         int top = head.data;
    //         head = head.next;
    //         return top;
    //     }
    //     //peek
    //     public int peek() {
    //         if(isEmpty()) {
    //             return -1;
    //         }
    //         return head.data;
    //     }
    // }


    public static void pushAtBottom(Stack<Integer> s, int data) {
            if(s.isEmpty()) {
                s.push(data);
                return;
            }
            int top = s.pop();
            pushAtBottom(s, data);
            s.push(top);
    }

    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder();
        while(!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();   
    }


    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }

    public static void stockSpan(int stock[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1; i<stock.length; i++) {
            int currPrice = stock[i];
            while(!s.isEmpty() && currPrice > stock[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);

        }
    }

    public static boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        for(int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                //closing
                if(s.isEmpty()) {
                    return false;
                }
                if((s.peek() == '(' && ch == ')') || //()
                 (s.peek() == '{' && ch == '}') || //{}
                 (s.peek() == '[' && ch == ']' )) { //[]
                    s.pop();
                 } else {
                    return false;
                 }
            }
        }

        if(s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isDuplicate(String str) {
        Stack<Character> s= new Stack<>();
        
        for(int i = 0; i<str.length(); i++) {
            char ch = str.charAt(i);

            //closing
            if(ch == ')') {
                int count = 0;
                while(s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if(count < 1) {
                    return true; //duplicate
                } else {
                    s.pop(); //openeing parentheses
                }
                 
            } else {
                //opening
                s.push(ch);
            }
        }
        return false;
    }

    public static void maxArea(int arr[]) { //O(n)
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        //Next Smaller Right
        Stack<Integer> s = new Stack<>();
        for(int i = arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //current area
        s = new Stack<>();
        for(int i = 0; i<arr.length; i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nsr[i] = arr.length;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //current area : width = j-i-1
        for(int i = 0; i<arr.length; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i]-1;
            int currArea = height * width ;
            maxArea = Math.max(currArea, maxArea);
        }

        System.out.println("Max area in histogram is: " + maxArea);
    }
    public static void main(String[] args) {
        //Stack s = new Stack();
        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);  
        // s.push(3);

        // pushAtBottom(s, 4);

        // while(!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }


        // String str = "HelloWorld";
        // String result = reverseString(str);
        // System.out.println(result);

        // Stack<Integer> s = new Stack<>();
        // s.push(1);
        // s.push(2);
        // s.push(3);
        //     // 3, 2, 1
        
        // reverseStack(s);
        // printStack(s);
        // //1, 2, 3

        // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int span[] = new  int[stocks.length];
        // stockSpan(stocks, span);

        // for(int i = 0; i<span.length; i++) {
        //     System.out.println(span[i] + " ");
        // }

    //     int arr[] = {6, 8, 0, 1, 3};
    //     Stack<Integer> s = new Stack<>();
    //     int nxtGreater[] = new int[arr.length];

    //     for(int i = arr.length-1; i>=0; i--) {
    //         //1 while
    //         while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
    //             s.pop();
    //         }
    //         //2 if-else
    //         if(s.isEmpty()) {
    //             nxtGreater[i] = -1;
    //         } else {
    //             nxtGreater[i] = arr[s.peek()];
    //         }
    //         //3 push in s
    //         s.push(i);
    //     }
    //     for(int i = 0; i<nxtGreater.length; i++) {
    //         System.out.print(nxtGreater[i] + " ");
    //     }
    //     System.out.println();
    //      //next Greater Right
    // //Next Greater Left
    // //next Smaller Right
    // //next Smaller Left

            // String str = "(({})[])"; //true
            // System.out.println(isValid(str));
        
        // String str = "((a+b))"; //true
        // String str2 = "(a-b)"; //false
        // System.out.println(isDuplicate(str));

        int arr[] = {2, 1, 5, 6, 2, 3}; //heights
        maxArea(arr);
        
    }
   

}
