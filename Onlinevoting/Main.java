package com.Onlinevoting;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VotingSystem votingSystem = new VotingSystem(Arrays.asList("BJP", "Congress", "Communist Party", "Aam Aadmi Party"));

        while (true) {
            System.out.println("\nOnline Voting System");
            System.out.println("1. Register Voter");
            System.out.println("2. Cast Vote");
            System.out.println("3. Display Results");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerVoter(scanner, votingSystem);
                    break;
                case 2:
                    castVote(scanner, votingSystem);
                    break;
                case 3:
                    votingSystem.displayResults();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void registerVoter(Scanner scanner, VotingSystem votingSystem) {
        System.out.print("Enter voter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter voter name: ");
        String name = scanner.nextLine();
        Voter voter = new Voter(id, name);
        votingSystem.registerVoter(voter);
        System.out.println("Voter registered successfully.");
    }

    private static void castVote(Scanner scanner, VotingSystem votingSystem) {
        System.out.print("Enter voter ID: ");
        int voterId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Candidates: " + votingSystem.getCandidates());
        System.out.print("Enter candidate name to vote for: ");
        String selectedCandidate = scanner.nextLine();

        boolean success = votingSystem.castVote(voterId, selectedCandidate);
        if (success) {
            System.out.println("Vote cast successfully.");
        } else {
            System.out.println("Invalid voter ID or candidate name, or voter has already voted.");
        }
    }
}
