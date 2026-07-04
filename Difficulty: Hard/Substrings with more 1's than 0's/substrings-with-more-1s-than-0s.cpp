class Solution {
  public:
    int countSubstring(string& s) {
        // Code Here
        int count = 0;
        // unordered_map<int,int>mp1 , mp2;
        vector<int>mp1(s.size()*2+5 , 0) , mp2(s.size() *2 + 5);
        int ans = 0;
        int m = s.size();
        mp1[m] = 1;
        mp2[m] = 1;
        for(auto i: s){
            if(i == '1')count++;
            else count--;
            mp1[count +m ]++;
            mp2[count +m] = mp1[count + m] + mp2[m +count-1];
            ans+= mp2[m + count-1];
        }
        return ans;
    }
};