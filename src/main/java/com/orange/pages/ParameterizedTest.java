package com.orange.pages;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest {
	 @Test
	   @Parameters("parameter1")
	   public void parameterTest(String parameter1) {
	      System.out.println("Parameterized value is : " + parameter1);
	   }
}
