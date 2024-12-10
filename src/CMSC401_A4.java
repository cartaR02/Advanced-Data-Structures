
import java.util.Arrays;

public class CMSC401_A4 {

    public static int minCutCost(int length, int[] cuts) {
        int n = cuts.length;
        int[] positions = new int[n + 2];
        positions[0] = 0;
        positions[n + 1] = length;
        System.arraycopy(cuts, 0, positions, 1, n);
        Arrays.sort(positions);

        int[][] dp = new int[n + 2][n + 2];

        for (int l = 2; l < n + 2; l++) {
            for (int i = 0; i + l < n + 2; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + (positions[j] - positions[i]));
                }
            }
        }

        return dp[0][n + 1];
    }

    public static void main(String[] args) {

        int rodLength = 10;
        int[] cuts = { 3, 5, 6 };

        int minCost = minCutCost(rodLength, cuts);
        System.out.println(minCost);
    }
}