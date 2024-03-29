package Assignment.controller;

import java.io.IOException;
import Assignment.model.*;

public class Worker {
    public static void main(String[] args) {
        FileIO io = new FileIO();
        MainTree tree = new MainTree();
        String inputFileName;
        String outputFileName;
        try {
            if(args[0].equalsIgnoreCase("-g")) { //Generate
                if(args[1].equalsIgnoreCase("-d"))  { // Display

                }
                else if(args[1].equalsIgnoreCase("-w")) { // Write
                    if(args[2] != null) {
                        outputFileName = args[2];
                    }
                    else {
                        throw new IllegalArgumentException("No output file!");
                    }

                }
            }
            else if(args[0].equalsIgnoreCase("-r")) { // Read from file
                if(args[1] != null) {
                    inputFileName = args[1]; // Input data
                    System.out.println("reading " + inputFileName);
                    tree = io.readFile(inputFileName);
                }
                else if(args[1] == null) {
                    throw new IllegalArgumentException("No input file!");
                }

                if(args[2].equalsIgnoreCase("-d")) {
                    if(tree.isEmpty()) {
                        System.out.println("Tree is empty!");
                    }
                    else {
                        System.out.println("DISPLAY TREE");
                        tree.displayTree();
                        System.out.println("\nDISPLAY TOTAL CONSUMPTIONS");
                        tree.displayTotalPowerConsumption();
                    }
                    
                }
                else if(args[2].equalsIgnoreCase("-w")) {
                    if(args[3] != null) {
                        outputFileName = args[3]; // Output data
                    }
                    else {
                        throw new IllegalArgumentException("No output file!");
                    }
                }
            }

        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e);
        }
    }
}
