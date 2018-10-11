class Solution {
	public int[] fairCandySwap(int[] A, int[] B) {
		int sumA = 0;
		int sumB = 0;
		for(int i : A){
			sumA += i;
		}
		for(int i : B){
			sumB += i;
		}
		int diff = sumA - sumB;
		int[] res = new int[2]; 	
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < B.length; j++){
				if(sumA-A[i]+B[j] == sumB-B[j]+A[i]){
					res[0] = A[i];
					res[1] = B[j];	
				}	
			}
		}
		return res;
	}
}
