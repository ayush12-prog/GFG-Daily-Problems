class Solution {
public:

int bitonic(vector<int> &arr) {
    const int size = arr.size();
    
    // Edge Case
    if(size == 1) {
        return 1;
    }
    
    int ans = 1;
    int i = 0;
    int j = 1;
    // Arrays current same increasing/same or decreasing
    bool inc = (arr[j] >= arr[i]);
    int same = -1;
    
    // Two-Pointers
    while(j < size) {
        // Increasing
        if(inc) {
            if(arr[j-1] > arr[j]) {
                inc = false;
            }
        }
        else {
            // First Time
            if(same == -1 && arr[j-1] == arr[j]) {
                same = j-1;
            }
            // Reset same for different no.
            else if(same != -1 && arr[j-1] > arr[j]) {
                same = -1;
            }
            // Either stop at j-1 as it is increasing or last same
            else if(arr[j-1] < arr[j]) {
                ans = max(ans, j-i);
                i = (same != -1) ? same : j-1;
                same = -1;
                inc = true;
            }
        }
        
        j++;
    }
    
    // Last Window
    ans = max(ans, j-i);
    
    return ans;
}

};