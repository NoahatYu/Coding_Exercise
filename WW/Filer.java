import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class Filer {

    /**
     * Question 1:
     * ----------
     *
     * There is a file containing a word and its possible meanings (like a Dictionary). The contents of the file look like this:
     *
     * Apple – a fruit, a tech firm
     * Table – an object, contains rows and columns when used in context of computers
     * Orange – a fruit
     *
     * Given a path to the file, do the following:
     *
     * a)    Create a method called doesFileExist(String path) which takes the path of the file and tells the user if the file exists at that path or not. Assume all paths are relative to your project structure. If the file does not exist, catch the requisite exception.
     * b)    Read each word and its possible meanings and print them out. Your output should look like this:
     *
     * Word1
     * Meaning 1
     * Meaning 2
     * Word2
     * Meaning1
     * Meaning2
     *
     * Use appropriate data structures wherever necessary.
     *
     */

    public Filer(){
        //Empty Constructor
    }

    /**
     * Takes the path of the file and tells the user if the file exists at that path or not.
     * Assume all paths are relative to your project structure.
     * If the file does not exist, catch the requisite exception.
     * @param fp file path
     * @return true if the file exists and false otherwise
     */
    public boolean doesFileExist(String fp){
        File file = new File(fp);
        if(file.isFile()){//Check if file is there and is a file and not a directory
            System.out.println("File exists");
            return true;
        }else{
            System.err.println("ERROR: File does not exist");
            return false;
        }

    }

    /**
     * Read each word and its possible meanings and print them out.
     * Your output should look like this:
     * Word1
     * Meaning 1
     * Meaning 2
     * Word2
     * Meaning1
     * Meaning2
     */
    public void outputFile(String fp){
        HashMap<String,String> dict = new HashMap<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fp));
            //scanner.useDelimiter("-");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (scanner != null) {
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] dictEntry = line.split("-");
                dict.put(dictEntry[0],dictEntry[1]);
            }
        }
        dict.forEach((k,v) -> {
            System.out.println(k);
            if(v.contains(",")){//if there is more than one value
                String[] values = v.split(",");
                for(String value : values){//print all meanings of word
                    System.out.println(value.substring(1));//substring to remove space at beginning when spliting
                }
            }else{
                System.out.println(v.substring(1));
            }
        });


    }


    public static void main(String[] args) {
        Filer filer = new Filer();
        //Scanner to get user input
        System.out.println("Enter file path: ");
        Scanner in = new Scanner(System.in);
        String filePath = in.nextLine();
        if(filer.doesFileExist(filePath)){
            filer.outputFile(filePath);
        }
    }
}
