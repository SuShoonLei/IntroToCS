package arraylistplay;

import java.util.ArrayList;

public class Streets {
    public static void main(String[] args) {
        ArrayList<String> streets = new ArrayList<>();

        streets.add("Iberville");
        streets.add("Decatur");
        streets.add("Toulouse");
        streets.add("Bourbon");
        streets.add("Dauphine");
        streets.add("Royal");
        streets.add("St Ann");
        streets.add("St Peter");
        streets.add("Conti");
        streets.add("Exchange");
        streets.add("Bienville");
        streets.add("Dumaine");
        System.out.println("the length of the featured array list = " + streets.size());
        System.out.println("The first element of the featured array list = " + streets.get(0));
        System.out.println("the last element of the featured array list = " + streets.get(11));
        System.out.println("the last element of the featured array list = " + streets.get(streets.size()-1));


        System.out.println("the elements of the array list ...");
            for ( String street : streets ) {
                System.out.println(street);
        }

            String temp = streets.get(0);
            streets.set(0, streets.get(streets.size() - 1));
            streets.set(streets.size() - 1, temp);

        System.out.println("the elements of the array list ...");
        for ( String street : streets ) {
            System.out.println(street);
        }
    }
}
