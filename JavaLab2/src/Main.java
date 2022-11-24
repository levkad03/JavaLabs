import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the text: ");
        Scanner in = new Scanner(System.in);
        String inputText = in.nextLine();
        char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        StringBuilder output = new StringBuilder();
        inputText = inputText.replace("", " ");
        System.out.println(inputText);
        inputText = inputText.replace(" ", "");
        inputText = inputText.toLowerCase();
        for(int i = 0; i < inputText.length(); i++){
            for(int a = 0; a < alphabet.length; a++){
                if(alphabet[a] == inputText.charAt(i)){
                    output.append((a+1));
                    if(i < output.length()){
                        output.append(" ");
                    }
                }
            }
        }
        System.out.println(" "+output);
    }
}
