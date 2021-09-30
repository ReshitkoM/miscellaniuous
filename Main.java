package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Task1
        {
            System.out.println("TASK1");
            Scanner userIn = new Scanner(System.in);
            System.out.println("Enter a five-digit number: ");
            int number = userIn.nextInt();
            if (number < 9999 || number > 99999) {
                System.out.println("Number must contain 5 digits!");
                return;
            } else {
                var task1Result = new int[5];
                Main.task1(number, task1Result);
                for (int i = 0; i < task1Result.length; i++) {
                    System.out.print(task1Result[i]);
                    System.out.print(",");
                }
            }
            System.out.println("");
        }
        //Task2
        {
            System.out.println("TASK2");
            Scanner userIn = new Scanner(System.in);
            System.out.println("Enter days count: ");
            int number = userIn.nextInt();
            MyDate task2Result = task2GetYearsWeeksDays(number, 2021);
            System.out.println("Years: " + task2Result.years +
                    ", Weeks: " + task2Result.weeks +
                    ", Days: " + task2Result.days);
        }
        //Task3
        {
            System.out.println("TASK3");
            Scanner userIn = new Scanner(System.in);
            System.out.println("Enter a number n: ");
            int number = userIn.nextInt();
            System.out.println(task3(number));
        }
        //Task4
        {
            System.out.println("TASK4");
            Scanner userIn = new Scanner(System.in);
            System.out.println("Enter a number1: ");
            int number1 = userIn.nextInt();
            System.out.println("Enter a number2: ");
            int number2 = userIn.nextInt();
            System.out.println(task4AreBothEven(number1, number2));
        }
        //Task5
        {
            System.out.println("TASK5");
            Scanner userIn = new Scanner(System.in);
            System.out.println("Enter x: ");
            double x = userIn.nextDouble();
            System.out.println("Enter y: ");
            double y = userIn.nextDouble();
            System.out.println("Enter r: ");
            double r = userIn.nextDouble();
            System.out.println(task5IsInsideCircle(x, y, r));
        }
        //Task6
        {
            System.out.println("TASK6");
            PlayerChoice p1 = task6GetPlayerInput();
            PlayerChoice p2 = task6GetPlayerInput();
            System.out.println(task6GetWinner(p1, p2));
        }

    }
    private static void task1(int number, int[] outDigits) {
        for(int i=4; i >= 0; i--){
            int nextDigit = number % 10;
            number        = number / 10;
            outDigits[i]  = nextDigit;
        }
    }
    //Task2
    private static final int DAYS_IN_LEAP_YEAR_CYCLE = 365*4 + 1;
    private static boolean isLeap(int year) {
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
    private static MyDate task2GetYearsWeeksDays(int days, int startYear) {
        int fourYearCycleCount = days / DAYS_IN_LEAP_YEAR_CYCLE;
        int remainDaysCount    = days - fourYearCycleCount * DAYS_IN_LEAP_YEAR_CYCLE;
        int currYear           = startYear + fourYearCycleCount*4;
        int totalYearCount     = fourYearCycleCount*4;
        for(;;currYear += 1)
        {
            int daysInCurrYear = isLeap(currYear) ? 366 : 365;
            if (daysInCurrYear <= remainDaysCount){
                totalYearCount  += 1;
                remainDaysCount -= daysInCurrYear;
            } else {
                break;
            }
        }
        int totalWeekCount = remainDaysCount / 7;
        int totalDayCount  = remainDaysCount - totalWeekCount*7;
        MyDate result = new MyDate();
        result.years  = totalYearCount;
        result.weeks  = totalWeekCount;
        result.days   = totalDayCount;
        return result;
    }
    //Task3
    private static int task3(int n){
        return n + n*2;
    }
    //Task4
    private static boolean task4AreBothEven(int number1, int number2){
        return (number1 % 2 ==0) && (number2 % 2 ==0);
    }
    //Task5
    private static boolean task5IsInsideCircle(double x, double y, double r){
        return r >= Math.sqrt(x*x + y*y);
    }
    //Task6
    private static PlayerChoice task6GetPlayerInput()
    {
        Scanner userIn = new Scanner(System.in);
        while(true){
            System.out.println("enter 'rock', 'paper' or 'scissors': ");
            String playerInput = userIn.nextLine();
            Scanner filter = new Scanner(playerInput);
            playerInput = filter.findInLine("^rock|paper|scissors$");
            if (playerInput == null){
                System.out.println("input not recognized, try again! ");
            } else {
                switch(playerInput){
                    case "rock":
                        return PlayerChoice.ROCK;
                    case "paper":
                        return PlayerChoice.PAPER;
                    case "scissors":
                        return PlayerChoice.SCISSORS;
                }
            }
        }
    }
    private static GameResult task6GetWinner(PlayerChoice p1, PlayerChoice p2)
    {
        if(p1 == p2) {
            return GameResult.TIE;
        }
        if(p1.next() == p2) {
            return GameResult.P1WIN;
        } else {
            return GameResult.P2WIN;
        }
    }
}
enum PlayerChoice {
    ROCK, SCISSORS, PAPER;
    public PlayerChoice next() {
        if (ordinal() == values().length - 1)
            return values()[0];
        return values()[ordinal() + 1];
    }
}
enum GameResult {
    TIE, P1WIN, P2WIN

}
class MyDate {
    public int years;
    public int weeks;
    public int days;
}