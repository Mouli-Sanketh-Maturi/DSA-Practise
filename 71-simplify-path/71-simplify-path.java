class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Stack<String> revStack = new Stack<>();
        String canPath = "";
        String [] arr = path.split("/",0);
        for(String dir : arr){
            if(dir.equals("..")){
                if(!stack.isEmpty())
                    stack.pop();
            } else if (dir.equals(".") || dir.equals("/") || dir.isBlank()){
                // do nothing
            } else {
                stack.push(dir);
            }
        }
        while(!stack.empty()){
            revStack.push(stack.pop());
        }
        while(!revStack.empty()){
            canPath = canPath.concat("/"+revStack.pop());
        }
        if(canPath.isEmpty()){
            return "/";
        }
        return canPath;
    }
}