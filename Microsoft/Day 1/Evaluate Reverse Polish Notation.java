// Problem : Evaluate Reverse Polish Notation

// Input/Output:
// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9


// Approach:
// Using Stack Data Structure we can solve this Problem if it is val then push in stack and when sign comes pop top two values from stack and perfom the operation accordingly

// Code:

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        int i=0;
        int n = tokens.length;
        while(i<n){
            if(st.isEmpty()) st.push(tokens[i]);
            else if(!st.isEmpty() && (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/"))){
                int val2 = Integer.valueOf(st.pop());
                int val1 = Integer.valueOf(st.pop());
                if(tokens[i].equals("+")){
                    st.push((val1+val2)+"");
                }
                else if(tokens[i].equals("-")){
                    st.push((val1-val2)+"");
                }
                else if(tokens[i].equals("*")){
                   st.push((val1*val2)+"");
                }
                else if(tokens[i].equals("/")){
                    st.push((val1/val2)+"");
                }
            }
            else{
                    st.push(tokens[i]);
            }
            // System.out.println(st);
            i++;
        }
        return Integer.valueOf(st.pop());
    }
}

// Time Complexity - O(n)
// Space Complexity - O(n)
