import java.util.Collections;
class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length; //row
        int n = m; //column
        //transpose nikalo
        for(int i = 0; i<m; i++){
            for(int j = i; j<n; j++){
               int temp = matrix[i][j];
               matrix[i][j] = matrix[j][i];
               matrix[j][i] = temp;
            }
        }
        //reverse karo
        for(int i =0; i<m; i++){
            int left = 0;
            int right = n-1;
            while(left<right){
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}