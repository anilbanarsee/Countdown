/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countdown;

import java.util.ArrayList;

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
}
