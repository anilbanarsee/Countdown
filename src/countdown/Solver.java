/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdown;

import gui.MainPanel;
import gui.ResultsFrame;
import gui.ResultsPanel;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Solver {
    
    int[] numbers;
    int target;
    int expansionLevel;
    ArrayList<CalcSequence> calcList;
    public boolean allowRepeats = false;
    ResultsFrame mainPanel;
    boolean hasMainPanel;
    
    
    public Solver(int[] numbers, int target)
    {
        this.numbers = numbers;
        this.target = target;
        expansionLevel = 1;
        calcList = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++){
            calcList.add(new CalcSequence(numbers[i],i));
        }
    }
    public Solver(int[] numbers, int target, ResultsFrame mp){
        this(numbers, target);
        hasMainPanel = true;
        mainPanel = mp;
    }
    
    public void expand(){
        expansionLevel ++;
        int calcListSize = calcList.size();
        for(int i = 0; i<calcListSize; i++)
        {
            for(int j = 0; j<calcListSize; j++)
            {
                if(calcList.get(i).getSize() + calcList.get(j).getSize() == expansionLevel)
                {
                    if((Util.noneShared(calcList.get(i).getIDsUsed(), calcList.get(j).getIDsUsed())))
                    {
                        
                        CalcSequence tempSeq = calcList.get(i).add(calcList.get(j));
                        double value = tempSeq.total();
                        
                        if(value == target && allowRepeats){
                            if(hasMainPanel){
                                mainPanel.addSolution(tempSeq);
                                mainPanel.revalidate();
                                mainPanel.repaint();
                            }
                            
                            System.out.println(tempSeq);
                            
                        }
                        if(!(tempSeq.getNumbersUsed().contains((int) Math.round(value)))){
                             if(!nameNumberSameValue(tempSeq)){
                                if(value == target){
                                    if(hasMainPanel){
                                        mainPanel.addSolution(tempSeq);
                                    }
                                    else{
                                        System.out.println(tempSeq);
                                    }
                                }
                                calcList.add(tempSeq);
                            }
                        }
                       
                        
                        tempSeq = calcList.get(i).multiply(calcList.get(j));
                        value = tempSeq.total();
                        
                        if(value == target && allowRepeats){
                            if(hasMainPanel){
                                mainPanel.addSolution(tempSeq);
                            }
                            else{
                                System.out.println(tempSeq);
                            }
                        }
                        if(!(tempSeq.getNumbersUsed().contains((int) Math.round(value)))){
                            if(!nameNumberSameValue(tempSeq)){
                                if(value == target){
                                    if(hasMainPanel){
                                        mainPanel.addSolution(tempSeq);
                                    }
                                        else{
                                        System.out.println(tempSeq);
                                    }
                                }
                                calcList.add(tempSeq);
                            }
                        }
                        
                        tempSeq = calcList.get(i).subtract(calcList.get(j));
                        value = tempSeq.total();
                        
                        if(value == target && allowRepeats){
                            if(hasMainPanel){
                                mainPanel.addSolution(tempSeq);
                            }
                            else{
                                System.out.println(tempSeq);
                            }
                        }
                        if(!(tempSeq.getNumbersUsed().contains((int) Math.round(value)))){
                             if(!nameNumberSameValue(tempSeq)){
                                if(value == target){
                                    if(hasMainPanel){
                                         mainPanel.addSolution(tempSeq);
                                    }
                                    else{
                                        System.out.println(tempSeq);
                                    }
                                }
                                calcList.add(tempSeq);
                            }
                        }
                        
                        
                        tempSeq = calcList.get(i).divide(calcList.get(j));
                        value = tempSeq.total();
                       
                        if(value == target && allowRepeats){
                           if(hasMainPanel){
                                mainPanel.addSolution(tempSeq);
                            }
                            else{
                                System.out.println(tempSeq);
                            }
                        }
                        if(!(tempSeq.getNumbersUsed().contains((int) Math.round(value)))){
                            if(!nameNumberSameValue(tempSeq)){
                                
                                if(value == target){
                                    if(hasMainPanel){
                                        mainPanel.addSolution(tempSeq);
                                    }
                                    else{
                                        System.out.println(tempSeq);
                                    }
                                }
                                calcList.add(tempSeq);
                            }
                        }
                        
  
                        
                    }  
                }
            }
        }
    }
    public boolean nameNumberSameValue(CalcSequence tempSeq){
         for(CalcSequence cs : calcList){
             if(cs.total()==tempSeq.total())
                if(Util.unorderedEqual(cs.getNumbersUsed(),tempSeq.getNumbersUsed()))
                    return true;
            }
         return false;
    }
         
    
}
