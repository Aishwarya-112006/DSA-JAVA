/*You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

 */
class Solution {
    public void rotate(int[][] matrix) {
         int n=matrix.length;
         int i=0;
         int j=0;
         int t=0;
         for (i=0;i<n;i++){
            for(j=i+1;j<n;j++){
                t=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
         }
         int l=0;
         int h=0;
         i=0;
         for (i=0;i<n;i++){
            l=0;
            h=n-1;
            while(l<=h){
                t=matrix[i][l];
                matrix[i][l]=matrix[i][h];
                matrix[i][h]=t;
                l++;
                h--;
            }
         }
        
    }
}
