package models;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainModel {

    public MainModel() {
    }

    public ArrayList<Player> getList() {
        ArrayList<Player> playerList = new ArrayList<>();
        ArrayList<String> lines = readState();
        for(String line: lines) {
            String[] lineArray = line.split(":");
            Player player = new Player();
            player.setName(lineArray[0]);
            player.setCredit( Integer.parseInt(lineArray[1]));
            playerList.add(player);
        }
        return playerList;
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
