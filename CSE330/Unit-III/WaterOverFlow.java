/*
Water Overflow
There is a stack of water glasses in the form of a Pascal triangle and a person wants to pour the water at the topmost glass, but the capacity of each glass is 1 unit. Overflow takes place in such a way that after 1 unit, 1/2 of the remaining unit gets into the bottom left glass and the other half in the bottom right glass. Now John pours K units of water in the topmost glass and wants to know how much water is there in the Cth glass of the Rth row.

Note: Assume that there are enough glasses in the triangle till no glass overflows.

Example 1:
Input:
K = 3, R = 2, C = 1
Output:
1.000000
Explanation:
After the first glass, 2 units of water
will remain and they will spread equally
on the two glasses on the second row.
Therefore, the glass on the 2nd row and
1st column will have 1 unit of water.

Example 2:
Input:
K = 3, R = 2, C = 2
Output:
1.000000
Explanation:
After the first glass, 2 units of water
will remain and they will spread equally
on the two glasses on the second row.
Therefore, the glass on the 2nd row and
2nd column will have 1 unit of water.
 
Your Task:
You don't need to read input or print anything. Your task is to complete the function waterOverflow() which takes 3 Integers K, R, and C as input and returns the amount of water(6 digits of precision) in the Cth glass of Rth row.

Constraints:
1 <= K <= 500
1 <= R,C <= K 
*/
public class WaterOverFlow {
    public static double waterOverflow(int K, int R, int C) {
        double[][] glasses = new double[K + 1][K + 1];
        glasses[1][1] = K; 

        for (int row = 1; row <= K; row++) {
            for (int col = 1; col <= row; col++) {
                if (glasses[row][col] > 1.0) { 
                    double excess = glasses[row][col] - 1.0;
                    glasses[row][col] = 1.0; 
                    glasses[row + 1][col] += excess / 2.0;
                    glasses[row + 1][col + 1] += excess / 2.0;
                }
            }
        }
        return Math.min(1.0, glasses[R][C]); 
    }
    public static void main(String[] args) {
        System.out.println(waterOverflow(3, 2, 1));
        System.out.println(waterOverflow(3, 2, 2));
    }
}
