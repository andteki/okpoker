/*
* File: App.java
* Author: Sallai András
* Original from repoker, from Nagy József
* Copyright: 2021, Sallai András 
* Date: 2021-09-13
* Licenc: MIT
*
*/

import controllers.MainController;
import views.MainWindow;

public class App { 
    public static void main(String[] args) throws Exception { 
        MainWindow mainWindow = new MainWindow();
        new MainController(mainWindow); 
        mainWindow.setVisible(true);
    }
}
