import java.util.*;
import java.util.Scanner;

// Hard Level: Dynamic Synchronized Ticket Booking System with Thread Priorities
class TicketBookingSystem {
    private int availableSeats = 10;
    private final Scanner scanner = new Scanner(System.in);
    
    synchronized void bookTicket(String name, int seats) {
        if (seats <= availableSeats) {
            System.out.println(name + " booked " + seats + " seat(s) successfully.");
            availableSeats -= seats;
        } else {
            System.out.println("Not enough seats available for " + name);
        }
    }
}

class BookingThread extends Thread {
    private TicketBookingSystem bookingSystem;
    private String name;
    private int seats;
    
    public BookingThread(TicketBookingSystem bookingSystem, String name, int seats, int priority) {
        this.bookingSystem = bookingSystem;
        this.name = name;
        this.seats = seats;
        this.setPriority(priority);
    }
    
    @Override
    public void run() {
        bookingSystem.bookTicket(name, seats);
    }
}

public class ticketbooking {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n1. Book Ticket");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            if (choice == 1) {
                System.out.print("Enter your name: ");
                String name = scanner.nextLine();
                System.out.print("Enter number of seats to book: ");
                int seats = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter priority (1-10, 10 for VIP): ");
                int priority = scanner.nextInt();
                scanner.nextLine();
                
                BookingThread t = new BookingThread(bookingSystem, name, seats, priority);
                t.start();
                
                try {
                    t.join();
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted.");
                }
            } else if (choice == 2) {
                System.out.println("Exiting...");
                scanner.close();
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
