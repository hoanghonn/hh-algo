class Solution {
	public boolean isMonotonic(int[] A) {
		int last_diff = 0;

		for(int i = 1; i < A.length; i++){
			int curr_diff = A[i] - A[i-1];
			if(curr_diff != 0 && last_diff != 0 && curr_diff*last_diff < 0){
				return false;
			}	
			if(curr_diff != 0){
				last_diff = curr_diff;
			}
		}
		return true;
	}
}
