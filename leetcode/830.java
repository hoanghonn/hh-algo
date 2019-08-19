class Solution {
	public List<List<Integer>> largeGroupPositions(String S) {
		int start_num = 0;
		int count = 0;
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = 0; i < S.length(); i++){
			if(S.charAt(i) == S.charAt(start_num)){
				count++;
			}	else {
				count = 1;
				start_num = i;
			}

			if(i+1 == S.length() || S.charAt(i+1) != S.charAt(start_num)){
				if(count >= 3){
					List<Integer> temp_list = new ArrayList<>();
					temp_list.add(start_num);
					temp_list.add(start_num + count-1);
					res.add(temp_list);
				}
			}
		}
		return res;		
	}
}
