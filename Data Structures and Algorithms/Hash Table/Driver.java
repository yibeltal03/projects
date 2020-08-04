import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

    public static String[] readFile(String name){

        Scanner readFile = null;
        String s;
        int count = 0;

        //System.out.println();
        //System.out.println("Attempting to read from file: " + name);
        try {
            readFile = new Scanner(new File(name));
        }
        catch (FileNotFoundException e) {
            //System.out.println("File: " + name + " not found");
            //System.exit(1);
        }

        //System.out.println("Connection to file: " + name + " successful");
        //System.out.println();

        while(readFile.hasNext()){
            s = readFile.next();
            count++;
        }
        String[] hashArr = new String[count];

        try {
            readFile = new Scanner(new File(name));
        }
        catch (FileNotFoundException e) {
            //System.out.println("File: " + name + " not found");
           // System.exit(1);
        }

        count = 0;
        while (readFile.hasNext()) {
            s = readFile.next();
            hashArr[count] = s;

            //System.out.println("Token found: " + s);
            count++;
        }

        //System.out.println();
        //System.out.println(count + " Tokens found");
       // System.out.println();

        return hashArr;
    }
    public static void main(String[] args){
        String[] newArr = readFile("keywords.txt");

        Hash obj = new Hash();
        for(int y = 0; y < newArr.length; y++){
            //System.out.println(newArr[y]);
            obj.add(newArr[y]);
        }
        obj.display();
        System.out.println("max");
        obj.max();
        System.out.println("max");


        Hash obj2 = new Hash();
        for(int y = 0; y < newArr.length; y++){
            //System.out.println(newArr[y]);
            obj2.add1(newArr[y]);
        }
        obj2.display();
        obj2.max();



    }

}
