package jdag.structures.stack;


import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListStackImplTest
{


    /**
     * Same read left to right, ignore punctuation
     */
    @Test public void isPalindrome () {
        String test1 = "racecar";
        String test2 = "Not a palindrome";
        String test3 = "I did, did I?";
        String test4 = "Don't nod?";
        assertTrue (palindromeTesT (test1));
        assertFalse (palindromeTesT (test2));
        assertTrue (palindromeTesT (test3));
        assertTrue (palindromeTesT (test4));
    }

    static private boolean palindromeTesT (final String string) {
        ListStackImpl<Character> stack = new ListStackImpl<> ();

        StringBuilder stringNoPunctuation = new StringBuilder (string.length ());
        String lowerCase = string.toLowerCase (Locale.ROOT);

        for (int i = 0; i < lowerCase.length (); i++) {
            char c = lowerCase.charAt (i);
            if (c >= 'a' && c <= 'z') {
                stringNoPunctuation.append (c);
                stack.push (c);
            }
        }

        StringBuilder reverseString = new StringBuilder (stack.size ());
        while (!stack.isEmpty ()) {
            reverseString.append (stack.pop ());
        }
        return (reverseString.toString ().equals (stringNoPunctuation.toString ()));
    }
}