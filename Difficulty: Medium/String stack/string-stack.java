class Solution {
    public boolean stringStack(String pat, String tar) {
        List<List<List<Integer>>> positions = new ArrayList<>(26);
        for (int i = 0; i < 26; i++) {
            List<List<Integer>> parityLists = new ArrayList<>(2);
            parityLists.add(new ArrayList<>());
            parityLists.add(new ArrayList<>());
            positions.add(parityLists);
        }

        for (int i = 0; i < pat.length(); i++) {
            int charCode = pat.charAt(i) - 'a';
            int parity = i % 2;
            positions.get(charCode).get(parity).add(i);
        }

        int lastEvenIdx = -1;
        int lastOddIdx = -1;

        for (int i = 0; i < tar.length(); i++) {
            int charCode = tar.charAt(i) - 'a';
            int nextEvenIdx = Integer.MAX_VALUE;
            int nextOddIdx = Integer.MAX_VALUE;

            if (lastOddIdx != -1) {
                List<Integer> evenIndices = positions.get(charCode).get(0);
                int searchResult = findFirstGreaterThan(evenIndices, lastOddIdx);
                if (searchResult != -1) {
                    nextEvenIdx = searchResult;
                }
            }
            if (i == 0) {
                 List<Integer> evenIndices = positions.get(charCode).get(0);
                 if(!evenIndices.isEmpty()){
                    nextEvenIdx = Math.min(nextEvenIdx, evenIndices.get(0));
                 }
            }

            if (lastEvenIdx != -1) {
                List<Integer> oddIndices = positions.get(charCode).get(1);
                int searchResult = findFirstGreaterThan(oddIndices, lastEvenIdx);
                if (searchResult != -1) {
                    nextOddIdx = searchResult;
                }
            }
            if(i == 0){
                List<Integer> oddIndices = positions.get(charCode).get(1);
                if(!oddIndices.isEmpty()){
                     nextOddIdx = Math.min(nextOddIdx, oddIndices.get(0));
                }
            }

            lastEvenIdx = (nextEvenIdx == Integer.MAX_VALUE) ? -1 : nextEvenIdx;
            lastOddIdx = (nextOddIdx == Integer.MAX_VALUE) ? -1 : nextOddIdx;

            if(lastEvenIdx == -1 && lastOddIdx == -1){
                return false;
            }
        }

        int patEndParity = (pat.length() - 1) % 2;

        if (lastEvenIdx != -1 && patEndParity == 0) {
            return true;
        }
        if (lastOddIdx != -1 && patEndParity == 1) {
            return true;
        }

        return false;
    }

    private int findFirstGreaterThan(List<Integer> list, int value) {
        int result = Collections.binarySearch(list, value + 1);
        if (result < 0) {
            result = -result - 1;
        }
        if (result >= list.size()) {
            return -1;
        }
        return list.get(result);
    }
}
