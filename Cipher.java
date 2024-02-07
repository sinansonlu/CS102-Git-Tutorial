// This class is used for encrypting or decrypting strings using character mapping
public class Cipher   
{
    // Strings for keeping the alphabets, one for the original letters and the other for the encrypted ones
    // encryption involves mapping from original to cipher, for each letter we locate the character in the
    // original string and replace it with the cipher alphabet letter at the same position
    public static final String ORIGINAL_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String CIPHER_ALPHABET = "dfxyhrklvwuasgimnojpqetbcz";

    // Encrypts the input string using the cipher alphabet
    public String encrypt(String inputString) {
        
        // Output string will be collected in this variable, one character at a time
        String outputString = "";
        
        // Iterate through each character in the input string
        for (int i = 0; i < inputString.length(); i++)   
        {
            int originalIndex = ORIGINAL_ALPHABET.indexOf(inputString.charAt(i));

            // If the character is found in the original alphabet, replace it with the corresponding character in the cipher alphabet
            if(originalIndex != -1) {
                outputString += CIPHER_ALPHABET.charAt(originalIndex);
            } else {
                // If the character is not found in the original alphabet, leave it unchanged
                outputString += inputString.charAt(i);
            }
            
        }

        return outputString;
    }

    // Decrypts the input string using the original alphabet
    public String decrypt(String inputString) {
        
        // Output string will be collected in this variable, one character at a time
        String outputString = "";
        
        // Iterate through each character in the input string
        for(int i = 0; i < inputString.length(); i++) {
            // Replace each character in the input string with its corresponding character in the original alphabet
            outputString += replaceChar(inputString.charAt(i), true);
        }
        
        return outputString;
    }

    // Replaces the given input char based on the given isEncrypt variable
    // If isEncrypt == true -> original to encrypted
    // If isEncrypt == false -> encrypted to original
    // Works only when the input char is included in our alphabet variables
    // Should not replace symbols or upper case letters, returns the input char in those cases
    private char replaceChar(char inputChar, boolean isEncrypt) {
        
        // If decryption is requested (isEncrypt == false), map characters from the cipher alphabet to the original alphabet
        if (!isEncrypt) {
            for (int i = 0; i < CIPHER_ALPHABET.length(); i++)   
            {
                if (CIPHER_ALPHABET.charAt(i) == inputChar) {
                    return ORIGINAL_ALPHABET.charAt(i);
                }
            }
        }
        // If encryption is requested (isEncrypt == true), map characters from the original alphabet to the cipher alphabet
        else {
            for (int i = 0; i < ORIGINAL_ALPHABET.length(); i++)   
            {
                if (ORIGINAL_ALPHABET.charAt(i) == inputChar) {
                    return CIPHER_ALPHABET.charAt(i);
                } 
            }
        }
        
        // If the character is not found in the alphabet, return the original character
        return inputChar;
    }
}
