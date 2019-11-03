package testNG_ParallelTestCaseExecution;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
The parallel attribute of suite tag can accept four values:

tests	All the test cases inside <test> tag of Testing xml file will run parallel.
classes	All the test cases inside a Java class will run parallel
methods	All the methods with @Test annotation will execute parallel.
instances	Test cases in same instance will execute parallel but two methods of two different instances will run in different thread.
The attribute thread-count allows you to specify how many threads should be allocated for this execution.


*/
public class Parallel_Test {
	
/*    @BeforeMethod
    public void beforeMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-method. Thread id is: " + id);
    }
*/ 
    @Test
    public void testMethodsOne() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method One. Thread id is: " + id);
    }
 
    @Test
    public void testMethodsTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Two. Thread id is: " + id);
    }
    
    @Test
    public void testMethodsThree() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Three. Thread id is: " + id);
    }
    
    @Test
    public void testMethodsFour() {
        long id = Thread.currentThread().getId();
        System.out.println("Simple test-method Four. Thread id is: " + id);
    }
 /*
    @AfterMethod
    public void afterMethod() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method. Thread id is: " + id);
    }
*/
}

/*

Output-

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="Suite"		parallel="methods">
  <test thread-count="5" name="Test">
    <classes>
      <class name="testNG_ParallelTestCaseExecution.Parallel_Test"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->

[RemoteTestNG] detected TestNG version 6.14.2
Before test-method. Thread id is: 11
Before test-method. Thread id is: 10

Simple test-method Two. Thread id is: 11
Simple test-method One. Thread id is: 10

After test-method. Thread id is: 11
After test-method. Thread id is: 10
*/