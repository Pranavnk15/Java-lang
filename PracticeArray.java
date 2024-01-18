public class PracticeArray {

    public static void bubbleSort(int arr[]) {
        //outer loop for turn
        for(int turn = 0; turn<arr.length-1; turn++) {
            for(int j = 0 ; j<arr.length-1-turn; j++) {
                if(arr[j] < arr[j+1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void printarr(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void selectionSort(int arr[]) {
        //outer loop for turn
        for(int i = 0; i < arr.length-1; i++) {
            int maxPos = i;
            for(int j = i+1; j <arr.length; j++) {
                if(arr[maxPos] < arr[j]) {
                    maxPos = j;
                }
            }
            //swap
            int temp = arr[maxPos];
            arr[maxPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int arr[]) {
        for(int i = 0; i < arr.length-1; i++) {
            int curr = arr[i];
            int prev = i-1;
            
            //selection of position 
            while(prev >=0 && arr[prev] < curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            //insertion
            arr[prev+1] = curr;
        }
    }

    public static void countingSort(int arr[]) {
        int largest  = Integer.MIN_VALUE;
        for(int i = 0; i<arr.length; i++) {
                largest = Math.max(largest, arr[i]);
        }
        int count[] = new int[largest+1];
        for(int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        //sorting
        int j = 0;
        for(int i = count.length; i >= 0; i--) {
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] = {3, 6, 2, 1, 8, 7, 4, 5, 3, 1};
       // bubbleSort(arr);
       //selectionSort(arr);
      // insertionSort(arr);
        countingSort(arr);
        printarr(arr);
    }
}
