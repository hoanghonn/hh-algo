class Solution {
	public int[][] imageSmoother(int[][] M) {
		int[][] res = new int[M.length][M[0].length];
		
		for(int i = 0; i < M.length; i++){
			for(int j = 0; j < M[0].length; j++){
				int count = 0;
				int sum = 0;
				for(int sr = i - 1; sr <= i+1; sr++){
					for(int sc = j-1; sc <= j+1; sc++){
						if(sr>= 0 && sr<M.length && sc >= 0 && sc < M[0].length){
							count++;
							sum += M[sr][sc];
						}
					}
				}
				res[i][j] = sum/count;
			}
		}	
		return res;
	}
}
