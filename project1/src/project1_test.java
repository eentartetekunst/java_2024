import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class project1_test {
	/**
	 * informal documentation looks like this
	 * in formal documentation, post  conditions are used
	 * @post what is expected
	 * 		| result == x || result == y || result == z
	 * @post what is expected
	 * 		| x <= result &&  y <= result && z <= result 
	 */
	
	
	// procedural abstractions = fancy way of saying methods
	int max3(int x, int y, int z) {
		if (x < y) 
			if (y < z)
				return z;
			else
				return y;
		else
			if (x < z)
				return z;
			else
				return x;
				
	}
	
	// single line comment
	
	
	// good to be thorough when testing, get a lot of assurance about your code
	// a test case cannot be called thorough if it does not cover all your lines of code
	
	/**
	 * Returns the square root rounded down 
	 * 
	 * @pre the given value is nonnegative (without that, the client should raise an error that 
	 * 		| x > 0
	 * @throws IllegalArgumantException if  the given value is negative
	 * 		| !( x > 0)
	 * 
	 * @post The result is nonnegative
	 * 		| 0 <= result
	 * @post The square of the result is not greater than x
	 * 		| result * result <= x
	 *The square of the result is not greater than x
	 * 		| (result + 1) * (result + 1) <= x 
	 */
	
	
	int sqrt(int x) {
		assert (0 <= x); // defencive programming -- checking the correct inputs
			// throw new IllegalArgumentException("x is negative");

		int result = 0;
		while ((result+1)*(result+1) <= x)
			result++;
		return result;
	}
	
	
	
	/**
	 * Returns average of elements of an array with indexes index1 and index2
	 * @pre | 0<= index1 && index1 < array.length 
	 * @pre | 0<= index2 && index2 < array.length
	 * @pre | array != null 
	 * @inspects | array 
	 * @post | result == (array[index1] + array[index2])/2
	 */
	
	
	int ComputeAverage(int[] array, int index1, int index2) {
		return (array[index1] + array[index2])/2;
	}
	
	/**
	 * 	
	 * @pre | array != null 
	 * @pre | array.length >= 1
	 * 
	 * @inspects | array 
	 * from 0 to length 
	 * 
	 * @post the result is greater or equal than any element of an array
	 *       | IntStream.range(0, array.length).allMatch(i -> array[i] <= result)
	 * @post the result in an element of an array
	 *       | IntStream.range(0, array.length).allMatch(i -> array[i] == result)
	 */
	
	
	int max(int[] array) {
		int result = array[0];
		for (int i = 1; i < array.length; i++)
			if (array[i] > result)
				result = array[i];
		return result;
		
	}
	
	
	/**
	 * swap the elements in an array
	 * @pre | array != null
	 * @pre | 0 <= index1 && index1 <= array.length
	 * @pre | 0 <= index2 && index2 <= array.length
	 * @mutates array
	 * @post | array[index1] == old(array[index2])
	 * @post | array[index2] == old(array[index1])
	 * @post other indexes remain unchanged
	 * if i is not the two changed indexes, all other indexes are unchanged
	 * 		 | InStream.range(0, arrange.length).all.Match(i -> i == index2 ||  i == index1 || array[i] == old(array.clone())[i])
	 */
	
	void swap(int[] array, int index1, int index2) {
		int value1 = array[index1];
		array[index1] = array[index2];
		array[index1] = value1;				
	}
	
	
	/**
	 * returns median of 3 numbers 
	 * @pre | x!=y && x!=z && z!=y
	 * 
	 */
	
	int median(int x, int y, int z) {
		if  ((y < x && x < z) || (z < x && x < y))
			return x;
		else if ((x < y && y < z) || (z < y && y < x))
			return y; 
		else
			return z;
	}
	
	
	@Test
	void test_ComputeAverage() {
		assertEquals(3, ComputeAverage(new int[] {-1,2,-3,4}, 1, 3));
	}
	
	
	@Test
	void test_sqrt() {
		assertEquals(0, sqrt(0));
		assertEquals(1, sqrt(1));
		assertEquals(2, sqrt(4));
		assertEquals(3, sqrt(9));
	}
	
	@Test
	void text_max3() {
		assertEquals(30, max3(10, 20, 30));
		assertEquals(30, max3(30, 20, 10));
		assertEquals(30, max3(10, 30, 20));
		assertEquals(30, max3(30, 10, 20));
		assertEquals(30, max3(20, 10, 30));
		assertEquals(30, max3(20, 30, 10));
	}

}