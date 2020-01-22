package eckersley.ui.components;

import eckersley.apis.HTTPClient;
import eckersley.ui.UIHandler;

import javax.swing.*;
import java.awt.*;

public class CustomMainFrame extends JFrame {


    GridPanel splitPanel;

    HTTPClient client;
    public CustomMainFrame(){
        client = new HTTPClient();

        setMinimumSize(new Dimension(1280,720));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addComponents();
        start();
    }
    private void start(){
        this.pack();
        this.setVisible(true);
    }
    private void addComponents(){

        splitPanel = new GridPanel(1,1);
        splitPanel.add(new CustomPanel(client));

        //splitPanel.add(new CustomPanel());
        add(splitPanel);


    }


}
