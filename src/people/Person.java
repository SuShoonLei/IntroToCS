package people;

public class Person {
    private String name;
    private int month;
    private int day;
    private int year;
    private String firstName;
    private String lastName;
public Person(String name, int day, int month, int year){
    this.name = name;
    this.month = month;
    this.day = day;
    this.year = year;
}
public String toString(){
    String st = "name is " + name + " and born on " + day + "of " + month + " in " + year;
    return st;
}


//    public String initials() {
//
//    }
//
//    public boolean isBoomer() {
//
//    }
}