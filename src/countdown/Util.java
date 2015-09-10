/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdown;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Util {
    public static void merge(ArrayList<Integer>list1, ArrayList<Integer>list2, ArrayList<Integer> destination){
        destination.clear();
        int i=0;
        int size1 = list1.size();
        boolean idone = false;
        int i2=0;
        int size2 = list2.size();
        boolean i2done = false;
        
        while(!idone || !i2done){
            if(idone){
                destination.add(list2.get(i2));
                i2++;
                if(i2==size2)
                    i2done = true;
            }
            else if(i2done){
                destination.add(list1.get(i));
                i++;
                if(i==size1)
                idone = true;
            }
            else{
                int n = list1.get(i);
                int n2 = list2.get(i2);
                if(n<=n2){
                    destination.add(n);
                    i++;
                if(i==size1)
                    idone = true;
                }
                else{
                    destination.add(n2);
                    i2++;
                if(i2==size2)
                    i2done = true;
                
                }
            }    
        }  
    }
        
    public static boolean noneShared(ArrayList<Integer> list1, ArrayList<Integer> list2){
        
        for(int i=0; i<list1.size(); i++){
            for(int j=0; j<list2.size(); j++){
                if(list1.get(i)==list2.get(j))
                    return false;
            }
        }
        return true;
        
    }
    public static boolean unorderedEqual(ArrayList<Integer> list1, ArrayList<Integer> list2){
        
        int list1Size = list1.size();
        int list2Size = list2.size();
        
         if(list1Size!=list2Size)
            return false;
         
        ArrayList<Integer> tempList = new ArrayList<>();
        for(int i=0; i<list1Size; i++)
            tempList.add(list1.get(i));
        
        for(int i=0; i<list2Size; i++){
            for(int j = 0; j<tempList.size(); j++){
                if(list2.get(i)==tempList.get(j)){
                    tempList.remove(j);
                    break;
                }
                if(j==tempList.size()-1){
                    return false;
                }
                
            }
        }
        
        
        return true;
    }
    public static DefaultTableModel genTableModelFromCalcList(ArrayList<CalcSequence> list,String[] columnNames){
        ArrayList<String[]> rows = new ArrayList<>();
        for(CalcSequence seq: list){
            String[] tempArray = {seq.toString(),Double.toString(seq.getSize()),seq.getNumbersUsed().toString(),Double.toString(seq.total())};
            rows.add(tempArray);
        }
        Object[][] data = new Object[rows.size()][list.size()];
        for(int i = 0; i<rows.size(); i++){
            data[i] = rows.get(i);
        }
        return new DefaultTableModel(data,columnNames){

             @Override
             public boolean isCellEditable(int rowIndex, int columnIndex) {
             return false;
            }
        };
    }
}
