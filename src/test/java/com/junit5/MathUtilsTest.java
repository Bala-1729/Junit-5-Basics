package com.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MathUtilsTest {
	
	MathUtils math;
	
	@BeforeEach
	void init() {
		math = new MathUtils();
	}

	@Test
	void testAdd() {
		int actual = math.add(1, 1);
		int expected = 2;
		
		assertEquals(actual,expected,"The add messages adds two numbers");
	}
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> math.divide(1, 0), "Divide method may throw Arithmetic Exception");
	}
	
	@Test
	void testCircleArea() {
		double actual = math.circleArea(10);
		double expected = 3.141592653589793238 * 100;
		
		assertEquals(actual, expected, "The circleRadius method return the area of the circle");
	}
}
