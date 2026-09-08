class Solution {
  public:
    int closestNumber(int m, int n) {
        // code here
        int ans;
        int minus=0;
        if(m<0||n<0){
            if(m<0) minus=1;
            if(m<0) m=m*-1;
            if(n<0) n=n*-1;

        }

        if(m>=n){
            if(m==n){
                ans= m;
            }
            if(n>m){
                return 0;
            }
        }

        int rem=m%n;
        if(rem>=n/2){
            ans=m+n-rem;
        }
        else ans=m-rem;

        if(minus) return -ans;
        else return ans;
    }
};