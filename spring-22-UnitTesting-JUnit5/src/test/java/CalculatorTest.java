import org.junit.jupiter.api.*;

import java.nio.file.AccessDeniedException;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    //use same obj- run 1 time - static - not change
//test creating obj before start or DB connection

    @BeforeAll//run first - then all tests run
    static void setUpAll(){
        System.out.println("BeforeAll is executed.");
    }

    @AfterAll//close connection to DB , opened before(ex)
    static void tearDownAll(){
        System.out.println("AfterAll is executed.");
    }
    //use new obj
//    new CalculatorTest().add();
//    new CalculatorTest().add2();


    @BeforeEach//execute before each test (@Test) one by one
    void setUpEach(){
        System.out.println("BeforeEach is executed.");
    }

    @AfterEach
    void tearDownEach() {
        System.out.println("AfterEach is executed.");
    }


//assertEquals - from junit.jupiter.api.Assertions - for verify - check result
    @Test
    @DisplayName("MyMethod")//for rename test name (will see MyMethod)
    void add() {
        System.out.println("Add method");
        int actual = Calculator.add(2, 3);//call() inside real app
        assertEquals(5, actual, "Test failed.");//expect -1; actual- 2
        //exp - what res expect, actual - what obj return for real.. when compare - equal - correct
    }

//assertThrows - 2 param () trying to run - expect this exception - will it Throws - corr, if  not -fail
    @Test
    void add2(){
        System.out.println("Add2 method");

//        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(3,2)); //exception type -expecting ,
//        assertThrows(AccessDeniedException.class, () -> Calculator.add2(3,2)); //exception type -expecting ,
        assertThrows(IllegalArgumentException.class, () -> Calculator.add2(2,3)); //exception type -expecting ,
    }

    @Test
    void teatCase1(){
//        System.out.println("Test Case 1");
        fail("Not implemented yet");// when creating lot tests - use fail()- mean - not implement
    }

    @Test
    void teatCase2(){
        System.out.println("Test Case 2");
        assertEquals("add", Calculator.operator);//equal value to () from class
        assertTrue(Calculator.operator.equals("add"));//check equal to () from class Calculator
        //assertTrue - boolean express put inside - check true -it passes
    }

    @Test
    void teatCase3(){
        System.out.println("Test Case 3");
        assertArrayEquals(new int[]{1,2,3}, new int[]{1,2,3}, "Arrays are not same");//compare arrays(num, order)//can put message if test fail
    }//pass when have same param ....

    @Test
    void teatCase4(){
        System.out.println("Test Case 4");

        String nullString = null;
        String notNullString = "Cydeo";

        assertNull(nullString);//what put inside fill pass
        assertNotNull(notNullString);

//        assertNull(notNullString);//fail first and not look for next
        assertNotNull(nullString);
    }

    @Test
    void teatCase5(){
        System.out.println("Test Case 5");

        Calculator c1 = new Calculator();//c1 and c2 same obj in memory    //@Calculator123456
        Calculator c2 = c1;                                                //@Calculator123456
        Calculator c3 = new Calculator();//c1 not eq c2                    //@Calculator987423

        assertSame(c1, c2);//pass- if they are same obj in memory
        assertNotSame(c1, c3);//if they not same

    }
//maven-surefire-plugin ->
// ->can use terminal for see info when run test

//can look do we have it or not  -go - Maven-spring-2-2UnitTesting-JUnit5- test (run)
}