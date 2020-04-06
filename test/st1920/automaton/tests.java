package st1920.automaton;


import static org.junit.Assert.*;

import org.junit.Test;

import st1920.automaton.RegExpMatcher;

public class tests {
    private RegExpMatcher reg;

    @Test
    public void m1() {
        assertFalse(reg.matches("", "a+"));
    }

    @Test
    public void m2() {
        assertFalse(reg.matches("hello", ""));
    }

    @Test
    public void m3() {
        assertTrue(reg.matches("foo", "([a-zA-Z0-9])+"));
    }

    @Test
    public void m4() {
        try {
            assertTrue(reg.matches("Hello my name is Laurel and bug 4 is here.","Hello my name is Laurel and bug 4 is here."));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void m5() {
        try {
            assertFalse(reg.matches("abc", "[z-a]*"));
        } catch(Exception e) {
            System.out.println(e);
        }
    }

    @Test
    public void m6() {
        assertTrue(reg.matches(
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",
                "b{5,}"));
    }

    @Test
    public void m7() {
        try {
            assertFalse(reg.matches("LaurelAquino", "[a-zA-Z]{1-20}"));
        } catch (Exception e) {
            
        }
    } 

    @Test
    public void m8() {
        assertFalse(reg.matches("bbbbbbcccc", "******"));
    }

    @Test
    public void m9() {
        try{
            assertTrue(reg.matches("99999999999999999", "<0-999999999999999991>"));
        } catch (Exception e) {
            
        }
    }

    @Test
    public void m10() {
        for (int i = 0; i < 30000; i++) {
            assertTrue(reg.matches(Integer.toString(i), "~a"));
        }
    }

    @Test
    public void m11() {
        assertFalse(reg.matches("aaaaa", "a?"));
    }

    @Test
    public void m12() {
        assertFalse(reg.matches("((a))", "(([a-z]))"));
    }

    @Test
    public void m13() {
        assertFalse(reg.matches("()()()", "()()()"));
    }

    @Test
    public void m14() {
        try{
            assertTrue(reg.matches("c", "[]"));
        } catch (Exception e) {
            
        }
    }

    @Test
    public void m15() {
        assertTrue(reg.matches("c", "[^a]"));
    }

}
