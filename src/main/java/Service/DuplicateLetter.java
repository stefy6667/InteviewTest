package Service;

public class DuplicateLetter {

    public String DuplicateLetter (String test){
        StringBuilder duplicate = new StringBuilder();

        for(int i =0;i<test.length();i++){

            duplicate.append(test.charAt(i));
            duplicate.append(test.charAt(i));

        }


        return duplicate.toString();
    }
}
