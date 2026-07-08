class Solution {
    public int reverse(int x) {
        long ans = 0;
        int cnt = 0;
        if (x == Integer.MIN_VALUE) return 0;
        if(x < 0) {
            x = x * (-1);
            cnt++;
        }    
        while(x > 0) {
            int num = x % 10;
            ans = ans * 10 + num;
            x /= 10;
        }
        if(cnt > 0) ans = -ans;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE)
            return 0;

        return (int) ans;
    }
}