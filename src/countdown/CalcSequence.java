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
public class CalcSequence {
   public CalcSequence seq1,seq2;
   private char operator;
   public double value;
   public boolean valueCalced = false;
   public boolean singular;
   boolean NBN;
   boolean onlyAdd = true;
   boolean onlyMult = true;
   int ID;
   ArrayList<Integer> IDsUsed;
   boolean knowIDs = false;
   ArrayList<Integer> numbersUsed;
   boolean knowNumbers = false;
   int size;
   boolean knowSize = false;
   
   public CalcSequence(){
       IDsUsed = new ArrayList<>();
       numbersUsed = new ArrayList<>();
   }
   public CalcSequence(int v)
   {
       this();
       value = v;
       singular = true;
       valueCalced = true;
       knowIDs = true;
       size = 1;
       knowSize = true;
       numbersUsed.add(v);
       knowNumbers = true;
       
   }
   
   public CalcSequence(int v, int n){
       this(v);
       ID = n;
       IDsUsed.add(n);
       knowIDs = true;
   }
   
   public CalcSequence(CalcSequence seq1, CalcSequence seq2, char op)
   {
       this();
       this.seq1 = seq1;
       this.seq2 = seq2;
       operator = op;
       singular = false;
       if(!seq1.onlyAdd||!seq2.onlyAdd)
           onlyAdd = false;
       
       if(!seq1.onlyMult||!seq2.onlyMult)
           onlyMult = false;
       
       if(op!='+')
           onlyAdd = false;
       
       if(op!='*')
           onlyMult = false;
       
       
       
   }
   public CalcSequence(CalcSequence seq1, CalcSequence seq2, char op, double value)
   {
       this(seq1,seq2,op);
       this.value = value;
       valueCalced = true;
       numbersUsed = new ArrayList<>();
   }
   public double total()
   {
       if(valueCalced)
           return value;
       
       if(singular)
           return value;
           
       if(operator == '+')
           return seq1.total() + seq2.total();
       
       if(operator == '-')
           return seq1.total() - seq2.total();
       
       if(operator == '/')
           return seq1.total() / seq2.total();
       
       if(operator == '*')
           return seq1.total() * seq2.total();
       
       return -123;
               
   }
   public ArrayList<Integer> getIDsUsed(){
       if(knowIDs)
           return IDsUsed;
       
       Util.merge(seq1.getIDsUsed(),seq2.getIDsUsed(),IDsUsed);
       return IDsUsed;
   }
   
   public ArrayList<Integer> getNumbersUsed(){
       if(knowNumbers){
           return numbersUsed;
       }
       
       Util.merge(seq1.getNumbersUsed(),seq2.getNumbersUsed(),numbersUsed);
       knowNumbers = true;
       return numbersUsed;
   }
   
   public CalcSequence add(CalcSequence seq){
       return new CalcSequence(this,seq,'+',seq.total()+total());
   }
   public CalcSequence subtract(CalcSequence seq){
       return new CalcSequence(this,seq,'-',total()-seq.total());
   }
   public CalcSequence divide(CalcSequence seq){
       return new CalcSequence(this,seq,'/',total()/seq.total());
   }
   public CalcSequence multiply(CalcSequence seq){
       return new CalcSequence(this,seq,'*',total()*seq.total());
   }
   public int getSize(){
        
       if(knowSize)
           return size;
       
       if(singular)
           return 1;
       
       
       size = seq1.getSize() + seq2.getSize();
       knowSize = true;
       return size;
   }
   public String toString(){
       if(singular){
           return String.valueOf(value);
       }
       String seq1String = seq1.toString();
       String seq2String = seq2.toString();
       
       if(!((seq1.onlyAdd&&operator=='+')||(seq1.onlyMult&&operator=='*'))&&!(seq1.singular))
           seq1String = "("+seq1String+")";
       
       if(!((seq2.onlyAdd&&operator=='+')||(seq2.onlyMult&&operator=='*'))&&!(seq2.singular))
           seq2String = "("+seq2String+")";
       
       if(operator == '*'){
           if(seq2.singular && !seq1.singular)
               return seq2String+seq1String;
               
           if(seq1.singular && !seq2.singular)
               return seq1String+seq2String;
       }
       
       if((operator == '/')||(operator == '-'))
           return seq1String+" "+operator+" "+seq2String;
       
       return seq2String+" "+operator+" "+seq1String;
   }
   
}
