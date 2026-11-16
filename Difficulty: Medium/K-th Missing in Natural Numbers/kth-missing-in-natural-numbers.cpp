class Solution {
  public:
    int findKthSmall(vector<int>& arr, int k) {
        // code here
        sort(arr.begin() , arr.end()) ;
        int l = 0 ;
        int  i = 1 ;
        while(k > 0){
            if(l < arr.size() && arr[l] == i){
                l++ ;
            }
            else{
                k-- ;
            }
            i++ ;
        }
        return i-1 ;
    }
};