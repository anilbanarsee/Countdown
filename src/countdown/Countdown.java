/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdown;

import gui.MainFrame;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Countdown {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InvalidOperatorException {
       
        
      /*   int[] numbers = {1,2,3};
        ArrayList<CalcSequence> calcs = new ArrayList<>();
        for(int i =0; i<numbers.length; i++){
            calcs.add(new CalcSequence(numbers[i],i));
        }
        
        CalcSequence seq1 = new CalcSequence(5,3);
        CalcSequence seq2 = seq1.add(calcs.get(0)).divide(calcs.get(1)).multiply(calcs.get(2));
        System.out.println(seq2.total());
        System.out.println(seq2.getIDsUsed());
        System.out.println(seq2);
        System.out.println(seq2.getSize());
        System.out.println(seq2.getSize());*/
        
        /*ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        
        list1.add(5);
        list1.add(5);
        list1.add(5);
        list1.add(5);
        
        list2.add(5);
        list2.add(5);
        list2.add(5);
        list2.add(5);
        
        if(Util.unorderedEqual(list1, list2)){
            System.out.println("Equal");
        }*/
       /* 
        int[] numbers = {5,3,9,2,7,1};
        int target = 15;
        Solver solver = new Solver(numbers,target);
        solver.allowRepeats = false;
        
        solver.expand();
        solver.expand();
        solver.expand();
        solver.expand();
        solver.expand();
        solver.expand();
        solver.expand();
       
        
        
        ArrayList<Integer> list = new ArrayList<>();

        */
        new MainFrame();
       /* ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> destination = new ArrayList<>();
        
        list1.add(2);
        list1.add(4);
        list1.add(6);
        
        list2.add(1);
        list2.add(3);
        list2.add(5);
        list2.add(6);
        
        Util.merge(list1, list2, destination);
        System.out.println(destination);*/
    }
    
}
