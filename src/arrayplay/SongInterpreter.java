package arrayplay;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;
public class SongInterpreter {

    //variables local to the class and hence global to the methods
    private static final int LIMIT =1000;
    private static String[] pitches = new String[LIMIT];
    private static double[] beats = new double[LIMIT];
    private static int numberOfNotes = 0;
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
            pitches[numberOfNotes] = scanner.next();
            beats[numberOfNotes] = scanner.nextDouble();
            numberOfNotes = numberOfNotes + 1;
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
        } else if ( command.equalsIgnoreCase("REPLACE")) {
            int index = commandReader.nextInt();
            String pitch = commandReader.next();
            double beat = commandReader.nextDouble();
            replace(index,pitch,beat);
        } else if ( command . equalsIgnoreCase ("EXIT") ) {
            System.exit(0);
        } else if ( command . equalsIgnoreCase ("INSERT") ) {insert();
        } else {
            System . out . println (" ### Unrecognizable command : " + command ) ;
        }
        interpreter () ;
    }

    private static void insert() {
        int index = commandReader.nextInt();
        String pitch = commandReader.next();
        double beat = commandReader.nextDouble();
        if(index< numberOfNotes){
            for (int x = numberOfNotes ; x > index; x = x - 1) {
                beats [x] = beats [ x - 1];
                pitches [ x ] = pitches [x -1];
            }
            pitches [index] = pitch;
            beats [index] = beat;
            numberOfNotes = numberOfNotes +1;}
        else {
            System.out.println("You are trying to access somewhere outside the array!! Number of notes : " + numberOfNotes);
        }
    }

    private static void replace(int index, String pitch, double beat) {
        if(index<numberOfNotes){
            pitches[index] = pitch;
        beats[index] = beat;}
        else {
            System.out.println("You are trying to access somewhere outside the array!! Number of notes : " + numberOfNotes);
        }
    }
    private static void swap(){
        int i = commandReader.nextInt();
        int j = commandReader.nextInt();
        if(i<numberOfNotes && j <numberOfNotes){
        String temp = pitches[i];
        pitches[i] = pitches[j];
        pitches[j] = temp;

        double temp2 = beats[i];
        beats[i] = beats[j];
        beats[j] = temp2;}else {
            System.out.println("You are trying to access somewhere outside the array!! Number of notes : " + numberOfNotes);
        }
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
        System . out . println (" EXIT - terminate execution of the program ") ;
    }

    private static void interpreterDisplayCommand () {
        displayNotes () ;
    }

    private static void displayNotes () {
        for (int x = 0; x < numberOfNotes ; x = x + 1) {
            System . out . println ( pitches [ x ] + " " + beats [ x ]) ;
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
        for (int x = 0; x < numberOfNotes; x = x + 1) {
            if (beats[x] == 1) {
                thisBeat = "";

            } else if (beats[x] == 0.5) {
                thisBeat = "1/2";

            } else if (beats[x] == 1.5) {
                thisBeat = "3/2";
            } else if (beats[x] == 0.25) {
                thisBeat = "1/4";
            } else if (beats[x] == 0.125) {
                thisBeat = "1/8";
            } else if ((int) beats[x] == beats[x]) {
                // this condition checks if the " cast " value is the same as
                //the original , which is only true
                // for integers
                // then we save the integer in int format ( dropping the ".0")
                int castToInt = (int) beats[x];
                // and finally , cast the int to a String .
                thisBeat = Integer.toString(castToInt);
            } else {
                // if you ’ve entered a different duration , we ’ll pretend that
                // the duration is 1
                thisBeat = "";
            }
            song = song + " " + pitches[x] + thisBeat;
        }
        // the song string has an extra space at the beginning , so we need to
        // remove that
        song = song.substring(1);
        System.out.println(song);
    }
    private static void interpretLengthCommand () {
        double lengthOfSong = 0;
        for (int x = 0; x < numberOfNotes; x = x + 1) {
            lengthOfSong = lengthOfSong + beats[x];
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
        numberOfNotes=numberOfNotes+1;
    }

    private static void addFirst () {
        for (int x = numberOfNotes ; x > 0; x = x - 1) {
            beats [ x ] = beats [ x - 1];
            pitches [ x ] = pitches [x -1];
        }
        pitches [0] = commandReader . next () ;
        beats [0] = commandReader . nextDouble () ;
    }
    private static void addLast () {
        pitches[numberOfNotes] = commandReader.next();
        beats[numberOfNotes] = commandReader.nextDouble();
    }
    private static void interpretPrintCommand (){
        String operand=commandReader.next();
        if(operand.equalsIgnoreCase("FIRST")){
            System.out.println(pitches[0]+" "+beats[0]);
        }else if(operand.equalsIgnoreCase("LAST")){
            System.out.println(pitches[numberOfNotes-1]+" "+beats[numberOfNotes-1]);
        }else{
            int index=Integer.valueOf(operand);
            System.out.println(pitches[index]+" "+beats[index]);
        }
    }
}