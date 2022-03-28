public class Palindrome {

    public Boolean isPalindrome(String input) {
        int inputSize = input.length();

        if (inputSize < 2) {
            return true;
        }


        if (input.charAt(0) == input.charAt(inputSize - 1)) {
            return isPalindrome(input.substring(1, inputSize - 1));
        } else {
            return false;
        }

    }
    public static void main(String[] args) throws Exception {
        Palindrome palindrome = new Palindrome();

        if (palindrome.isPalindrome("racecar")) System.out.println("Palindrome!");
        else System.out.println("Not a palindrome!");
    }
}
