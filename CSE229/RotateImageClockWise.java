/*
You have an image in form of an NxN matrics. You have to write a program to input this kind of image and rotate this image counter-clockwise direction.

For example if N is 4 and input image matrics is
I = 2 3 4 5 6 7 8 9 1 2 7 8 4 6 8 2
Then after rotation image would be
I' = 5 9 8 2 4 8 7 8 3 7 2 6 2 6 1 4

Input Format
1) First line of input consists N, the dimensions of NxN input image
2) Next N lines of input consists N space seperated integers denoting the NxN image.
Constraints
0 ≤ N
Output Format
Output will be an NxN matrics denoting image, after counter-clockwise rotation
Sample Input 0

2
2 3
4 5
Sample Output 0
3 5
2 4
Sample Input 1
3
1 2 3
4 5 6
7 8 9
Sample Output 1
3 6 9
2 5 8
1 4 7
Sample Input 2
5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
1 2 3 4 5
Sample Output 2

5 5 5 5 5
4 4 4 4 4
3 3 3 3 3
2 2 2 2 2
1 1 1 1 1
 */
public class RotateImageClockWise {
    public static void rotateCounterClockwise(int[][] matrix, int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[n - j - 1][i] = matrix[i][j];
            }
        }
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = {
            {2, 3, 4, 5},
            {6, 7, 8, 9},
            {1, 2, 7, 8},
            {4, 6, 8, 2}
        };
        rotateCounterClockwise(matrix, n);

    }
}
