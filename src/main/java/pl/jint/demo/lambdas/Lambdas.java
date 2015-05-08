package pl.jint.demo.lambdas;

import java.lang.ProcessBuilder.Redirect;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lambdas {

	public String printSortedPreJava8(List<String> strings) {
		StringBuilder result = new StringBuilder();
		// pre Java-8
		Collections.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.compareToIgnoreCase(s1);
			}
		});
		for (String string : strings) {
			result.append(string);
		}

		return result.toString();
	}

	public String printSortedJava8StreamApi(List<String> strings) {
		StringBuilder result = new StringBuilder();
		// Java-8 using stream API
		strings.stream().sorted(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.compareToIgnoreCase(s1);
			}
		}).forEach(new Consumer<String>() {
			@Override
			public void accept(String string) {
				result.append(string);
			}
		});

		return result.toString();
	}

	public String printSortedJava8StreamApiAndLambdas(List<String> strings) {
		StringBuilder result = new StringBuilder();
		// Java-8 using stream API and lambdas
		strings.stream().sorted((String s1, String s2) -> {
			return s2.compareToIgnoreCase(s1);
		}).forEach((String string) -> {
			result.append(string);
		});

		return result.toString();
	}

	public String printSortedJava8StreamApiAndLambdas2(List<String> strings) {
		StringBuilder result = new StringBuilder();
		// Declaring the types of the parameters is optional.
		strings.stream().sorted((s1, s2) -> {
			return s2.compareToIgnoreCase(s1);
		}).forEach((string) -> {
			result.append(string);
		});

		return result.toString();
	}

	public String printSortedJava8StreamApiAndLambdas3(List<String> strings) {
		StringBuilder result = new StringBuilder();
		// Using parentheses around the parameter is optional if you have only
		// one parameter.
		strings.stream().sorted((s1, s2) -> {
			return s2.compareToIgnoreCase(s1);
		}).forEach(string -> {
			result.append(string);
		});

		return result.toString();
	}

	public String printSortedJava8StreamApiAndLambdas4(List<String> strings) {
		StringBuilder result = new StringBuilder();
		// Using curly braces is optional (unless you need multiple statements).
		// The return keyword is optional if you have a single expression that
		// returns a value.
		strings.stream().sorted((s1, s2) -> s2.compareToIgnoreCase(s1)).forEach(string -> result.append(string));

		return result.toString();
	}

	public String printSortedJava8StreamApiAndMethodReference(List<String> strings) {
		// Using method reference
		String result = strings.stream().sorted((s1, s2) -> s2.compareToIgnoreCase(s1))
		.collect(Collectors.joining()); //TODO
		return result;
	}

	/**
	 * TODO: Fix parallel sorting order.
	 * 
	 * @param strings
	 * @return
	 */
	public String printSortedJava8StreamApiAndMethodReferenceInParallel(List<String> strings) {
		// Lets to it in parallel
		//Solution 1
//		StringBuilder result = new StringBuilder();
//		strings.stream()
//		.parallel()
//		.sorted((s1, s2) -> s2.compareToIgnoreCase(s1))
//		.forEachOrdered(result::append);
//		return result.toString();
		
		//Solution 2
		String result = strings.stream()
		.parallel()
		.sorted((s1, s2) -> s2.compareToIgnoreCase(s1))
		.collect(Collectors.joining());
		return result;
	}

	/**
	 * TODO: Implement
	 * 
	 * @param strings
	 * @param orderFunction
	 * @return
	 */
	public String printSortedJava8(List<String> strings, BiFunction<String,String, Integer> orderFunction) {
		StringBuilder result = new StringBuilder();
		strings.stream().sorted(orderFunction::apply).forEach(result::append);
		return result.toString();
	}

	public Object countAvgLength(List<String> input2) {
		//Solution 1
//		return OptionalDouble.of(
//				input2
//				.stream()
//				.map((s) -> s.length())
//				.collect(Collectors.averagingDouble((l) -> l))
//				);
		//Solution 2
		return  input2.stream()
				.mapToInt(String::length)
				.average();
	}

	public long countStringsLongerThan(List<String> input2, int i) {
		return input2.stream()
				.filter((s) -> s.length() > i)
				.count();
	}

	public Object getLongest(List<String> input2) {
		// TODO Auto-generated method stub
		return null;
	}

}
