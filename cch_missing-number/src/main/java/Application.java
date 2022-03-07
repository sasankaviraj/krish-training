import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {

    private static final List<Integer> missingNumbers = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Enter the number sequence with spaces: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if(validate(input)){
            sortNumbers(input);
        }else {
            System.out.println("Input a valid number sequence");
        }
    }

    static boolean validate(String input){
        boolean validation = true;
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9. ]");
        Matcher matcher = pattern.matcher(input);
        if(input.isEmpty()){
            validation = false;
        }
        //special characters
        else if(matcher.find()){
            validation = false;
        }
        else if(input.matches(".*[a-zA-Z.?].*")){
            validation = false;
        }
        return validation;
    }

    //sort numbers
    static void sortNumbers(String input){
        String[] characterList = input.split(" ");
        List<String> numberStr = Arrays.asList(characterList);
        List<Integer> numberList = numberStr.stream().map(Integer::valueOf).collect(Collectors.toList());

        Integer[] numbers = new Integer [numberList.size()];
        numberList.toArray(numbers);

        for(Integer number : numbers){
            for (int i = 0; i < numbers.length; i++){
                if((i+1)<=numbers.length -1){
                    if(numbers[i] > numbers[i+1]){
                        int temp = numbers[i];
                        numbers[i] = numbers[i+1];
                        numbers[i+1] = temp;
                    }
                }
            }
        }
        findMissingNumbers(numbers);
    }

    //find missing numbers
    static void findMissingNumbers(Integer[] numbers){
        for (int i = 0; i < numbers.length; i++){
            if((i+1)<=numbers.length-1){
                if (numbers[i]+1 != numbers[i+1]){
                    missingNumbers.add(numbers[i]+1);
                    numbers[i] = numbers[i]+1;
                    while(numbers[i]+1 != numbers[i+1]){
                        missingNumbers.add(numbers[i]+1);
                        numbers[i] = numbers[i]+1;
                    }
                }
            }
        }
        printMissingNumbers();
    }

    static void printMissingNumbers(){
        System.out.println("Missing numbers are: ");
        for (Integer integer:missingNumbers) {
            System.out.print(integer+" ");
        }
    }

}
