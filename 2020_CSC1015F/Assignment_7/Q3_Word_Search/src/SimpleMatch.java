public class SimpleMatch {
    public boolean doesMatch(String pattern, String word) {
        if (pattern.length() != word.length()) {
            return false;
        }

        if (pattern.length() == 0 && pattern.length() == 0) {
            return true;
        }

        if (pattern.charAt(0) == word.charAt(0) || pattern.charAt(0) == '?') {
            if (pattern.length() != 1) {
                return doesMatch(pattern.substring(1), word.substring(1));
            }

            return true;

        }

        else {
            return false;
        }
    }

}
