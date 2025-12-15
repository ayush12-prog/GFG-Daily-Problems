class Solution {
  public:
    int cntWays(vector<int>& arr) {
        // code here
        int n = arr.size();
        
        int ans=0;
        
        if (n==1) return 1;
        
        int even=0, odd=0;
        
        for (int i=0; i<n; i++) {
            if (i%2) odd+=arr[i];
            else even+=arr[i];
        }
        
        int evenSuffx=0, oddSuffx=0;
        
        for (int i=n-1; i>=0; i--) {
            int evenSum = even-evenSuffx+oddSuffx;
            int oddSum = odd-oddSuffx+evenSuffx;
            
            if (i%2) {
                oddSuffx += arr[i];
                oddSum -= arr[i];
            }
            else {
                evenSuffx += arr[i];
                evenSum -= arr[i];
            }
            
            if (evenSum==oddSum) ans++;
        }
        
        return ans;
    }
};