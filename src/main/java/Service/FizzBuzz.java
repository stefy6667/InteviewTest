package Service;

public class FizzBuzz {

    public String FizzBuzz(int test){
        String result ="";


        if(test%3==0 && test % 5 ==0 ){
            result="FizzBuzz";
        }else if(test %3 == 0){
            result="Fizz";
        }else if(test % 5 == 0){
            result="Buzz";
        }
        return result;


    }
}
