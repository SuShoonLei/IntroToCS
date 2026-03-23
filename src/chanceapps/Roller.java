/*
* Program to make use of the Die class.
*/
package chanceapps;
import chance.Die;

public class Roller {
    public static void main (String[] args) {
        //Create a standard die and roll it 5 times
        createAndRollStandardDieFiveTimes();

        //Create a twenty sided die and roll it 5 tines
        createAndRollTwentySidedDieFiveTimes();

        //Create a standard die and roll it 20 tines
        createAndRollStandardDie(20);

        //Create a standard die abd roll it 30 times
        createAndRollStandardDie(30);

        //Create a nice sided die and roll it 20 times
        createAndRollNineSidedDie(20);

        //Create a nine sided die and roll it 30 tines
        createAndRollNineSidedDie(30);

        //Ten tines, create a standard die and roll it until you get a 1
        //System.out.println("Ten times, roll a standard die for a 1.");
        for (int i = 1; i <= 10; i++) {
            createAndRollStandardDieFor1();
        }
        // TEN TIMES, CREATE A TWELVE SIDED DIE AND ROLL IT UNTIL YOU GET A 1
        // System.out.println("Ten times, roll a twelve sided die for a 1.");
        for (int i = 1; i <= 10; i++) {
            createAndRollTwelveSidedDieFor1();
        }
    }
    private static void createAndRollStandardDieFiveTimes() {
        System.out.println("Roll a standard die 5 times ...");
        Die die = new Die();
        die.roll(); System.out.print(die.top() + " ");
        die.roll(); System.out.print(die.top() + " ");
        die.roll(); System.out.print(die.top() + " ");
        die.roll(); System.out.print(die.top() + " ");
        die.roll(); System.out.print(die.top() + " ");
        System.out.println();
    }
    private static void createAndRollTwentySidedDieFiveTimes() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private static void createAndRollStandardDie(int nrOfTimes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private static void createAndRollNineSidedDie(int nrOfTimes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private static void createAndRollStandardDieFor1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private static void createAndRollTwelveSidedDieFor1() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

