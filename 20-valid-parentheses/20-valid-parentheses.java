class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            } else {
                if(stack.size()!=0){
                    Character open = stack.pop();
                    if(s.charAt(i) == ')'){
                        if(open != '('){
                            return false;
                        }
                    } else if(s.charAt(i) == '}'){
                        if(open != '{'){
                            return false;
                        }
                    } else if(s.charAt(i) == ']'){
                        if(open != '['){
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        if(stack.size()!=0)
            return false;
        return true;
    }
}