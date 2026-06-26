class Solution {
    public int clumsy(int n) {
        Stack<Integer> s = new Stack<>();
        s.push(n);
        int operation = 0;  // 0-> *, 1-> /, 2-> +, 3-> -
        for(int i = n-1; i>=1; i--) {
            if(operation == 0) {
                s.push(s.pop() * i);
            } else if(operation == 1) {
                s.push(s.pop() / i);
            } else if(operation == 2) {
                s.push(i);
            } else {
                s.push(-i);
            }
            operation = (operation + 1) % 4;    // (0+1)%4 = 1, (1+1)%4=2...
        }
        int ans = 0;
        while(!s.isEmpty()) {
            ans += s.pop();
        }
        return ans;
    }
}


// if operation 0 and 1 hai which is * and / then stack me operation ke sath add krnege like after doing * and / BUT if operation is + and - then directly number ko push krnege stack me .... 
// * and / hmehsa phle solve hote hai isley humne yhe dono operation stack me push krne se phle hi kiye 
// and + and - badd me 