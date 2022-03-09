import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    private static final Character[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static void main(String[] args) {
        System.out.println("Enter a word: ");
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();

        if(validate(input))
            findNumberOfOccurrences(input);
    }

    static boolean validate(String input){
        boolean validation = true;
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9. ]");
        Matcher matcher = pattern.matcher(input);
        if(input.isEmpty()){
            System.out.println("Word cannot be empty");
            validation = false;
        }
        //special characters
        else if(matcher.find()){
            System.out.println("Word cannot contain special characters");
            validation = false;
        }
        else if(input.matches(".*[0-9.?].*")){
            System.out.println("Word cannot contain numbers");
            validation = false;
        }
        return validation;
    }

    private static void findNumberOfOccurrences(String input){

        List<Character> alphabetLetters = Arrays.asList(alphabet);
        char[] chars = input.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : chars) {
            if (hashMap.containsKey(c)) {
                int characterCount = hashMap.get(c) + 1;
                hashMap.replace(c, characterCount);
            }else {
                hashMap.put(c,1);
            }
        }

        List<Character> characterList = new ArrayList<>(hashMap.keySet());
        Integer[] charIndexesToSort = new Integer[characterList.size()];

        //assigning the index of the alphabet relevant to the character into an array
        for (int i = 0; i < characterList.size(); i++){
            charIndexesToSort[i] = alphabetLetters.indexOf(characterList.get(i));
        }

        //sorting the assigned indexes in the alphabet
        for (int i = 0; i < charIndexesToSort.length; i++) {
            if((i+1)<=charIndexesToSort.length-1){
                if(charIndexesToSort[i] > charIndexesToSort[i+1]){
                    int temp = charIndexesToSort[i];
                    charIndexesToSort[i] = charIndexesToSort[i+1];
                    charIndexesToSort[i+1] = temp;
                }
            }
        }

        for (int i = 0; i < charIndexesToSort.length; i++) {
            System.out.println(alphabet[charIndexesToSort[i]]+" "+hashMap.get(alphabet[charIndexesToSort[i]]));
        }
    }
}
