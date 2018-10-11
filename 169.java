class Solution {
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> m = new HashMap<>();
		int max = 0;
		int res = 0; 
		for(int num : nums){
			m.put(num, m.getOrDefault(num, 0)+1);
		}
		for(int num : nums){
			int val = m.get(num);
			if(val > Math.floor(nums.length/2) && val > max){
				max = val;
				res = num;	
			}
		}
		return res;
	}
}
