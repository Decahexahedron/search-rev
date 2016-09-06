package canady_searchalgorithms;

import java.util.*;

public class Canady_SearchAlgorithms {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random randNum = new Random();
        final int arrLength = 1000;
        boolean looping = true;
        int inputNum;
        String answer;
        int[] numArray = new int[arrLength];
        boolean found;
        int foundNum = 2000000000;
        int min;
        int max;
        int currentGuess;

        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = randNum.nextInt(1000) + 1;
        }

        Arrays.sort(numArray);

        do {
            System.out.print("Please enter the number you wish to look for: ");
            System.out.println("");

            found = false;
            inputNum = input.nextInt();

            System.out.println("Linear Search algorithm:");
            System.out.println("");

            for (int i = 0; i < numArray.length; i++) {
                if (numArray[i] == inputNum) {
                    foundNum = i;
                    /* foundNum is intended to be the index of the target, 
                                    and since i runs through the indices, it will be the index*/
                    found = true; //the code below just checks for found
                }
            }

            if (found) {
                System.out.println("The number " + inputNum
                        + " can be found at index " + foundNum);
            } else {
                System.out.println("Sorry, " + " could not be found.");
            }

            System.out.println("Binary Search algorithm:");
            System.out.println("");

            found = false;

            //binary start
            min = 0; //min is bottom value, can change
            max = numArray.length; //max starts at numArray size and can change
            int range; //use range to slice in half
            int numDist;

            while (found == false) {
                range = max + min; //range is the size of search area
                currentGuess = range / 2; //guess is middle of range, also adjusted to correct window with +min
                numDist = max - min;
                if (inputNum == numArray[currentGuess] && inputNum != numArray[currentGuess - 1]) {
                    found = true; //ends while
                    foundNum = currentGuess; //gives correct value
                } else {
                    if (currentGuess % 2 != 0) { //makes sure even -> whole number so no decimals
                        if (inputNum == numArray[currentGuess - 1]) {
                            found = true; //ends while
                            foundNum = currentGuess - 1; //gives correct value
                            break;
                        }
                        currentGuess++;
                        if (inputNum == numArray[currentGuess]) {
                            found = true; //ends while
                            foundNum = currentGuess; //gives correct value
                        }
                    }
                    if (numArray[currentGuess] == numArray[currentGuess - 1]) {
                        currentGuess--;
                    }
                    if (numArray[currentGuess] < inputNum) {
                        min = currentGuess + 1; //changes bottom of range to currentGuess (+1 since we already checked currentGuess)
                    }
                    if (numArray[currentGuess] > inputNum) {
                        max = currentGuess - 1; //changes top of range to currentGuess (-1 since we already checked currentGuess)
                    }
                    if (numDist == 1 || numDist == 0 || range == 1 || range == 0) { //this is how it figures out it cant find anything
                        break; //gets out of the while, because there wasnt another way out without changing range to true
                    }
                }
            }

            if (found) {
                System.out.println("The number " + inputNum
                        + " can be found at index " + foundNum);
            } else {
                System.out.println("Sorry, " + " could not be found.");
            }

            System.out.println("Would you like to continue?");
            Scanner replay = new Scanner(System.in);
            answer = replay.next();

            System.out.println("");

            if (answer.equals("no")) {
                looping = false;
            }
        } while (looping);
    }

}
