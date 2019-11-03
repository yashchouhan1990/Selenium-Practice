package testNG_ParallelTestCaseExecution;

import org.testng.annotations.Test;

public class Parallel_classwise_execution_two {
	@Test
    public void testMethodsOne() {
        long id = Thread.currentThread().getId();
        System.out.println(" im in first test case from Classtwo Class | Simple test-method One. Thread id is: " + id);
    }
 
    @Test
    public void testMethodsTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("im in second test case from Classtwo Class | Simple test-method Two. Thread id is: " + id);
    }
    
    @Test
    public void testMethodsThree() {
        long id = Thread.currentThread().getId();
        System.out.println("im in third test case from Classtwo Class | Simple test-method Three. Thread id is: " + id);
    }
    
    @Test
    public void testMethodsFour() {
        long id = Thread.currentThread().getId();
        System.out.println("im in fourth test case from Classtwo Class | Simple test-method Four. Thread id is: " + id);
    }


}
