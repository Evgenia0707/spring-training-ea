public class Calculator {


    public static String operator = "add";

    public static int add(int num1, int mun2){
        return num1 + mun2;
    }

    public static int add2(int num1, int mun2) throws Exception {
        if (num1 > mun2){
            throw new IllegalArgumentException("My exception");
        }
        return num1 + mun2;
    }



}
