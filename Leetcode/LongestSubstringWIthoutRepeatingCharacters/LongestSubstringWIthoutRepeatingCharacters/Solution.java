package LongestSubstringWIthoutRepeatingCharacters;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
    	/*if(s == null)
    		return 0;
    	int max = 0;
        for(int i = 0; i < s.length(); i++){
        	int lenNonReSub = getNonReSubLen(s, i);
        	if(lenNonReSub > max)
        		max = lenNonReSub;
        }
        return max;*/
    	
    	//O(n) using two pointers and hashmap
    	Map<Character,Integer> map = new HashMap<Character,Integer>();
    	int max = 0;
    	
    	for(int i = 0,j=0; i < s.length(); i++){
    		if(map.containsKey(s.charAt(i)))
    			j = Math.max(j, map.get(s.charAt(i))+1);
    		map.put(s.charAt(i), i);
    		max = Math.max(max, i - j + 1);
    	}
    	return max;
    }
    @SuppressWarnings("unused")
	private int getNonReSubLen(String str, int index){
    	Set<Character> set = new HashSet<Character>();
    	for(int i = index; i < str.length(); i++){
    		if(!set.add(str.charAt(i)))
    			return i - index;
    		if(i == str.length() - 1)
    			return i - index + 1;
    	}
    	return 0;
    }
    public static void main(String[] args){
//    	String str = null;
//    	String str = "abc";
    	String[] str = {"abcabcbb","bbbbb","pwwkew"};
    	for(int i = 0; i < str.length; i++)
    		System.out.println(new Solution().lengthOfLongestSubstring(str[i]));
    }
}
