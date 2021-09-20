package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainModel {

    public MainModel() {
    }
    
    public ArrayList<String> readState() {
        ArrayList<String> lines = new ArrayList<>();
        try {
            lines = tryReadState();    
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található");
        }
        return lines;
    }
    public ArrayList<String> tryReadState() throws FileNotFoundException {
        ArrayList<String> lines = new ArrayList<>();
        Scanner scanner = openFile();
        while(scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        return lines;
    }
    public Scanner openFile()throws FileNotFoundException {
        FileReader fileReader = new FileReader("state.txt");
        Scanner scanner = new Scanner(fileReader);
        return scanner;
    }

    
}
