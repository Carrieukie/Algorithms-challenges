import java.util.Arrays;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * <p>
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * <p>
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 * <p>
 * Return the modified image after performing the flood fill.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 * Example 2:
 * <p>
 * Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, newColor = 2
 * Output: [[2,2,2],[2,2,2]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * m == image.length
 * n == image[i].length
 * 1 <= m, n <= 50
 * 0 <= image[i][j], newColor < 216
 * 0 <= sr < m
 * 0 <= sc < n
 */
public class FloodFill {


    public static void main(String[] args) {
        int[][] arr = {{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(Arrays.deepToString(floodFill(arr, 0, 0, 4)));
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) return image;

        int oldColor = image[sr][sc];
        floodFill(image, sr, sc, oldColor, newColor);
        return image;
    }

    public static void floodFill(int[][] image, int i, int j, int oldColor, int newColor) {
        // if 'i' or 'j' is not valid or image[i][j] is not the currColor, then just return
        if(i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor) return;


        image[i][j] = newColor;
        
        floodFill(image, i + 1, j, oldColor, newColor);
        floodFill(image, i - 1, j, oldColor, newColor);
        floodFill(image, i, j + 1, oldColor, newColor);
        floodFill(image, i, j - 1, oldColor, newColor);

    }

}
