/**
 * @author Mariamwit Filfile
 * CS 5160, Fall 2022
 * Project 3
 */
package filfile_project_3;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program reads words from a file and displays the word in a sorted order
 * and also will keep track of the number of times each word appeared in the
 * text.
 */
public class Project3 
{

    /**
     * opens and reads from file and displays the information in the output
     * file.
     * @param args
     * @throws FileNotFoundException checks whether the file denoted pathname
     * has failed or not
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        //Open the input file and check for the existance
        File myFile = new File("project3.txt");
        if (!myFile.exists())
        {
            System.out.println("The file is not found");
            System.exit(0);
        }
        Scanner inputFile = new Scanner(myFile);
        
        //declare an array of linked lists to use as the dictionary
        LinkedList<DictionaryItem>[] dictionary = new LinkedList[26];
        //create each list
        for (int i = 0; i < 26; i++) 
        {
            dictionary[i] = new LinkedList<>();
        }
        
        //declare variable to store the words in 
        String word;
        String readWord;
        
        //read the text one word at a time from the file word by word
        while (inputFile.hasNext())
        {
            readWord = inputFile.next();
            //Call a method to convert each word read to lower case and remove any ending punctuation
            word = convertToLowerRemovePunctuation(readWord);
            // Call a method to insert the word or update the word count in the dictionary    
            insertandUpdateWord(dictionary, word);
        }
        
        // Call a method to write the dictionary to a text file 
        displaytoTextFile(dictionary);
        
        //Output a message to the console when the program is finished.
        System.out.println("Program complete. Dictionary has been written to the file 'dictionary.txt'");
        //close the inputFile
        inputFile.close();

    }//main end

    /**
     * convertToLowerRemovePunctuation method converts each word read to lower
     * case and removes any ending punctuation
     * @param word indicates the words that are going to be converted
     * @return each words that are converted to lower case
     */
    public static String convertToLowerRemovePunctuation(String word)
    {
        String eachword;
        String words;
        words = word.replaceAll("\\p{Punct}", "");
        eachword = words.toLowerCase();
        return eachword;
    }

    /**
     * insertandUpdateWord method inserts the word in the dictionary and if the
     * word is already in the list , the number of occurrences for that word in
     * the list is updated.
     * @param listofDictionary are list of arrays that store the words that are
     * read from the file
     * @param words are the words from that are from the file
     */
    public static void insertandUpdateWord(LinkedList<DictionaryItem>[] listofDictionary, String words)
    {
        int wordCount;
        DictionaryItem update;
        DictionaryItem d1 = new DictionaryItem(words);
        int i = (int) words.charAt(0) - (int) 'a';
        update = listofDictionary[i].retrieveItem(d1);
        if (!d1.equals(update)) 
        {
            listofDictionary[i].insertItem(d1);
        }
        else 
        {
            wordCount = update.getNumOccurence();
            wordCount++;
            update.setNumOccurence(wordCount);
        }

    }

    /**
     * displaytoTextFile method writes the dictionary to a text file
     * @param listofDictionary stores words in this list of arrays
     * @throws FileNotFoundException checks whether the file denoted pathname
     * has failed or not
     */
    public static void displaytoTextFile(LinkedList<DictionaryItem>[] listofDictionary) throws FileNotFoundException 
    {
        //open a new file to display the informations in.
        PrintWriter outputFile = new PrintWriter("dictonary.txt");
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i = 0; i < 26; i++)
        {
            outputFile.println(letters[i] + ": " + listofDictionary[i]);
        }
        outputFile.close();
    }
}//class end
