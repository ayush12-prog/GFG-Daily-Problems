class Solution {
public:
    vector<string> findExpr(string &s, int target) {
        vector<string> result;
        backtrack(result, s, target, 0, "", 0, 0);
        return result;
    }

private:
    void backtrack(vector<string>& result, const string& s, int target,
                   int index, const string& path, long long current_val, long long last_operand) {

        if (index == s.length()) {
            if (current_val == target) {
                result.push_back(path);
            }
            return;
        }

        for (int j = index; j < s.length(); j++) {
            string current_operand_str = s.substr(index, j - index + 1);
            if (current_operand_str.length() > 1 && current_operand_str[0] == '0') {
                break;
            }

            long long current_operand_val = stoll(current_operand_str);

            if (index == 0) {
                backtrack(result, s, target, j + 1, current_operand_str, current_operand_val, current_operand_val);
            } else {
                backtrack(result, s, target, j + 1, path + "+" + current_operand_str,
                          current_val + current_operand_val,
                          current_operand_val);
                
                backtrack(result, s, target, j + 1, path + "-" + current_operand_str,
                          current_val - current_operand_val,
                          -current_operand_val);

                backtrack(result, s, target, j + 1, path + "*" + current_operand_str,
                          (current_val - last_operand) + (last_operand * current_operand_val),
                          last_operand * current_operand_val);
            }
        }
    }
};
