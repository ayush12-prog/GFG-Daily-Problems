from heapq import heappop, heappush
class Solution:
    def maxAmount(self, arr, k):
        # Sam
        mod = 10**9 + 7
        result = 0
        dq = []
        for i in arr:
            heappush(dq,-i)
        for _ in range(k):
            num = heappop(dq)
            if num>=0:
                return (-result)%mod
            result = (result+num)%mod
            # print(dq)
            heappush(dq,(num + 1))
        return (-result)%mod