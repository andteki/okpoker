/*
* File: MainController.java
* Author: Sallai András
* Original from repoker, from Nagy József
* Copyright: 2021, Sallai András 
* Date: 2021-09-13
* Licenc: MIT
*
*/

package controllers;

import java.util.ArrayList;
import java.util.Random;

import models.MainModel;
import models.Player;
import views.MainWindow;

public class MainController {

    MainWindow mainWindow;
    String[] cards = {
        "2", "3", "4", "5", "6", "7", "8", 
        "9", "10", "B", "D", "K", "A"
    };
    Deal round = Deal.PREFLOP;

    enum Deal  {
        PREFLOP,
        FLOP,
        TURN,
        RIVER,
        SHOW
    }

    

 

    public MainController(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        this.initEvent();
        MainModel mainModel = new MainModel();
        
        // mainModel.getList().get(1).getName()

        ArrayList<Player> playerList = mainModel.getList();
        Player player = playerList.get(1);
        System.out.println(player.getName());


        System.out.println(); 
    }

  
    //TODO: A stopBtn majd a következő kört (round) generálja
    public void initEvent() {
        this.mainWindow.startBtn.addActionListener(
            event -> {
                Random random = new Random();

                int humanCard1 = random.nextInt(13);
                int humanCard2 = random.nextInt(13);
                int computerCard1 = random.nextInt(13);
                int computerCard2 = random.nextInt(13);

                random = null;
                String humanCard1Str = cards[humanCard1];
                String humanCard2Str = cards[humanCard2];
                this.mainWindow.humanCard1Btn.setText(humanCard1Str);
                this.mainWindow.humanCard2Btn.setText(humanCard2Str);


                System.out.printf(
                    "%d %d\n", humanCard1, humanCard2);

            });
        this.mainWindow.stopBtn.addActionListener (
            event -> {                
                System.out.println("Állj");
            });


        /* TODO: A kártya színeket is le kell generálni
        ♠ ♥ ♦ ♣
        Ezt majd egy kártyageneráló függvényben valósítjuk meg
        */            

        this.mainWindow.nextBtn.addActionListener(
            event -> {

                if (this.round == Deal.PREFLOP) {                    
                    makeFlop();
                    return; //Kilépünk, mert végrehajtódik következő is
                }
                if (this.round == Deal.FLOP) {
                    makeTurn();
                    return;
                }
                if (this.round == Deal.TURN) {
                    makeRiver();
                }
            }
        );

    }
    private void makeFlop() {
        String flop1Str;
        String flop2Str;
        String flop3Str;        
        int flop1=getRandom();
        int flop2=getRandom();
        int flop3=getRandom();
        
        //TODO: a jobb oldal mehet rögtön a setText()-be
        flop1Str=cards[flop1];
        flop2Str=cards[flop2];
        flop3Str=cards[flop3];
        

        this.mainWindow.flop1Btn.setText("♦" + flop1Str);
        this.mainWindow.flop2Btn.setText(flop2Str);
        this.mainWindow.flop3Btn.setText(flop3Str);
        this.mainWindow.flop1Btn.setVisible(true);
        this.mainWindow.flop2Btn.setVisible(true);
        this.mainWindow.flop3Btn.setVisible(true);
        this.round = Deal.FLOP;
    }

    private void makeTurn() {
        int turn = getRandom();
        this.mainWindow.turnButton.setText(cards[turn]);
        this.mainWindow.turnButton.setVisible(true);
        this.round=Deal.TURN;        
    }

    private void makeRiver() {
        int river=getRandom();
        this.mainWindow.riverButton.setText(cards[river]);
        this.mainWindow.riverButton.setVisible(true);
        this.round = Deal.RIVER;
    }

    private int getRandom() {
        Random random = new Random();
        return random.nextInt(13);
    }
  

}
