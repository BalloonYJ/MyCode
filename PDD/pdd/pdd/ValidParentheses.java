package pdd;
import java.util.*;
public class ValidParentheses {
	Map<Character,Character> map = new HashMap<Character,Character>();
	
	public ValidParentheses(){
		map.put('(',')');
		map.put('{','}');
		map.put('[',']');
		map.put(')','(');
		map.put('}','{');
		map.put(']','[');
	}
	
	public boolean isValidParentheses(String str){
		boolean hasPopped = false;//处理{}、[]情况
		Stack<Character> stk = new Stack<Character>();		
		for(int i = 0; i <str.length(); i++){	
			if(stk.isEmpty())
				hasPopped = false;
			if(isLeft(str.charAt(i))){
				if(!stk.isEmpty() && breakPriority(stk.peek(),str.charAt(i)))
					return false;
				stk.push(str.charAt(i));
			}
			else if(isRight(str.charAt(i))){
				char tmp = stk.pop();
				if(!hasPopped && tmp != '(')
					return false;
				else
					hasPopped = true;
				if(!isMatch(tmp,str.charAt(i)))
					return false;
			}
		}
		if(stk.isEmpty())
			return true;
		return false;
	}
	boolean isLeft(Character a){
		if(a == '{' || a == '[' || a == '(')
			return true;
		return false;
	}
	boolean isRight(Character a){
		if(a == '}' || a == ']' || a == ')')
			return true;
		return false;
	}
	boolean isMatch(Character a, Character b){
		if(map.get(a) == b)
			return true;
		return false;
	}
	boolean breakPriority(char old, char n){
		if(old == n && old != '{')
			return true;
		if(old < n)//ascii('(')<ascii('[')< ascii('{')
			return true;
		return false;
	}
	public static void main(String[] args){
		//String expres = "{[(2+3)*(1-3)] + 4}*(14-3)";
		//String expres = "{}";
		//String expres = "(((()))";
		String expres = "([])";
		System.out.println(new ValidParentheses().isValidParentheses(expres));
	}
}
