
/*
 * Carter Struck
 */
import java.util.Arrays;
import java.util.Scanner;

public class CMSC401_A4 {

    public static int minCutCost(int length, int[] cuts, int L) {
        int n = cuts.length;
        int[] positions = new int[n + 2];
        positions[0] = 0;
        positions[n + 1] = length;
        System.arraycopy(cuts, 0, positions, 1, n);
        Arrays.sort(positions);

        int[][] rodDPArr = new int[n + 2][n + 2];

        for (int l = 2; l < n + 2; l++) {
            for (int i = 0; i + l < n + 2; i++) {
                int j = i + l;
                rodDPArr[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int segmentCost = rodPrice(positions[j] - positions[i], L);
                    rodDPArr[i][j] = Math.min(rodDPArr[i][j],
                            rodDPArr[i][k] + rodDPArr[k][j] + segmentCost);
                }
            }
        }

        return rodDPArr[0][n + 1];
    }

    public static int rodPrice(int rodLength, int priceL) {
        return (rodLength + priceL - 1) / priceL;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rodLength = scanner.nextInt();
        int L = scanner.nextInt();

        int markingPoints = scanner.nextInt();

        int[] cuts = new int[markingPoints];

        for (int i = 0; i < markingPoints; i++) {
            cuts[i] = scanner.nextInt();
        }
        System.out.println(cuts.length);

        int minCost = minCutCost(rodLength, cuts, L);
        System.out.println(minCost);
    }
}