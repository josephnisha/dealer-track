package interview;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeTest {

    @Test
    public void testIsaPalindromeWithSpecialCharacters(){
        Palindrome palindrome = new Palindrome();
        boolean isPalindrome = palindrome.isPalindrome("I, did,,,,,,,d^&&idi@#$$");
        assertTrue(isPalindrome);
    }
    @Test
    public void testIsNotPalindrome(){
        Palindrome palindrome = new Palindrome();
        boolean isPalindrome = palindrome.isPalindrome("sadda");
        assertFalse(isPalindrome);
    }
    @Test
    public void testIsAlpha(){
        Palindrome palindrome = new Palindrome();
        boolean isAlpha = palindrome.isAlphaNumeric('s');
        assertTrue(isAlpha);
    }
    @Test
    public void testIsNotAlpha(){
        Palindrome palindrome = new Palindrome();
        boolean isAlpha = palindrome.isAlphaNumeric(',');
        assertFalse(isAlpha);
    }
}