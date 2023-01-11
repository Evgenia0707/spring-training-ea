import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {
//send multiple data in test

//@ValueSource
    @ParameterizedTest//what me test case able to run multiple times with same param (1 time for each param)
    @ValueSource(strings = {"Java", "JS", "TS"})//test data //for each test data run for each (3 times)
    void testCase1(String arg){
        Assertions.assertFalse(arg.isEmpty());//can call () by him self or assert....
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9})//test data //test data run for each (3 times)
    void testCase1(int num){
        Assertions.assertEquals(0, num % 3);//if numbers(param) able divided by 3 - remainder = 3 -> will pass if = 3
    }


//ex: check validation(password)  it can be List Set Map and Array v
// @EmptySource  // ""
// @NullSource    // null directly
// @NullAndEmptySource

    @ParameterizedTest
    @ValueSource(strings = {"Java", "JS", "TS"})
//    @EmptySource            // ""
//    @NullSource
    @NullAndEmptySource
    void testCase3(String arg) {
        Assertions.assertFalse(arg.isEmpty());
    }



// @MethodSource("") + factory ()  //can return arr,collection from () - then using ()name can run test base on param
    @ParameterizedTest
//    @MethodSource("ClassName#stringProvider")
    @MethodSource("stringProvider")//If the method is in the
    void testCase4(String arg){
        Assertions.assertFalse(arg.isEmpty());//create data to provide () source
    }

    static String[] stringProvider(){
        return new String[]{"Java", "JB", "TB"};//need to put () inside ()
    }


// @CsvSource - each line(string) give 3 value - each run time
    @ParameterizedTest
    @CsvSource({
            "10, 20, 30",
            "20, 20, 40",
            "30, 20, 100"
    })
     void testCase5(int num1, int num2, int result){// 10+20=30..20+20=40.....
        Assertions.assertEquals(result, Calculator.add(num1, num2));//assertEquals - expected
    }


//@CsvFileSource
    @ParameterizedTest //numLinesToSkip = 1 - skip line in fail
    @CsvFileSource(resources = "/sample-data.csv", numLinesToSkip = 1) //provide file path(be default annot look under resources)can use file from outside
    void testCase6(int num1, int num2, int result){//take line by line
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }//false - on header (num1, num2, result) String - not int - do this ->numLinesToSkip = 1


        //soft assertion
//        Assertions.assertTrue(result == Calculator.add(num1, num2));//if fail look for other test
//        Assertions.assertFalse(result != Calculator.add(num1, num2));


}
