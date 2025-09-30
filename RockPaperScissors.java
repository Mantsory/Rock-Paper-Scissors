/*
 * Purpose: to play Rock Paper Scissors with a computer.
 *
 * Author: Mantsory
 * Version: 1.0
 */

import java.util.Scanner;

public class RockPaperScissors {
    public static String game(String args) {

        //Declares some starting variables
        String winMSG = "You won the game!"; //declares the message if you win
        String losMSG = "You lost the game! Maybe you have better luck next time."; //declares the message if you lose
        String tieMSG = "The game was a tie!"; //declares the message if its a tie
        String again; //for playing again
        String compChoice; //this will be the computers choice
        String choice = args; //Redeclares the choice String

        Scanner input = new Scanner(System.in);

        //Determines the computers choice
        int compChoiceInt = (int) (Math.random() * 3) + 1;
        if (compChoiceInt == 1) {
            compChoice = "rock";
        } else if (compChoiceInt == 2) {
            compChoice = "paper";
        } else if (compChoiceInt == 3) {
            compChoice = "scissors";
        } else {
            System.out.println("Exit");
            compChoice = null;
            System.exit(1);
        }

        choice = choice.toLowerCase();

        System.out.println("You selected: " + choice);
        System.out.println("The computer selected: " + compChoice);

        if (choice.equalsIgnoreCase(compChoice)) {
            return tieMSG;

        } else if (choice.matches("rock")) {
            if (compChoice.matches("paper")) {
                return losMSG;
            } else {
                return winMSG;
            }
        } else if (choice.matches("paper")) {
            if (compChoice.matches("scissors")) {
                return losMSG;
            } else {
                return winMSG;
            }
        } else if (choice.matches("scissors")) {
            if (compChoice.matches("rock")) {
                return losMSG;
            } else {
                return winMSG;
            }
        } else {
            System.out.println("Couldn't play the game with your choice.");
            return "Game failed.";
        }

    } //end of game


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean gameActive = true;
        while (gameActive){
            System.out.println("Welcome to Rock Paper Scissors!");
            System.out.println("Please type in 'rock', 'paper', or 'scissors' to play.\n");

            String choice = input.next();
            String overflow = input.nextLine(); //removes any extra text

            System.out.println(game(choice));
            System.out.println("Would you like to play again?");
            System.out.println("[YES/NO]");

            String again = input.next();
            overflow = input.nextLine(); //removes any extra text

            if (again.equalsIgnoreCase("yes")) {
                System.out.println("PLaying again!");
            }
            else {
                gameActive = false;
            }
        } //end of while loop
    } //end of main
}
