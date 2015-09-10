/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import countdown.CalcSequence;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class ResultsFrame extends JFrame{
    ResultsPanel rp;
    public ResultsFrame(){
        rp = new ResultsPanel();
        add(rp);
        setVisible(true);
        setTitle("Results");
        setSize(400,400);
    }
    
    public void setResultsToTable(){
        rp.setResultsToTable();
        revalidate();
        repaint();

    }
    public void addSolution(CalcSequence seq){
        rp.addSolution(seq);
        
    }
}
