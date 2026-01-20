class Solution {
    private StringBuilder doc = new StringBuilder();
    private Stack<Character> redoStack = new Stack<>();

    public void append(char x) {
        doc.append(x);
        redoStack.clear();
    }

    public void undo() {
        if (doc.length() > 0) {
            char removed = doc.charAt(doc.length() - 1);
            doc.deleteCharAt(doc.length() - 1);
            redoStack.push(removed);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            char restore = redoStack.pop();
            doc.append(restore);
        }
    }

    public String read() {
        return doc.toString();
    }
}