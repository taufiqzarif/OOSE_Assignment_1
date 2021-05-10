package Assignment.model;
import java.io.*;
import java.util.*;

public class FileIO {
    private String key;

    public void readFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        MainTree tree = new MainTree();
        while(line!=null) {
            String[] parts = line.split(",",3);
            System.out.println("Line now is: " + line);
            System.out.println("Total parts: " + parts.length);
            if(parts.length == 1) { // Line is the root
                System.out.println("Running parts = 1");
                System.out.println("parts[0] = " + parts[0]);
                tree.insertNode(parts[0], parts[0], null);
            }
            else if(parts.length == 2) {
                System.out.println("Running parts = 2");
                System.out.println("parts[0] = " + parts[0] + ", parts[1] = " + parts[1]);
                tree.insertNode(parts[0], parts[1], null);
            }
            else if(parts.length > 2) {
                System.out.println("Running parts > 2");

                // String[] category = new String[parts.length-2];
                // int j = 0;
                // for(int i = 2; i < parts.length; i++) {
                //     category[j] = parts[i];
                //     System.out.println("Category [" + j + "] is " + parts[i]);
                //     j++;
                // }
                String category = "";
                category = parts[2];
                System.out.println("cat: " + category);
                System.out.println("parts[0] = " + parts[0] + ", parts[1] = " + parts[1]);
                tree.insertNode(parts[0], parts[1], category);
                
//                tree.insertNode(parts[0], parts[1], null);
            }
            System.out.println("exit: " + line);
            System.out.println();
            line = reader.readLine();
            
        }
        reader.close();
    }
}
