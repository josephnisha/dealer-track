package interview;

class Palindrome {

    boolean isPalindrome(String text) {
        if (text == null || text.trim().isEmpty()) {
            return false;
        }
        boolean isPalindrome = true;
        int lengthOfText = text.length();
        int leftCharIndex = 0;
        int rightCharIndex = lengthOfText - 1;

        while (leftCharIndex < lengthOfText && rightCharIndex > -1 && leftCharIndex < rightCharIndex) {

            leftCharIndex = getLeftCharIndex(text, lengthOfText, leftCharIndex);
            rightCharIndex = getRightCharIndex(text, rightCharIndex);
            if (getAChar(text, leftCharIndex) != getAChar(text, rightCharIndex)) {
                isPalindrome = false;
                break;
            }

            leftCharIndex++;
            rightCharIndex--;
        }
        return isPalindrome;
    }

    private int getRightCharIndex(String text, int rightCharIndex) {
        while (rightCharIndex > 1) {
            boolean alpha = isAlphaNumeric(text.charAt(rightCharIndex));
            if (alpha) {
                break;
            }
            rightCharIndex--;

        }
        return rightCharIndex;
    }

    private int getLeftCharIndex(String text, int lengthOfText, int leftCharIndex) {
        while (leftCharIndex < (lengthOfText -1)) {
            boolean alpha = isAlphaNumeric(text.charAt(leftCharIndex));
            if (alpha) {
                break;
            }
            leftCharIndex++;
        }
        return leftCharIndex;
    }

    private char getAChar(String text, int leftCharIndex) {
        return Character.toLowerCase(text.charAt(leftCharIndex));
    }

    boolean isAlphaNumeric(char character) {
        return Character.isLetterOrDigit(character);
    }
}
