package pl.jint.demo.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

import org.junit.Assert;
import org.junit.Test;

public class LambdasTest {

	private static final List<String> input = Arrays.asList(new String[] {"bAAb", "CaaD", "abba"});
	private static final List<String> input2 = Arrays.asList(new String[] {"4444", "666666", "22"});
	
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
		Assert.assertEquals("CaaDabbabAAb", lambdas.printSortedJava8(input, (s1, s2) -> s1.compareTo(s2)));
	}

	
	@Test
	public void testCountAvgLength() {
		Assert.assertEquals(OptionalDouble.of(4.0), lambdas.countAvgLength(input2));
	}
	
	@Test
	public void testCountStringsLongerThan3() {
		Assert.assertEquals(2, lambdas.countStringsLongerThan(input2, 3));
	}
	
	@Test
	public void testGetLongestString() {
		Assert.assertEquals(Optional.of("666666"), lambdas.getLongest(input2));
	}
}
