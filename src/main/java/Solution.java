import java.util.Arrays;

public class Solution {
    static int[] usedIdx;
    public static boolean isUsed(int n){
        for(int idx : usedIdx){
            if(idx == n){
                return true;
            }
        }
        return false;
    }
    public static int solution(int []A, int []B) {
        int answer = 0;
        int aLen = A.length;
        int bLen = B.length;
        usedIdx = new int[bLen];
        Arrays.fill(usedIdx, -1);

        for(int i = 0; i < aLen; i++){
            int a = A[i];
            int min = Integer.MIN_VALUE;
            int idx = 0;
            int mul = 0;

            for(int j = 0; j < bLen; j++){
                if(isUsed(j)) continue;
                int b = B[j];
                mul = a * b;
                if(mul >= min){
                    System.out.println("a = " + a + " b = " + b);
                    idx = j;
                    min = mul;
                }
            }
            usedIdx[i] = idx;
            System.out.println(Arrays.toString(usedIdx));
            answer += min;
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] A = {1, 4, 2};
        int[] B = {5, 4, 4};
        System.out.println("'29' == " + solution(A, B));

        A = new int[]{1, 2};
        B = new int[]{3, 4};
        System.out.println("'10' == " + solution(A, B));
    }
}
