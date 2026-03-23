package people;

import java.util.ArrayList;

public class PersonDemo2 {
 public static void main(String[] args) {


  String name = "Min Phone";
  int iOfS = (name.indexOf(" "));
  String initials = name.substring(0, 1)+ name.substring(iOfS +1,iOfS+2);
  ArrayList<String> namee = new ArrayList<>();
  namee.add(0,"dsaf");
  System.out.println(initials);

  String[] names = {"af","fas","afd","efg","sgdf"};
  System.out.println();
 }
}