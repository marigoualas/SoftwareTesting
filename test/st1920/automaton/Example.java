package st1920.automaton;

import static org.junit.Assert.*;

import org.junit.Test;

import st1920.automaton.RegExpMatcher;

public class Example {

	@Test
	public void testExample() {
		assertTrue(
				RegExpMatcher.matches(
				"foo@bar.com",
				"([a-zA-Z0-9])+\\@([a-zA-Z0-9])+\\.([a-z]){2,3}"
				));
	}

}
