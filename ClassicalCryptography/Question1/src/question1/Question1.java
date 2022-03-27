// Senanur KÖSE 190315060 1st Ed.
package question1;
import java.util.Scanner;
import java.util.Locale;
public class Question1 {
    public static void main(String[] args) {
        //First, the user is asked to enter a message.
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your message:");
         //I make uppercase the entered word according to the English alphabet.
        String inputMessage = sc.nextLine().toUpperCase(Locale.ENGLISH);
        while(!IsValidMessage(inputMessage))//I check if input is valid , if it is not valid, I ask the user again until a valid message is entered.
        {
            System.out.println("Your message contains nonletters, please enter a valid message!");
            inputMessage = sc.nextLine().toUpperCase(Locale.ENGLISH);
        }
        EncryptMessage(inputMessage);
    }
    public static boolean IsValidMessage(String message)
    {   // If character is letter in A-Z or empty, the function return true, else return false.
        boolean isValidMessage = true;
        for(int i=0;i<message.length();i++)
        {   
            if((message.charAt(i) < 'A' || message.charAt(i) > 'Z') && message.charAt(i) != ' ')
            {
                isValidMessage = false;
                break;
            }
        }
        return isValidMessage;
    }
    public static void EncryptMessage(String message)
    {   //I create two array for original letter numbers and replaced letter numbers.
        System.out.println();
        int[] messageLetterNumbers = new int[message.length()];
        int[] replacedLetterNumbers = new int[message.length()];
        //I create empty string to store encrypted message
        String encryptedMessage = "";
        for(int i=0;i<message.length();i++)
        {   
            if(message.charAt(i) == ' ')
            {   //If current character of word is empty, I added the empty character without replacing.
                messageLetterNumbers[i] = (int) ' ';
                replacedLetterNumbers[i] = messageLetterNumbers[i];
                encryptedMessage += " ";
            }
            else
            {
                //Firstly, I get the numbers of letters and I replace letters according to index+3 mod 26
                messageLetterNumbers[i] = GetLetterIndex(message.charAt(i));
                replacedLetterNumbers[i] = (messageLetterNumbers[i] + 3) % 26;
                encryptedMessage += GetLetter(replacedLetterNumbers[i]);
            }
        }
        //Finally, I print encyrpted message
        System.out.println("The encrypted message: " + encryptedMessage);
        System.out.println();
    }
    public static int GetLetterIndex(char c)
    {   //The ASCII code of first character starts with 65 so I subtract 65 from the num to set first as 0.
        int index = (int)c - 65;
        return index;
    }
    public static char GetLetter(int letterIndex)
    {
        //I convert letter index to letter, first I add 65 to letter index and convert ascii to char.
        char letter=(char)(letterIndex+65);
        return letter;
    }
}