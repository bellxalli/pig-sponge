// import java.util.ArrayList;
import java.util.*;

public class Sponge {

  /*
   * Create a method "spongeCase" that takes a string consisting of one or more words 
   * separated by spaces. It should return a new string converted to "sponge 
   * case," where each word starts with a lowercase letter, and then alternates 
   * between upper and lower case for each following letter in the word.
   *
   * Examples:
   *
   * spongeCase("spongebob")  should return "sPoNgEbOb"
   * spongeCase("Who are YOU calling A Pinhead")  should return "wHo aRe yOu cAlLiNg a pInHeAd"
   * spongeCase("WHAT is UP my dude")  should return "wHaT iS uP mY dUdE"
   * spongeCase("debí tirar más fotos") should return dEbÍ tIrAr mÁs fOtOs" (note the accents)
   * spongeCase("E")  should return "e"
   * spongeCase("e")  should return "e"
   * 
   * Hints:
   * There exist the following methods in java:
   * Character.toUpperCase() (e.g. Character.toUpperCase('f'))
   * Character.toLowerCase() (e.g. Character.toLowerCase('Q'))
   * .toCharArray() String method (e.g. myString.toCharArray())
   */
  public static void main(String[] args) {
    // Test cases
    assertEqual(1, spongeCase("spongebob"), "sPoNgEbOb");
    assertEqual(2, spongeCase("Who are YOU calling A Pinhead"), "wHo aRe yOu cAlLiNg a pInHeAd");
    assertEqual(3, spongeCase("WHAT is UP my dude"), "wHaT iS uP mY dUdE");
    assertEqual(4, spongeCase("debí tirar más fotos"), "dEbÍ tIrAr mÁs fOtOs");
    assertEqual(5, spongeCase("E"), "e");
    assertEqual(6, spongeCase("e"), "e");
  }

  // Implement your solution here!
  public static String spongeCase(String sentence) {
    /*
     * create list to go through sentence 
     * use list to break up words
     * go through list and also go throug words turn into spongecase
     * put sentence backtogether and print
     * 
     * maybe use if statements to make simpler
     */

     //initial solution 
    // char [] charList;
    // sentence = sentence.toLowerCase();  
    // charList = sentence.toCharArray();
    // int spaceCount = 0;

    // for(int i = 0; i < charList.length; i++)
    // {
    //   if((charList[i] != ' ') && ((i-spaceCount) % 2 != 0))
    //   {
    //     charList[i] = Character.toUpperCase(charList[i]);
    //   }
    //   else if((charList[i] != ' ') && ((i-spaceCount) % 2 == 0))
    //   {
    //     charList[i] = Character.toLowerCase(charList[i]);
    //   }
    //   else
    //   {
    //     spaceCount++;
    //   }
    // }
    // String newSentence = ""; //how far i got in 30 initial mins

    // for(int i = 0; i < charList.length; i++)
    // {
    //   if(charList[i] != ' ')
    //   {
    //     newSentence += charList[i];
    //   }
    //   else
    //   {
    //     newSentence += " ";
    //   }
    // }

    //revised solution
    String[] words = sentence.split(" ");
    String newSentence = "";
    List <String> newWords = new ArrayList<>();

    for(String word : words)
    {
      String newWord = "";
      if(word != " ")
      {
        char [] chars = word.toCharArray();
        for(int i = 0; i < chars.length; i++)
        {
          if(i % 2 != 0) 
          {
            chars[i] = Character.toUpperCase(chars[i]);
            //System.out.println(chars[i]);
          }
          else if(i % 2 == 0)
          {
            chars[i] = Character.toLowerCase(chars[i]);
           // System.out.println(chars[i]);
          }
        }
        for(char c : chars)
        {
          newWord += c;
        }
        newWords.add(newWord);
        //System.out.println(newWord);
      }
    }

    for(String word : newWords)
    {
      newSentence += word + " ";
    }

    return newSentence.substring(0, newSentence.length()-1);
  }


  // Method to help with testing, you do not need to read this.
  public static void assertEqual(int testNumber, String actual, String expected) {
    if (!expected.equals(actual)) {
      System.out.println("Test " + testNumber + " failed! Expected: '" + expected + "', but got: '" + actual + "'");
    } else {
      System.out.println("Test " + testNumber + " passed!");
    }
  }
}