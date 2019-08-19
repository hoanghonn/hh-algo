/*
UNHIGHLIGHT AFTER YOU HIGHLIGHT

Given two words (beginWord and endWord), and a dictionary's word list,
find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.


Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog","hid","kit"]

Output:
[
  ["hit","hot","dot","dog","cog"],
  ["hit","hot","lot","log","cog"]
]
*/

class Solution {

	public List<List<String>> transformationPath(String beginWord, String endWord, List<String> wordList){
		List<List<String>> ret = new ArrayList<>();
		Set<String> visited = HashSet<>();
		search(ret, new ArrayList<>(), beginWord, endWord, visited, wordList);
		for(List<String> li : ret){
			li.add(0, beginWord);
			li.add(li.size()-1, endWord);
		}
		return ret;
	}

	private void search(List<List<String>> ret, List<String> curList, String curWord, String endWord, Set<String> visited, List<String> wordList){
		if(curWord.equals(endWord) && visted.size() == curList.size()){
			List<String> li = new ArrayList<>(curList);
			ret.add(li);
		} else {
			for(String s : wordList){
				if(!visited.contains(s) && compareWords(curWord, s)){
					curList.add(s);
					visited.add(s);
					search(ret, curList, s, endWord, visited, wordList);
					visited.remove(s);
					curList.remove(curList.size()-1);
				}
			}
		}
	}

	private boolean compareWords(String w1, String w2){
		int counter = 0;
		for(int i = 0; i < w1.length(); i++){
			if(w1.charAt(i) != w2.charAt(i)){
				counter++;
				if(counter==2) return false;
			}
		}
		return true;
	}
}