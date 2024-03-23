import java.util.*;
import java.io.*;
class Search {
    public static int[] generateRadomArray(int size,int min,int max,Random random){
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=random.nextInt(max)+min;
        }
        return arr;
    }
    public static int Linear(int arr[],int key){
        for(int i=0;i<arr.length;i++){
            if(key==arr[i]){
                return i;
            }
        }
        return -1;
    }
    public static int Binary(int arr[],int key){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(key==arr[mid])
                return mid;
            else if(key<arr[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random random=new Random();
        System.out.println("Enter the size of the array:");
        int size=sc.nextInt();
        int arr[]=generateRadomArray(size,1,100,random);
        System.out.println("Generated Array: "+Arrays.toString(arr));
        System.out.println("Enter your choice:");
        System.out.println("1. Linear Search");
        System.out.println("2. Binary Search");
        int choice=sc.nextInt();
        Long startTime=System.nanoTime();
        switch(choice){
            case 1:
                System.out.print("Enter the element to search: ");
                int linearEle=sc.nextInt();
                int linearRes=Linear(arr,linearEle);
                if(linearRes!=-1)
                    System.out.println(linearEle+" found at index "+linearRes);
                else
                    System.out.println(linearEle+" not found in the array");
                break;
            case 2:
                Arrays.sort(arr);
                System.out.println("Sorted array: "+Arrays.toString(arr));
                System.out.print("Enter the element to search: ");
                int binaryEle=sc.nextInt();
                int binaryRes=Binary(arr,binaryEle);
                if(binaryRes!=-1)
                    System.out.println(binaryEle+" found at index "+binaryRes);
                else
                    System.out.println(binaryEle+" not found in the array");
                break;
            default:System.out.println("Invalid choice");
        }
        long endTime=System.nanoTime();
        long duration=endTime-startTime;
        System.out.println("Execution time: "+duration+" seconds");
        
    }
}



public class NQueenProblem {
    final int N = 4;

    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
    }

    boolean solveNQUtil(int board[][], int col) {
        if (col >= N)
            return true;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                if (solveNQUtil(board, col + 1))
                    return true;
                board[i][col] = 0;
            }
        }
        return false;
    }

    boolean solveNQ() {
        int board[][] = { { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 },
                          { 0, 0, 0, 0 } };
        if (!solveNQUtil(board, 0)) {
            System.out.print("Solution does not exist");
            return false;
        }
        printSolution(board);
        return true;
    }

    public static void main(String args[]) {
        NQueenProblem Queen = new NQueenProblem();
        Queen.solveNQ();
    }
}
