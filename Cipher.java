// This class is used for encrypting or decrypting strings using character mapping
public class Cipher   
{
public class Cipher {
    // Strings for keeping the alphabets, one for the original letters and the other for the encrypted ones
    // encryption involves mapping from original to cipher, for each letter we locate the character in the
    // original string and replace it with the cipher alphabet letter at the same position
@@ -15,7 +13,7 @@ public String encrypt(String inputString) {
        // for all chars in the input string
        for (int i = 0; i < inputString.length(); i++)   
        {

            outputString += replace(inputString.char(i),true);
        }

        return outputString;
@@ -25,9 +23,9 @@ public String decrypt(String inputString) {

        // output string will be collected in this variable, one char at a time
        String outputString = "";

        replaceChar('a',true);

        for(int i=0;i<inputString.length();i++){
           outputString +=  replaceChar(inputString.charAt(i),false);
        }
        return outputString;
    }

@@ -42,6 +40,7 @@ private char replaceChar(char inputChar, boolean isEncrypt) {
            for (int i = 0; i < ORIGINAL_ALPHABET.length(); i++)   
            {
                if(ORIGINAL_ALPHABET.charAt(i) == inputChar) {
                    return CIPHER_ALPHABET.charAt(i);

                }
            }
@@ -58,4 +57,5 @@ private char replaceChar(char inputChar, boolean isEncrypt) {
        // if we did not find it in the alphabet, then return the original char
        return inputChar;
    }
}   

}
