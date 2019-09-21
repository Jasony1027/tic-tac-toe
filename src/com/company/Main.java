/**
 * Tic Tac Toe
 * A simple Tic Tac Toe game
 * @author Jason Yen
 * @version Oct. 9 2017
 */
package com.company;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random gt = new Random();
        String table, inputP1, sRandomAI, win, lose, tie, breakLoops, re;
        int randomAI;
        char X, O;
        table = "1|2|3\n4|5|6\n7|8|9";
        X = 'X';
        O = 'O';
        re = "Y";
        win = "X|X|X";
        lose = "O|O|O";
        tie = table.replaceAll("O", "").replaceAll("X", "").replaceAll("\n", "");
        sRandomAI = "";
        System.out.println(table);

        while (true) {
            breakLoops = table.replaceAll("O", "").replaceAll("\n", "").replaceAll("[1-9]", "");

            //Player
            System.out.println("Pick a position");
            inputP1 = sc.next();
            while (table.indexOf(inputP1) == -1 && breakLoops.length() <= 11) {
                System.out.println("Pick a new position");
                inputP1 = sc.next();
            }
            if (table.indexOf("1") == 0 || table.indexOf("2") > 0 || table.indexOf("3") > 0 || table.indexOf("4") > 0 || table.indexOf("5") > 0 || table.indexOf("6") > 0 || table.indexOf("7") > 0 || table.indexOf("8") > 0 || table.indexOf("9") > 0) {
                table = table.replaceAll(inputP1, "X");
                System.out.println(table);
            }

            //AI
            if (breakLoops.length() < 10) {
                randomAI = gt.nextInt(8) + 1;
                sRandomAI = Integer.toString(randomAI);

                while (table.indexOf(sRandomAI) == -1 && breakLoops.length() < 11) {
                    randomAI = gt.nextInt(8) + 1;
                    sRandomAI = Integer.toString(randomAI);
                }
            }
            if (table.indexOf("1") == 0 || table.indexOf("2") > 0 || table.indexOf("3") > 0 || table.indexOf("4") > 0 || table.indexOf("5") > 0 || table.indexOf("6") > 0 || table.indexOf("7") > 0 || table.indexOf("8") > 0 || table.indexOf("9") > 0) {
                System.out.println("O picked " + sRandomAI);
                table = table.replaceAll(sRandomAI, "O");
                System.out.println(table);
            }

            if (table.substring(0, 5).equals(win) || table.substring(6, 11).equals(win) || table.substring(12, 17).equals(win) || table.charAt(0) == X && table.charAt(8) == X && table.charAt(16) == X || table.charAt(4) == X && table.charAt(8) == X && table.charAt(12) == X || table.charAt(0) == X && table.charAt(6) == X && table.charAt(12) == X || table.charAt(2) == X && table.charAt(8) == X && table.charAt(14) == X || table.charAt(4) == X && table.charAt(10) == X && table.charAt(16) == X) {
                System.out.println("YOU WIN");
                System.out.println("Play again(Y/N)?");
                re = sc.next();
                if (re.toUpperCase().equals("N")) {
                    System.out.println("Bye");
                    System.exit(0);
                } else {
                    table = "1|2|3\n4|5|6\n7|8|9";
                    System.out.println(table);
                }
            } else if (table.substring(0, 5).equals(lose) || table.substring(6, 11).equals(lose) || table.substring(12, 17).equals(lose) || table.charAt(0) == O && table.charAt(8) == O && table.charAt(16) == O || table.charAt(4) == O && table.charAt(8) == O && table.charAt(12) == O || table.charAt(0) == O && table.charAt(6) == O && table.charAt(12) == O || table.charAt(2) == O && table.charAt(8) == O && table.charAt(14) == O || table.charAt(4) == O && table.charAt(10) == O && table.charAt(16) == O) {
                System.out.println("YOU LOSE");
                System.out.println("Play again(Y/N)?");
                re = sc.next();
                if (re.toUpperCase().equals("N")) {
                    System.exit(0);
                } else {
                    table = "1|2|3\n4|5|6\n7|8|9";
                    System.out.println(table);
                }

            } else if (table.indexOf("1") < 0 && table.indexOf("2") < 0 && table.indexOf("3") < 0 && table.indexOf("4") < 0 && table.indexOf("5") < 0 && table.indexOf("6") < 0 && table.indexOf("7") < 0 && table.indexOf("8") < 0 && table.indexOf("9") < 0) {
                System.out.println("It is a Tie");
                System.out.println("Play again(Y/N)?");
                re = sc.next();
                if (re.toUpperCase().equals("N")) {
                    System.out.println("Bye");
                    System.exit(0);
                } else {
                    table = "1|2|3\n4|5|6\n7|8|9";
                    System.out.println(table);
                }
            }

        }
    }
}
