// This class is used for encrypting or decrypting strings using character mapping
public class Cipher   
{
    // Strings for keeping the alphabets, one for the original letters and the other for the encrypted ones
    // encryption involves mapping from original to cipher, for each letter we locate the character in the
    // original string and replace it with the cipher alphabet letter at the same position
    public static final String ORIGINAL_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String CIPHER_ALPHABET = "dfxyhrklvwuasgimnojpqetbcz";

    public String encrypt(String inputString) {
        
        // output string will be collected in this variable, one char at a time
        String outputString = "";
        
        // for all chars in the input string
        for (int i = 0; i < inputString.length(); i++)   
        {
            if(inputString.charAt(i)==' ')
            {
                outputString+=" ";
            }
            if((!Character.isLetter(inputString.charAt(i)))&&(inputString.charAt(i)!=' '))
            {
                outputString+=inputString.charAt(i);
            }
            else
            {
                for (int j=0; j<ORIGINAL_ALPHABET.length(); j++)
                {
                    
                    if (inputString.charAt(i)==ORIGINAL_ALPHABET.charAt(j))
                    {
                        outputString+=CIPHER_ALPHABET.charAt(j);
                    }
                }
            }   
        }

        return outputString;
    }

    public String decrypt(String inputString) {
        
        // output string will be collected in this variable, one char at a time
        String outputString = "";
        
        // for all chars in the input string
        for (int i = 0; i < inputString.length(); i++) 
        {
            if(inputString.charAt(i)==' ')
            {
                outputString+=" ";
            }
            if((!Character.isLetter(inputString.charAt(i)))&&(inputString.charAt(i)!=' '))
            {
                outputString+=inputString.charAt(i);
            }
            else
            {
                for (int j=0; j<CIPHER_ALPHABET.length();j++)
                {
                    if (inputString.charAt(i)==CIPHER_ALPHABET.charAt(j))
                    {
                        outputString+=ORIGINAL_ALPHABET.charAt(j);
                    }
                }
            }
        }

        return outputString;
    }

    // replaces the given input char based on the given isEncrypt variable
    // if isEncrypt == true -> original to encrypted
    // if isEncrypt == false -> encrypted to original
    // works only when the input char is included in our alphabet variables
    // should not replace symbols or upper case letters, return input char in those cases
    private char replaceChar(char inputChar, boolean isEncrypt) {
        
        if(isEncrypt) {
            for (int i = 0; i < ORIGINAL_ALPHABET.length(); i++)   
            {
                if ((Character.isUpperCase(ORIGINAL_ALPHABET.charAt(i)))||(!Character.isDigit(ORIGINAL_ALPHABET.charAt(i)))||(!Character.isWhitespace(ORIGINAL_ALPHABET.charAt(i))))
                {
                    return inputChar;
                }
                if(ORIGINAL_ALPHABET.charAt(i) == inputChar) {
                    inputChar= CIPHER_ALPHABET.charAt(i);
                }
            }
        }
        else {
            for (int i = 0; i < CIPHER_ALPHABET.length(); i++)   
            {
                if ((Character.isUpperCase(CIPHER_ALPHABET.charAt(i)))||(!Character.isDigit(CIPHER_ALPHABET.charAt(i)))||(!Character.isWhitespace(CIPHER_ALPHABET.charAt(i))))
                {
                    return inputChar;
                }
                if(CIPHER_ALPHABET.charAt(i) == inputChar) {
                    inputChar= ORIGINAL_ALPHABET.charAt(i);
                }
            }
        }
        
        return inputChar;
    }
}   
