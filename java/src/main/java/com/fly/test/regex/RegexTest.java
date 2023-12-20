package com.fly.test.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {

	@Test
	public void test() {
		String regex = "^(2)\\\\d{3}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher("2246");
		System.out.print(m.matches());
	}

}
