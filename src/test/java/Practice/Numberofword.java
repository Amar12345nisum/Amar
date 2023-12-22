package Practice;

import org.junit.Test;

public class Numberofword {
    @Test
    public static void main(String[] args) {
        String string = "Naga Venkata Amarendra Reddy";
        int count = 0;

        //Counts each character except space
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) != ' ')
                count++;
        }

        //Displays the total number of characters present in the given string
        System.out.println("Total number of characters in a string: " + count);
    }


    @Test
    public static void reverse (String[] args) {

        String str= "Geeks", nstr="";
        char ch;

        System.out.print("Original word: ");
        System.out.println("Geeks"); //Example word

        for (int i=0; i<str.length(); i++)
        {
            ch= str.charAt(i); //extracts each character
            nstr= ch+nstr; //adds each character in front of the existing string
        }
        System.out.println("Reversed word: "+ nstr);
    }
}
