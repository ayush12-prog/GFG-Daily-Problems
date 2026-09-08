class Solution {
  public:
    int nthFibonacci(int n) {
        // code here
        return (int)round( (pow((1 + sqrt(5))/2,n)-pow((1 - sqrt(5))/2,n))/sqrt(5));
    }
};