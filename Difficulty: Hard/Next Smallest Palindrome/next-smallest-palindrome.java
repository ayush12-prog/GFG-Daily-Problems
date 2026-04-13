class Solution {

    public static int[] nextPalindrome(int[] num) {
        int n = num.length;

        // Step 1: Check if all digits are 9
        boolean all9 = true;
        for (int digit : num) {
            if (digit != 9) {
                all9 = false;
                break;
            }
        }

        if (all9) {
            int[] res = new int[n + 1];
            res[0] = 1;
            res[n] = 1;
            return res;
        }

        int[] res = Arrays.copyOf(num, n);

        // Step 2: Mirror left to right
        int i = 0, j = n - 1;
        while (i < j) {
            res[j] = res[i];
            i++;
            j--;
        }

        // Step 3: Check if mirrored number is greater
        boolean isGreater = false;
        for (int k = 0; k < n; k++) {
            if (res[k] > num[k]) {
                isGreater = true;
                break;
            } else if (res[k] < num[k]) {
                break;
            }
        }

        if (isGreater) return res;

        // Step 4: Increment middle and propagate carry
        int carry = 1;
        int mid = n / 2;

        if (n % 2 == 1) {
            res[mid] += carry;
            carry = res[mid] / 10;
            res[mid] %= 10;
            i = mid - 1;
            j = mid + 1;
        } else {
            i = mid - 1;
            j = mid;
        }

        // Propagate carry
        while (i >= 0 && carry > 0) {
            res[i] += carry;
            carry = res[i] / 10;
            res[i] %= 10;
            res[j] = res[i]; // mirror
            i--;
            j++;
        }

        // Final mirroring
        while (i >= 0) {
            res[j] = res[i];
            i--;
            j++;
        }

        return res;
    }

    // Driver
    public static void main(String[] args) {
        int[] num = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2};
        int[] result = nextPalindrome(num);

        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}