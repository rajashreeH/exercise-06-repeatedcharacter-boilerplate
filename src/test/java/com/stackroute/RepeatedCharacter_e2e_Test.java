package com.stackroute;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RepeatedCharacter_e2e_Test {
	private static final String MSG_01 = "The method should return the most repeated character from the input string. If more than one character is repeated same number of times, return the smallest one";
	private static final String MSG_02 = "Method should return character 0 for Null, Empty string or if no characters are repeated";

	private String input;
	private String expected;
	private String message;
	
	private static final String NOREPEAT = "No characters repeated";

	private PrintStream out;
	private ByteArrayOutputStream myOutStream;
	private InputStream in;
	private ByteArrayInputStream myInputStream;

	public RepeatedCharacter_e2e_Test(String input, String expected, String message) {
		this.input = input;
		this.expected = expected;
		this.message = message;
	}
	
	@Before
	public void setUp() {
		in = System.in;
		out = System.out;
		myOutStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(myOutStream));
	}

	@After
	public void tearDown() {
		System.setIn(in);
		System.setOut(out);
	}
	
	@Parameters(name = "{index}: Main Method Input ({0}) - Should display ({1})")
	public static Collection<Object[]> data() {
		Collection<Object[]> params = new ArrayList<>();
		params.add(new Object[] { "repeated", "e", MSG_01 });
		params.add(new Object[] { "hello world", "l", MSG_01 });
		return params;
	}

	@Test
	public void testRepeatedCharacter_e2e() {
		myInputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(myInputStream);

		RepeatedCharacter.main(null);
		String actual = myOutStream.toString().replaceAll("\\s+", "");
		assertThat(message, actual, is(expected.replaceAll("\\s+", "")));
	}
}