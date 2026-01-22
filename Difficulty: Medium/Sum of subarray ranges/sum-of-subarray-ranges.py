class Solution:
    def subarrayRanges(self, arr):
        n = len(arr)
        prev_less = [-1] * n
        next_less = [n] * n
        prev_greater = [-1] * n
        next_greater = [n] * n
        
        stack = []
        for i in range(n):
            while stack and arr[stack[-1]] > arr[i]:
                next_less[stack.pop()] = i
            if stack:
                prev_less[i] = stack[-1]
            stack.append(i)
            
        stack = []
        for i in range(n):
            while stack and arr[stack[-1]] < arr[i]:
                next_greater[stack.pop()] = i
            if stack:
                prev_greater[i] = stack[-1]
            stack.append(i)
            
        sum_max = 0
        sum_min = 0
        
        for i in range(n):
            left_min = i - prev_less[i]
            right_min = next_less[i] - i
            left_max = i - prev_greater[i]
            right_max = next_greater[i] - i
            
            sum_min += left_min * right_min * arr[i]
            sum_max += left_max * right_max * arr[i]
            
        return int(sum_max - sum_min)