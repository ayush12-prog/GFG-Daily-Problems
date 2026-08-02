class Solution {
  public:
    int count(int n, int m) {
        // code here
        vector<int>curr(m+1 , 0) , next(m+1 , 0);
        for(int i = 1 ; i<=m ; i++)curr[i]=1;
        for(int i =1 ; i<n ; i++){
            for(int i = 1 ; i<=m ; i++)next[i] = 0;
            for(int j = 1 ; j<=m ; j++){
                next[j] += curr[j]; 
                for(int k = j*2 ; k<=m ; k+=j){
                    next[k]+= curr[j];
                    next[j]+= curr[k];
                }
            }
            swap(curr , next);
        }
        return accumulate(curr.begin() , curr.end() , 0);
    }
};