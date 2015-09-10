/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class MainFrame extends JFrame{
    
    MainPanel mainPanel;
    
    public MainFrame(){
        setSize(500,500);
        setTitle("Countdown Solver v.1");
        setVisible(true);
         mainPanel = new MainPanel(this);
        add(mainPanel);
        
        mainPanel.setNumberOfInputs(8);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        System.out.println("Hello");
    }
    
}
