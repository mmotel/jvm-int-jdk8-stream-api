package pl.jint.demo.lambdas;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Lists;

public class LambdasTest {

	private static final List<String> input = Lists.newArrayList("bAAb", "CaaD", "abba");
	private static final String expectedResult = "CaaDbAAbabba";
	private Lambdas lambdas = new Lambdas();

	@Test
	public void testPrintSortedPreJava8() {
		Assert.assertEquals(expectedResult, lambdas.printSortedPreJava8(input));
	}

	@Test
	public void testPrintSortedJava8StreamApi() {
		Assert.assertEquals(expectedResult, lambdas.printSortedJava8StreamApi(input));
	}

	@Test
	public void testPrintSortedJava8StreamApiAndLambdas() {
		Assert.assertEquals(expectedResult, lambdas.printSortedJava8StreamApiAndLambdas(input));
	}

	@Test
	public void testPrintSortedJava8StreamApiAndLambdas2() {
		Assert.assertEquals(expectedResult, lambdas.printSortedJava8StreamApiAndLambdas2(input));
	}

	@Test
	public void testPrintSortedJava8StreamApiAndLambdas3() {
		Assert.assertEquals(expectedResult, lambdas.printSortedJava8StreamApiAndLambdas3(input));
	}

	@Test
	public void testPrintSortedJava8StreamApiAndLambdas4() {
		Assert.assertEquals(expectedResult, lambdas.printSortedJava8StreamApiAndLambdas4(input));
	}

	@Test
	public void testPrintSortedJava8StreamApiAndMethodReference() {
		Assert.assertEquals(expectedResult, lambdas.printSortedJava8StreamApiAndMethodReference(input));
	}

	@Test
	public void testPrintSortedJava8StreamApiAndMethodReferenceInParallel() {
		Assert.assertEquals(expectedResult, lambdas.printSortedJava8StreamApiAndMethodReferenceInParallel(input));
	}
	
	@Test
	public void testPrintSortedJava8() {
		Assert.assertEquals("CaaDabbabAAb", lambdas.printSortedJava8(input, null /*TODO: (s1, s2) -> s1.compareTo(s2)*/));
	}

}
