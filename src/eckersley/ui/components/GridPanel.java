package eckersley.ui.components;

import javax.swing.*;
import java.awt.*;

public class GridPanel extends JPanel {


    public GridPanel(int x, int y){

        setLayout(new GridLayout(x,y));
    }

}

