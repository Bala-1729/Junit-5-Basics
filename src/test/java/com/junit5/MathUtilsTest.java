package com.junit5;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class MathUtilsTest {
	
	MathUtils math;
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		testReporter.publishEntry("Running "+testInfo.getDisplayName());
		math = new MathUtils();
	}
	
	@BeforeAll
	static void beforeAllInit() {
		System.out.println("Starting up....");
	}
	
	@AfterAll
	static void cleanup() {
		System.out.println("Cleaning up....");
	}

	@Nested
	class AddTest{
		@Test
		@DisplayName("Adding two positive numbers")
		void testAddPositive() {
			int actual = math.add(1, 1);
			int expected = 2;
			
			assertEquals(expected, actual, "should return the sum");
		}
		
		@Test
		@DisplayName("Adding two negative numbers")
		void testAddNegative() {
			int actual = math.add(-1, -1);
			int expected = -2;
			
			assertEquals(expected, actual, "should return the sum");
		}
	}
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> math.divide(1, 0), "Divide method may throw Arithmetic Exception");
	}
	
	@Test
	void testCircleArea() {
		double actual = math.circleArea(10);
		double expected = 3.141592653589793238 * 100;
		
		assertEquals(expected, actual, "The circleRadius method return the area of the circle");
	}
	
	@Test
	void testIsServerUp() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);
		System.out.println("Server is up");
	}
	
	@Test
	void testAssertAll() {
		assertAll(
				() -> assertEquals(math.add(1, 1),2),
				() -> assertEquals(math.add(2, 1),3)
				);
	}
	
	@Test
	@EnabledOnOs(OS.LINUX)
	void testConditional() {
		System.out.println("OS is LINUX");
	}
	
	@Test
	@Disabled
	void testDisabled() {
		fail("This method should fail");
	}
}
