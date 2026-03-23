package horde;

import painter.SPainter;

import javax.swing.*;
import java.util.ArrayList;

public class MonsterHorde {
     private ArrayList<Monster> MonsterInTheGarden;

     public MonsterHorde (int numOfMonster){
          this.MonsterInTheGarden = new ArrayList<Monster>(numOfMonster);
          for(int i =0 ; i < numOfMonster; i++){
               String name = JOptionPane.showInputDialog(null,
                       "Please enter Name of Monster"+(i+1));
               int size = Integer.parseInt(JOptionPane.showInputDialog(null,
                       "Please enter Size of Monster"+(i+1)));
               int legs = Integer.parseInt(JOptionPane.showInputDialog(null,
                       "How many legs Monster"+(i+1)+" has?"));
               int eyes = Integer.parseInt(JOptionPane.showInputDialog(null,
                       "How many eyes Monster"+(i+1)+" has?"));
               Monster mc = new Monster(name,size,legs,eyes);
               MonsterInTheGarden.add(mc);
          }
     }

     public String toString(){
          String st = "";
          for(int i = 0 ; i<MonsterInTheGarden.size() ; i++){
               st = st + MonsterInTheGarden.get(i).toString() +"\n";
          }
     return st;
     }

     public void paint(SPainter sp){
          sp.mlt(sp.painterWidth/2.0);
          double mv = (sp.painterWidth)/(MonsterInTheGarden.size()+1);
          for(int i = 0 ; i<MonsterInTheGarden.size() ; i++){
               sp.mrt(mv);
               MonsterInTheGarden.get(i).paint(sp);
          }
     }
}
