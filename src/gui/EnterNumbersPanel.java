/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class EnterNumbersPanel extends JPanel{
    ArrayList<JTextField> fields;
    int numberOfFields;
    public EnterNumbersPanel(){
        fields = new ArrayList<>();
        setNumberOfInputs(6);
        setLayout(new GridLayout());
    }
    public void setNumberOfInputs(int n){
        numberOfFields = n;
        removeAll();
        fields.clear();
        for(int i=0; i<numberOfFields; i++){
            fields.add(new JTextField());
            add(fields.get(i));
        }
        
    }
    public int[] getNumbers(){
        int[] ints = new int[fields.size()];
        for(int i=0; i<fields.size(); i++){
            ints[i] = Integer.parseInt(fields.get(i).getText());
        }
        return ints;
    }
}
