class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
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
        for(String dir: stack){
            canPath = canPath.concat("/"+dir);
        }
        if(canPath.isEmpty()){
            return "/";
        }
        return canPath;
    }
}