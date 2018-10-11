class Solution {
	public boolean isOneBitCharacter(int[] bits) {
		boolean check = false;
		for(int i = 0; i < bits.length; i++){
			if(bits[i] == 1){
				if(check == false){
					check = true;
				} else {
					check = false;
				}
			} else {
				if(check == false){
					if(i == bits.length-1){
						return true;
					} else {
						continue;
					}
				} else {
					check = false;
				}
			}
		}	
		return false;
	}
}
