package arraylistplay;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
public class SongInterpreter {

    //variables local to the class and hence global to the methods
    private static ArrayList<String> pitches = new ArrayList<>();
    private static ArrayList<Double> beats = new ArrayList<>();
    private static Scanner commandReader =new Scanner(System.in);

    public static void main (String[] args) {
        try {
        // establish the parallel arrays of pitches and durations
            readNotes();
            //enter the interpreter
            interpreter();
        } catch (FileNotFoundException ex){
            System.out.println("The file was not found. Please try again. ");
            System.exit(-1);
        }
    }
    //assuming that data will be found in the public_html/CS1Files/data subdirectory of
    // the user's home directory, establish a scanner that finds the filess and reads it in
    private static Scanner estabishScanner(String fn) throws
            FileNotFoundException {
        String separator = File.separator;
        String homeDirectory = System.getProperty("user.home");
        String path = homeDirectory + separator + "public_html" + separator +
                "CS1Files" + separator + "data" + separator;
        String fullFilesName = path + fn;
        return new Scanner(new File(fullFilesName));
    }
    //read in the pitches and duration (or beats) of the pitches from the file
    private static void readNotes() throws FileNotFoundException {

        Scanner scanner = estabishScanner("Song.txt");
        while (scanner.hasNext()) {
            pitches.add(scanner.next());
            beats.add(scanner.nextDouble());
        }
    }

    private static void interpreter() throws FileNotFoundException {
        System.out.print("Enter a command >>> ");
        String command = commandReader.next();
        if (command.equalsIgnoreCase("DISPLAY")) {interpreterDisplayCommand();
        } else if ( command.equalsIgnoreCase("PRINT")) {interpretPrintCommand () ;
        } else if ( command . equalsIgnoreCase ("STRING") ) {interpretStringCommand () ;
        } else if ( command . equalsIgnoreCase ("ADD") ) {interpretAddCommand () ;
        } else if ( command . equalsIgnoreCase ("LENGTH") ) {interpretLengthCommand () ;
        } else if ( command . equalsIgnoreCase ("HELP") ) {interpretHelpCommand () ;
        }else if ( command . equalsIgnoreCase ("SWAP") ) {swap();
        } else if ( command.equalsIgnoreCase("REPLACE")) {replace();
        } else if ( command . equalsIgnoreCase ("EXIT") ) {System.exit(0);
        } else if ( command . equalsIgnoreCase ("INSERT") ) {insert();
        } else if ( command . equalsIgnoreCase ("REMOVE") ) {remove();
        } else {System . out . println (" ### Unrecognizable command : " + command ) ;
        }
        interpreter () ;
        }

    private static void remove() {
        int index = commandReader.nextInt();
        pitches.remove(index);
        beats.remove(index);
    }

    private static void insert() {
        int index = commandReader.nextInt();
        String pitch = commandReader.next();
        double beat = commandReader.nextDouble();
        if(index< beats.size()){
            for (int x = beats.size() ; x > index; x = x - 1) {
            beats.add(x,beats.get(x-1));
            pitches.add(x,pitches.get(x-1));
            }
            pitches.add(index,pitch);
            beats.add(index,beat);}
        else {
            System.out.println("You are trying to access somewhere outside the array!! Number of notes : " + beats.size());
        }
    }

    private static void replace() {
        int index = commandReader.nextInt();
        String pitch = commandReader.next();
        double beat = commandReader.nextDouble();
        if(index < beats.size()){
        pitches.add(index,pitch);
        beats.add(index,beat);}
        else {
            System.out.println("You are trying to access somewhere outside the array!! Number of notes : " + beats.size());
        }
    }
    private static void swap(){
        int one = commandReader.nextInt();
        int two = commandReader.nextInt();
        String temp = pitches.get(one);
        pitches.add(one,pitches.get(two));
        pitches.add(two,temp);

        double temp2 = beats.get(one);
        beats.add(one,beats.get(two));
        beats.add(two,temp2);
    }
    private static void interpretHelpCommand () {
       System . out . println (" HELP - display a menu of commands ") ;
       System . out . println (" DISPLAY - display the list of pitches and corresponding durations ") ;
       System . out . println (" PRINT - print a note ( FIRST ; LAST ; index1 )") ;
       System . out . println (" STRING - print string for Lab 13") ;
       System . out . println (" ADD - add a note to the list ( FIRST ; LAST newPitch new Duration )") ;
       System . out. println  (" SWAP - exchange two notes ( index1 index2 )");
       System . out. println  (" REPLACE - replace the note at index with a new note ( index newPitch newDuration )");
       System . out. println  (" INSERT - insert a new note inbetween previous notes(index newPitch newDuration) ");
       System . out . println (" LENGTH - prints the total duration of the song ") ;
        System . out . println (" REMOVE - remove the note at the index of the song(index) ") ;
       System . out . println (" EXIT - terminate execution of the program ") ;
       }

    private static void interpreterDisplayCommand () {
        displayNotes () ;
    }

    private static void displayNotes () {
        for (int x = 0; x < beats.size() ; x = x + 1) {
            System . out . println ( pitches.get(x) + " " + beats.get(x)) ;
        }

    }




    private static void interpretStringCommand () {
        // In Lab 13 , you will connect SComposer to SPainter . But , your
        // melodies will need a specific
        // format . This method will turn the melody in your Song . txt file
        // into that specific format , so
        // you can just copy and paste the output from this program into the
        // dialog box for Lab

        String song = "";
        String thisBeat = "";

        // Pitches are in fine format already , but beats have to be written as
        // a String in fraction format

        // with no space between the pitch and the beat . However , a 1 - beat
        // note doesn ’t need a number
        // for the beat and integers can ’t have the ".0" part .
        for (int x = 0; x < beats.size(); x = x + 1) {
            if (beats.get(x) == 1) {
                thisBeat = "";

            } else if (beats.get(x)== 0.5) {
                thisBeat = "1/2";

            } else if (beats.get(x) == 1.5) {
               thisBeat = "3/2";
            } else if (beats.get(x)== 0.25) {
                thisBeat = "1/4";
            } else if (beats.get(x)== 0.125) {
                thisBeat = "1/8";
            } else if (beats.get(x).intValue() == beats.get(x)) {
                // this condition checks if the " cast " value is the same as
                //the original , which is only true
                // for integers
                // then we save the integer in int format ( dropping the ".0")
                int castToInt = beats.get(x).intValue();
                // and finally , cast the int to a String .
                thisBeat = Integer.toString(castToInt);
            } else {
                // if you ’ve entered a different duration , we ’ll pretend that
                // the duration is 1
                thisBeat = "";
            }
            song = song + " " + pitches.get(x) + thisBeat;
        }
        // the song string has an extra space at the beginning , so we need to
        // remove that
      song = song.substring(1);
         System.out.println(song);
    }
    private static void interpretLengthCommand () {
        double lengthOfSong = 0;
        for (int x = 0; x < beats.size(); x = x + 1) {
            lengthOfSong = lengthOfSong + beats.get(x);
        }
        System.out.println(lengthOfSong + " beats in total ");
    }
    private static void interpretAddCommand (){
      String position=commandReader.next();
        if(position.equalsIgnoreCase("LAST")){
     addLast();
        }else if(position.equalsIgnoreCase("FIRST")){
        addFirst();
        }else{
        System.out.println(" ### invalid operand for add command ");
        }
        }

        private static void addFirst () {
        for (int x = beats.size() ; x > 0; x = x - 1) {
            beats.add(x,beats.get(x-1));
            pitches.add(x,pitches.get(x-1));
        }
        pitches.add(0, commandReader . next () );
        beats .add(0, commandReader.nextDouble());
    }
    private static void addLast () {
        pitches.add(0, commandReader . next () );
        beats.add(0, commandReader . nextDouble() );
    }
    private static void interpretPrintCommand (){
       String operand=commandReader.next();
         if(operand.equalsIgnoreCase("FIRST")){
       System.out.println(pitches.get(0)+" "+beats.get(0));
        }else if(operand.equalsIgnoreCase("LAST")){
      System.out.println(pitches.get(pitches.size()-1)+" "+ beats.get(beats.size()-1));
       }else{
       int index=Integer.valueOf(operand);
        System.out.println(pitches.get(index)+" "+beats.get(index));
       }
    }
}