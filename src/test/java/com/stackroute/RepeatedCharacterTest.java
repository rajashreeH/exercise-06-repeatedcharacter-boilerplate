package com.stackroute;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.stackroute.RepeatedCharacter;

@RunWith(Parameterized.class)
public class RepeatedCharacterTest {
	private static final String MSG_01 = "The method should return the most repeated character from the input string. If more than one character is repeated same number of times, return the smallest one";
	private static final String MSG_02 = "Method should display \'No characters repeated\' for Null, Empty string or if no characters are repeated";

	private String input;
	private String expected;
	private String message;

	public RepeatedCharacterTest(String input, String expected, String message) {
		super();
		this.input = input;
		this.expected = expected;
		this.message = message;
	}
	
	@Parameters(name = "{index}: findRepeatedCharacter({0}) - Should Return ({1})")
	public static Collection<Object[]> data() {
		Collection<Object[]> params = new ArrayList<>();
		params.add(new Object[] { "repeated", 'e', MSG_01 });
		params.add(new Object[] { "repeated characters", 'e', MSG_01 });
		params.add(new Object[] { "statesman", 'a', MSG_01 });
		return params;
	}

	@Test
	public void testfindRepeatedCharacter() {
		assertThat(message, RepeatedCharacter.findRepeatedCharacter(input), is(expected));
	}


}
