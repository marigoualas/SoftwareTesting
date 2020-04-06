package st1920.automaton;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import st1920.automaton.Automaton;
import st1920.automaton.MatchString;
import st1920.automaton.REstring;
import st1920.automaton.RegExpMatcher;

public class Task3_2 {

    @Test
    public void test1() {
        MatchString s1 = RegExpMatcher.makeEmpty();
        REstring s2 = new REstring(RegExpMatcher.makeEmpty().getString());
        assertTrue(RegExpMatcher.matches(s1, s2));
    }

    @Test
    public void test2() {
        /*
         * MatchString s1 = RegExpMatcher.make2(); MatchString s2 =
         * RegExpMatcher.make5(); MatchString s3 = RegExpMatcher.make5(); MatchString
         * final0 = RegExpMatcher.makeConcatenation(s1, s2); MatchString final1 =
         * RegExpMatcher.makeConcatenation(final0, s3); MatchString s4 =
         * RegExpMatcher.make0(); MatchString s5 = RegExpMatcher.make1(); MatchString s6
         * = RegExpMatcher.makeConcatenation(s5, s4); MatchString s7 =
         * RegExpMatcher.makeConcatenation(s4, s4); MatchString s8 =
         * RegExpMatcher.makeConcatenation(s6, s7); REstring s9 =
         * RegExpMatcher.makeRange(s4, s8); assertFalse(RegExpMatcher.matches(final1,
         * s9));
         */
        assertTrue(RegExpMatcher.matches(new MatchString("255"), new REstring("<1-1000>")));
    }

    @Test
    public void test3() {
        assertTrue(RegExpMatcher.matches(new MatchString("0"), new REstring("<0-10>")));
    }

    @Test
    public void test4() {
        assertFalse(RegExpMatcher.matches(new MatchString("marios"), new REstring("marios & me")));
    }

    @Test
    public void test5() {
        assertTrue(RegExpMatcher.matches(new MatchString("aaaaaaa"), new REstring("a{7}")));
    }

    @Test
    public void test6() {
        assertTrue(RegExpMatcher.matches(new MatchString("aaaaaaaaaa"), new REstring("a{7,15}")));
    }

    @Test
    public void test7() {
        assertFalse(RegExpMatcher.matches(new MatchString("z"), new REstring("[a-d]*")));
    }

    @Test
    public void test9() {
        assertTrue(RegExpMatcher.matches(new MatchString("LaurelAquino"), new REstring("[a-zA-Z]{1,20}")));
    }

    @Test
    public void test8() {
        assertTrue(RegExpMatcher.matches(new MatchString("Hello my name is Laurel and bug 4 is here."),
                new REstring("Hello my name is Laurel and bug 4 is here.")));
    }

    @Test
    public void test10() {
        assertFalse(RegExpMatcher.matches(new MatchString("abc"), new REstring("[z-a]")));
    }

    @Test
    public void test11() {
        assertTrue(RegExpMatcher.matches(new MatchString("99999999"), new REstring("<0-999999999>")));
    }

    @Test
    public void test12() {
        assertFalse(RegExpMatcher.matches(new MatchString("((a))"), new REstring("(([a-z]))")));
    }

    @Test
    public void test13() {
        try {
            assertTrue(RegExpMatcher.matches(new MatchString("marios@gmail.com"),
                    new REstring("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$\"")));
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void test14() {
        assertTrue(RegExpMatcher.matches(new MatchString("foo@bar.co.uk"),
                new REstring("([a-zA-Z0-9])+\\@([a-zA-Z0-9])+\\.([a-z.]){2,}")));
    }

    @Test
    public void test15() {
        assertTrue(RegExpMatcher.matches("", ""));
    }

    @Test
    public void test16() {
        try {
            assertFalse(RegExpMatcher.matches(new MatchString("bbbbbbcccc"), new REstring("******")));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Test
    public void test17() {
        try {
            assertTrue(RegExpMatcher.matches(new MatchString("2555"), new REstring("<5-10000")));
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void test18() {
        try {
            assertTrue(RegExpMatcher.matches(new MatchString("marios"), new REstring("([a-z]*")));
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void test19() {
        try {
            assertTrue(RegExpMatcher.matches(new MatchString("marios"), new REstring("[a-")));
        } catch (Exception e) {

        }

    }
    
    @Test
    public void test20() {
        try {
            assertTrue(RegExpMatcher.matches(new MatchString("5"), new REstring("<1--10->")));
        } catch (Exception e) {
            
        }
    }
    
    @Test
    public void test21() {
        try {
            assertTrue(RegExpMatcher.matches(new MatchString("55"), new REstring("<100-1>")));
        } catch (Exception e) {
            
        }
    }
    
    @Test
    public void test22() {
        try {
            assertFalse(RegExpMatcher.matches(new MatchString("string"), new REstring("[z-a]+")));
        } catch (Exception e) {
            
        }
    }
    
    @Test
    public void test23() {
        try {
            assertTrue(RegExpMatcher.matches(new MatchString("5"), new REstring("<1>")));
        } catch (Exception e) {
            
        }
    }
    
    @Test
    public void test24() {
        try {
            assertTrue(RegExpMatcher.matches(new MatchString("aaaa"), new REstring("a{5")));
        } catch (Exception e) {
            
        }
    }
    
    @Test
    public void test25() {
        try {
            assertFalse(RegExpMatcher.matches(new MatchString("aaaaa"), new REstring("a{6,1}")));
        } catch (Exception e) {
            
        }
    }
    
    @Test
    public void test26() {
        try {
            assertFalse(RegExpMatcher.matches(new MatchString("aaaaa"), new REstring("a{10}")));
        } catch (Exception e) {
            
        }
    }
    
    @Test
    public void test27() {
        try {
            assertTrue(RegExpMatcher.matches(new MatchString("marios"), new REstring("marios|me|you|")));
        } catch (Exception e) {
            
        }
    }
    
    @Test
    public void test28() {
        //try {
            assertTrue(RegExpMatcher.matches(new MatchString("15"), new REstring("<10-25>")));
        //} catch (Exception e){
            
        }
    //}
    
}
