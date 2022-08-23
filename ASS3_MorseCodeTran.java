/**
 * ASS3_MorseCodeTran - 
 * Description: Uses a tranlation file to decode a morsecode message in a file given by the user.
 * Grabs data from a translation file, a coded message file and  Outputs data into a decoded message file.
 *  
 * Inputs: morse.txt, codedmessage.txt
 * Outputs: decodedmessage.txt
 * 
 * @author Brent Martin
 * @version 3.0
 */
// Standard import for the Scanner class
import java.util.*;
import java.io.*;
public class ASS3_MorseCodeTran {
    public static void main (String [] args) throws IOException
    {

        // Create a Scanner object attached to the keyboard
        Scanner in = new Scanner (System.in);//scanncer to read userinput
        // Write your code here!!!!

        //Increment 1: grabs translation file and sorts both english characters and morsecode characters into an array  

        System.out.print("Enter Morse Code translation table file path: "); //c:\temp\
        String file1 = in.nextLine(); //grabs translation file path
        File transFile = new File(file1);
        Scanner inFile1 = new Scanner(transFile);//scanner to read translation file

        String[] letterArray = new String[39];//array to store english characters
        String[] codeArray = new String[39];//array to store morsecode characters
        String messWord = ""; //string to store 
        String decodedMess = "";// string to hold decoded characters

        int arrayCount = 0; //varible storing value to the correct index the element needs to be stored in
        while (inFile1.hasNext()){
            letterArray[arrayCount] = inFile1.next(); //grabs next english character and puts it in an array
            codeArray[arrayCount] = inFile1.next(); //grabs nect morse code character and puts it in an array
            arrayCount++; //increases value to ensure next element is put in the correct index                   
        }
        //System.out.println(Arrays.toString(letterArray));
        //System.out.println(Arrays.toString(codeArray));
        int transLen = codeArray.length; // value storing length of translation code array
        System.out.println("Code translation file processed. " + codeArray.length + " codes loaded.");//string to comfirm translation file was read, and how many codes were found

        //Incretment 2: grabs the coded message and seperates each morsecode character 

        System.out.print("Enter coded message input file path: ");//C:\Users\771684\Documents\Classes\SEM 1\CMPP 269 D\My programs\BlueJ\Assignment 3\CodedMessage.txt
        String file2 = in.nextLine(); //grabbing coded message file path
        File messFile = new File(file2);
        Scanner inFile2 = new Scanner(messFile).useDelimiter("\\n");//scanner to read each line of coded message

        int wordCount = 0;//variable to store how many words are in message

        while(inFile2.hasNext()){
            messWord += inFile2.next();//adds each coded word into a string
            wordCount++; //increse value to account for number of words found
        }

        Scanner codedWord = new Scanner(messWord);//scanner to read messWord string

        String[] morseLetter = new String[69];//defining array where each coded character is stored
        //System.out.println(Arrays.toString(morseLetter));

        int charCount = 0; //variable to store how many characters are found
        while(codedWord.hasNext()){ 
            morseLetter[charCount] = codedWord.next(); //grabs next chacacter of the coded word
            //System.out.println(Arrays.toString(morseLetter));
            charCount++; //increases value to account for numer of characters found
        }   
        //System.out.println(messWord);

        //Incretment 3: translates coded characters into english then formats a string before writing in output file 
        System.out.print("Enter decoded message output file path: ");
        String file3 = in.nextLine();//grabs input of decoded message file path

        System.out.println("Message translation complete. " + wordCount + " words processed."); //string to comfirm message file was read, and how many words were found

        int morseComp = 0;//value that stores what character in the coded message is being compared

        for(int dicComp = 0; dicComp < codeArray.length; ){//loops through the morsecode translation array while checkind coded message character
            if(morseComp != 69 && morseLetter[morseComp].equals(codeArray[dicComp])){ //compares the coded character to the morsecode translation array 
                decodedMess += letterArray[dicComp];//decoded letter is 
                dicComp = 0;//resets translation file index to start at begining
                morseComp++;//increses index to next coded character
                //System.out.println(decodedMess);
                //System.out.println(Arrays.toString(decodedArry));
            }else{
                dicComp++; //increase value to check next index in translation arrays
            }            
        }

        String[] decodedArry = new String[17]; //array to hold each decoded word
        decodedArry[0] = decodedMess.substring(0,4);//grabs the substring index of each specific word
        decodedArry[1] = decodedMess.substring(4,6);
        decodedArry[2] = decodedMess.substring(6,7);
        decodedArry[3] = decodedMess.substring(7,11);
        decodedArry[4] = decodedMess.substring(11,19);
        decodedArry[5] = decodedMess.substring(19,21);
        decodedArry[6] = decodedMess.substring(21,24);
        decodedArry[7] = decodedMess.substring(24,27);
        decodedArry[8] = decodedMess.substring(27,31);
        decodedArry[9] = decodedMess.substring(31,38);
        decodedArry[10] = decodedMess.substring(38,42);
        decodedArry[11] = decodedMess.substring(42,44);
        decodedArry[12] = decodedMess.substring(44,48);
        decodedArry[13] = decodedMess.substring(48,52);
        decodedArry[14] = decodedMess.substring(52,56); 
        decodedArry[15] = decodedMess.substring(56,63);
        decodedArry[16] = decodedMess.substring(63,69);

        //System.out.println(Arrays.toString(decodedArry));

        String formatedMess = "";//holds formated decoded message as string

        for(int formatCount = 0; formatCount < 17; formatCount++){ //for loop to structure the decoded message string
            formatedMess += (decodedArry[formatCount] + " ");
            if(formatCount == 4){
                formatedMess += "\n";
            }  
        }

        //System.out.print(formatedMess);

        PrintWriter printWriter = new PrintWriter(file3);//selecting file location to output to
        printWriter.print(formatedMess);//writing the formated string to the output file
        printWriter.close();//closes file

    }
}
