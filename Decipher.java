import java.util.Scanner;

/**
 * This class is used for deciphering
 */

public class Decipher {
    //Define the final variables for this deciphering method.
    public static final String ORIGINAL_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String CIPHER_ALPHABET = "dfxyhrklvwuasgimnojpqetbcz";
    public static void main (String[] args){


        Scanner in = new Scanner(System.in);
        String text = "";
        do{
            System.out.print("Enter the text for deciphering, 'quit' for quit: ");
            text = in.nextLine();
            if ( !text.equals("quit") )
            {
                String decipheredText = textDecipher(text);
                System.out.println("The deciphered text: " + decipheredText);
            }
        }while(!text.equals("quit"));
        in.close();

    }

    public static String textDecipher(String rawText){
        String result = "";

        for ( int i = 0; i < rawText.length(); i++ )
        {
            if ( CIPHER_ALPHABET.contains( rawText.charAt(i) + "") )
            {
                char findChar = rawText.charAt(i);
                int findIndexOfChar = CIPHER_ALPHABET.indexOf(findChar);
                char decipheredChar = ORIGINAL_ALPHABET.charAt(findIndexOfChar);
                
                result = result + decipheredChar;
            }
            else
            {
                result = result + rawText.charAt(i);
            }
        }
        return result;
    }
}
