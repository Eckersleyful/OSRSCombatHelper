package eckersley.ui.components;

import eckersley.apis.HTTPClient;
import eckersley.apis.jsonObjects.Item;
import eckersley.ui.UIHandler;

import javax.swing.*;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.HashMap;
import java.util.Vector;

public class CustomPanel extends JPanel{

    JComboBox dropDown;
    //HashMap<String, CustomComboBox> boxMap = new HashMap<String, CustomComboBox>();
    //private final String[] itemSlots = new String[]{"2h", "ammo", "body", "cape", "feet", "hands", "head", "legs", "neck", "ring", "shield", "weapon"};
    //boxMap.put("2h", new CustomComboBox());

    public CustomPanel(HTTPClient client){
        addComponents(client);
    }


    private void addComponents(HTTPClient client) {

        DefaultComboBoxModel model = new DefaultComboBoxModel<Object>(client.getItemBySlot("2h").toArray());
        JComboBox<Object> test = new JComboBox<>(model);
        test.setRenderer(new ItemRenderer());

        String[] testDrop =  {"Kissa", "Koira", "Omena", "X", "Z"};
        //dropDown = new JComboBox(testDrop);

        add(new JComboBox(testDrop));
        add(test);
    }
}

class ItemRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
        JLabel label = (JLabel)super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if(value != null && value instanceof Item){
            Item item = (Item) value;
            label.setText(item.getItemName());

            if(isSelected){
                label.setBackground(Color.blue);
                label.setForeground(Color.white);
            }
            else{
                label.setBackground(Color.white);
                label.setForeground(Color.black);
            }
        }

        return label;
    }
}
