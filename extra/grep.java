class Solution{
	public List<Integer> grep(String haystack, String needle){
		List<Integer> ret = new ArrayList<>();
		for(int i = 0; i < haystack.length(); i++){
			int j = i; 
			while(j < haystack.length() && haystack.charAt(j) == needle.charAt(j-i)){
				j++;
			}

			if(j - i == needle.length()) ret.add(i);
		}
		return ret;
	}


}