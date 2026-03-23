///*
//* A program to perform some basic operations on a list of String names.
//*/
//
//package arraylists;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ArrayListProcessing {
//
//    public static void main(String[] args) {
//        List<String> names;
//
//        private static List<String> firstNames ((List < String) > names) {
//            List<String> firsts = new ArrayList<>();
//            for (String name : names) {
//                firsts.add(firstName(name));
//            }
//            return firsts;
//        }
//
//        //COMPUTE AND PRINT THE FIRST NAMES, AGAIN
//        System.out.println("\nFirst names, once again ...");
//        System.out.println(firstName("Billie"));
//        System.out.println(firstName("Camille"));
//        System.out.println(firstName("Pablo"));
//        System.out.println(firstName("Akseli"));
//        System.out.println(firstName("Osvaldo"));
//        System.out.println(firstName("Su"));
//        System.out.println(firstName("Pyae"));
//
//        // POINT A: Add some strings which represent names to an ArrayList.
//        List<String> names = new ArrayList<>();
//        names.add("Holiday , Billie");
//        names.add("Claudel , Camille");
//        names.add("Picasso , Pablo");
//        names.add("Gallen-Kallela , Akseli");
//        names.add("Zotto , Osvaldo");
//        names.add("Khaing , Su");
//        names.add("Thu , Pyae");
//
//// POINT B: Create an ArrayList of just the first names of the names
////          ArrayList. Use a for loop to print out the names, separated
////          by spaces.
//        List<String> firstNameList = firstNames(names);
//
//        System.out.println("First Names: ");
//        for (String firstName : firstNameList) {
//            System.out.println(firstName + " ");
//        }
//        System.out.println();
//
//// POINT C: Use String’s join function to create and print a String of
////          just the first names of the names ArrayList with each
////          name separated by a comma.
//        String firstNames = String.join(", ", firstNameList);
//
//        System.out.println("First names: " + firstNames);
//
//// POINT D: By analogy from points B and C, print a comma-separated
////          list of the last names in the names ArrayList.
//        List<String> lastNameList = lastNames(names);
//
//        System.out.println("Last Names: ");
//        for (String lastName : lastNameList) {
//            System.out.println(lastName + " ");
//        }
//        System.out.println();
//
//        System.out.println(lastName("Holiday"));
//        System.out.println(lastName("Claudel"));
//        System.out.println(lastName("Picasso"));
//        System.out.println(lastName("Gallen-Kallela"));
//        System.out.println(lastName("Zotto"));
//        System.out.println(lastName("Khaing"));
//        System.out.println(lastName("Thu"));
//
//// POINT E: Print a comma-separated list of all uppercase first names
////          from the list of names in the names ArrayList.
//        public static List<String> upperCaseNames (List < String > names) {
//            List<String> uppercases = new ArrayList<>();
//            for (String name : names) {
//                uppercases.add(names.toUpperCase());
//            }
//            return uppercases;
//        }
//        String lastNmaes = String.join(", ", lastNameList);
//
//        System.out.println("Last Nmaes: " + lastNmaes);
//
//        List<String> upperCaseFirstNamesLists = upperCaseNames(firstNames(names));
//        String upperCaseFirstNames = String.join(", ", upperCaseFirstNamesLists);
//
//        System.out.println("Uppercase first names: " + upperCaseFirstNames);
//// POINT F: Print a comma-separated list of all hyphenated last names
////          from the list of names in the names ArrayList.
//        public static List<String> hyphenatedNames(List <String> names) {
//            List<String> hyphebateds = new ArrayList<>();
//            for (String name : names) {
//                if (names.contains("-")) ;
//                hyphebateds.add(name);
//            }
//        }
//        return hyphenateds;
//    }
//// POINT G: Print the integer value of the total length of all names
////          in the names ArrayList.
//    public static int totalNameLength(List<String> names) {
//        int totallength = 0;
//        for (String name : names) {
//            totallength = totallength + name.length();
//        }
//        return totallength;
//    }
//
//// POINT H: Print the integer value of the total length of all
////          first names in the names ArrayList.
//// POINT I: Print the integer value of the product of the length of
////          all first names in the names ArrayList.
//    }
//
//    private static String firstName(String billie) {
//    }
//
//    private static boolean firstName(boolean names) {
//    }
//}