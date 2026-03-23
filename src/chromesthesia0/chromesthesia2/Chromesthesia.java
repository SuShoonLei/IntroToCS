package chromesthesia2;

import chromesthesia1.Pitch;
import painter.SPainter;

import javax.swing.*;
import java.util.Scanner;

public class Chromesthesia {

    // INFRASTRUCTURE FOR THE PROGRAM -- LAUNCHING A "GRAPHICS" THREAD

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ThreadForGUI());
    }

    private static class ThreadForGUI implements Runnable{
        @Override
        public void run() {
            new Chromesthesia();
        }
    }

    public Chromesthesia() {
        interpreter();
    }

    // FEATURED VARIABLES

    private static SPainter miro;
    private static Pitch[] pitches;

    // THE INTERPRETER

    public static void interpreter() {
        initialization(); // miro and pitches
        String toReuse = null;
        while(true) {
            String input = getInput();

            if (input.equalsIgnoreCase("EXIT")) {
                break;
            } else if (input.equalsIgnoreCase("AGAIN")) {
                try {
                    playMelody(toReuse, pitches);
                } catch (Exception ex) {
                    showErrorMessage(ex.toString());
                }
            }else {
                try {
                    toReuse = input;
                    playMelody(input, pitches);

                } catch (Exception ex) {
                    showErrorMessage(ex.toString());
                }
            }
        }

        cleanup();
    }

    // METHODS PERTAINING TO THE CHROMESTHETIC PITCHES

    private static Pitch[] establishPitches(SPainter painter) {
        Pitch[] pitches = new Pitch[21];
        Pitch pitchMiddleC = new Pitch("C", painter);
        pitches[0] = pitchMiddleC;
        Pitch pitchLowC = new Pitch("C,", painter);
        pitches[1] = pitchLowC;
        Pitch pitchHighC = new Pitch("c", painter);
        pitches[2] = pitchHighC;
        Pitch pitchMiddleD = new Pitch("D", painter);
        pitches[3] = pitchMiddleD;
        Pitch pitchLowD = new Pitch("D,", painter);
        pitches[4] = pitchLowD;
        Pitch pitchHighD = new Pitch("d", painter);
        pitches[5] = pitchHighD;
        Pitch pitchMiddleE = new Pitch("E", painter);
        pitches[6] = pitchMiddleE;
        Pitch pitchLowE = new Pitch("E,", painter);
        pitches[7] = pitchLowE;
        Pitch pitchHighE = new Pitch("e", painter);
        pitches[8] = pitchHighE;
        Pitch pitchMiddleF = new Pitch("F", painter);
        pitches[9] = pitchMiddleF;
        Pitch pitchLowF = new Pitch("F,", painter);
        pitches[10] = pitchLowF;
        Pitch pitchHighF = new Pitch("f", painter);
        pitches[11] = pitchHighF;
        Pitch pitchMiddleG = new Pitch("G", painter);
        pitches[12] = pitchMiddleG;
        Pitch pitchLowG = new Pitch("G,", painter);
        pitches[13] = pitchLowG;
        Pitch pitchHighG = new Pitch("g", painter);
        pitches[14] = pitchHighG;
        Pitch pitchMiddleA = new Pitch("A", painter);
        pitches[15] = pitchMiddleA;
        Pitch pitchLowA = new Pitch("A,", painter);
        pitches[16] = pitchLowA;
        Pitch pitchHighA = new Pitch("a", painter);
        pitches[17] = pitchHighA;
        Pitch pitchMiddleB = new Pitch("B", painter);
        pitches[18] = pitchMiddleB;
        Pitch pitchLowB = new Pitch("B,", painter);
        pitches[19] = pitchLowB;
        Pitch pitchHighB = new Pitch("b", painter);
        pitches[20] = pitchHighB;
        return pitches;

    }

    private static Pitch find(String token, Pitch[] pitches) throws Exception {
        for (int i = 0; i < pitches.length; i = i + 1) {
            Pitch pitch = pitches[i];
            if (pitch.abcName().equals(token)) {
                return pitch;
            }
        }
        throw new Exception("### PITCH " + token + " NOT FOUND");
    }

    private static void display(Pitch[] pitches) {
        for (int i = 0; i < pitches.length; i = i + 1) {
            System.out.println(pitches[i].toString());
        }
    }

    private static void playMelody(String input, Pitch[] pitches) throws Exception {
        Scanner scanner = new Scanner(input);
        while(scanner.hasNext() ) {
            String token = scanner.next();
            String pitchName;
            String duration = "";
            if (token.indexOf(",") < 0) {
                pitchName = token.substring(0,1);
                duration = token.substring(1);
            } else {
                pitchName = token.substring(0, 2);
                duration = token.substring(2);
            }

            if (duration.length() == 1 ) {
                duration = "1";
            }

            Pitch pitch = find(pitchName, pitches);
            pitch.play("1");
        }
    }

    // INITIALIZATION, CLEAN UP, GETTING INPUT, ERROR READING

    static private void showErrorMessage(String message) {
        miro.setVisible(false);
        JOptionPane.showMessageDialog(null, message);
    }

    private static void initialization() {
        // ESTABLISH THE PAINTER AND GIVE IT A SUBSTANTIAL BRUSH WIDTH
        miro = new SPainter("Chromesthesia", 500, 500);
        miro.setVisible(false);
        miro.setBrushWidth(7);
        // ESTABLISH THE CHROMESTITIC PITCH CLASS OBJECTS
        pitches = establishPitches(miro);
        display(pitches);
    }

    private static String getInput() {
        miro.setVisible(false);
        String label = "Please enter a melody in ABC notation, or EXIT ...    ";
        String input = JOptionPane.showInputDialog(null, label);

        miro.setVisible(true);
        if (input == null ) {
            input = "";
        }
        return input;
    }

    static private void cleanup() {
        System.exit(0);
    }

}