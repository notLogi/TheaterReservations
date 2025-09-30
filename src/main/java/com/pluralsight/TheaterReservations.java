package com.pluralsight;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TheaterReservations {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        String name = setName(myScanner);
        LocalDate ticketDate = setDate(myScanner);
        //System.out.println(ticketDate);
        int numberOfTickets = setTickets(myScanner);
        if (numberOfTickets < 1){
            System.out.println("Invalid amount of tickets");
            System.exit(0);
        }
        purchaseSummary(name, ticketDate, numberOfTickets);
    }
    public static String setName(Scanner scanner) {
        System.out.println("Please enter your name: ");
        String firstName = scanner.nextLine();
        return firstName.substring(firstName.lastIndexOf(" ")) + ", " + firstName.substring(0, firstName.indexOf(" "));
    }
    public static LocalDate setDate(Scanner scanner){
        System.out.println("What date will you be coming(MM/dd/yyyy): ");
        String inputDate = scanner.nextLine();
        DateTimeFormatter formatter;
        formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return LocalDate.parse(inputDate, formatter);
    }
    public static int setTickets(Scanner scanner){
        System.out.println("How many tickets would you like? ");
        return scanner.nextInt();
    }
    public static void purchaseSummary(String name, LocalDate date, int tickets){
        String ticketsPlural = tickets > 1 ? " tickets " : " ticket ";
        System.out.println(tickets + ticketsPlural + "reserved for " + date + " under" + name);
    }
}
