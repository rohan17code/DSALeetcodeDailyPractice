class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int pro = 1;
        int m = n;
        while(m > 0) {
            sum += m % 10;    
            m /= 10;
        }
        m = n;
        while(m > 0) {
            pro *= m % 10;   
            m /= 10;
        }
        return n % (sum + pro) == 0;
    }
}