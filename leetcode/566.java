class Solution {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if(r*c == nums.length*nums[0].length){
			int[][] res = new int[r][c];
			int a = 0;
			int b = 0;
			for(int i = 0; i < nums.length; i++){
				for(int j = 0; j < nums[0].length; j++){
					res[a][b] = nums[i][j];
					if(b ==	c-1){
						b = 0;
						a++;
					} else {
						b++;
					}
				}
			}
			return res;			
		} else {
			return nums;
		} 
	}
}
