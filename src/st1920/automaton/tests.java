package st1920.automaton;

import static org.junit.Assert.*;

import org.junit.Test;

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
        assertFalse(reg.matches("Hello my name is Laurel and bug 4 is here.",
                "Hello my name is Laurel and bug 4 is here."));
    }

    @Test
    public void m5() {
        assertTrue(reg.matches("abc", "[z-a]"));
    }

    @Test
    public void m6() {
        assertTrue(reg.matches(
                "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb",
                "b{5,}"));
    }

    @Test
    public void m7() {
        assertTrue(reg.matches("LaurelAquino", "[a-zA-Z]{1-20}"));
    }

    @Test
    public void m8() {
        assertTrue(reg.matches("bbbbbbcccc", "******"));
    }

    @Test
    public void m9() {
        assertTrue(reg.matches("99999999999999999", "<0-999999999999999991>"));
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
        assertTrue(reg.matches("((a))", "(([a-z]))"));
    }

    @Test
    public void m13() {
        assertTrue(reg.matches("()()()", "()()()"));
    }

    @Test
    public void m14() {
        assertTrue(reg.matches("c", "[]"));
    }

    @Test
    public void m15() {
        assertTrue(reg.matches("c", "[^a]"));
    }

}
