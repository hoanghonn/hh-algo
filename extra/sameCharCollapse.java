class Solution{
	public String sameCharCollapse(String str){
		Stack<Character> s = new Stack<>();
		StringBuilder ret = new StringBuilder();
		for(int i = 0; i < str.length(); i++){
			if(s.isEmpty()){
				s.push(str.charAt(i));
			} else {
				if(s.top() == str.charAt(i)){
					while(s.top() == str.charAt(i)){
						i++;
					}
					s.pop();
					i--;					
				} else {
					s.push(str.charAt(i));
				}
			}
		}

		while(!s.isEmpty){
			ret.append(0, s.top());
		}

		return ret.toString();
	}
}