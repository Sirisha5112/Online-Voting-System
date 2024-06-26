package com.Onlinevoting;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VotingSystem {
    private List<Voter> voters;
    private List<String> candidates;
    private Map<String, Integer> votes;

    public VotingSystem(List<String> candidates) {
        this.voters = new ArrayList<>();
        this.candidates = candidates;
        this.votes = new HashMap<>();
        for (String candidate : candidates) {
            votes.put(candidate, 0);
        }
    }

    public void registerVoter(Voter voter) {
        voters.add(voter);
    }

    public Voter findVoterById(int id) {
        for (Voter voter : voters) {
            if (voter.getId() == id) {
                return voter;
            }
        }
        return null;
    }

    public boolean castVote(int voterId, String selectedCandidate) {
        Voter voter = findVoterById(voterId);
        if (voter != null) {
            if (!voter.hasVoted() && votes.containsKey(selectedCandidate)) {
                votes.put(selectedCandidate, votes.get(selectedCandidate) + 1);
                voter.setVoted(true);
                return true;
            } else {
                System.out.println("Voter has already voted or invalid candidate name.");
            }
        } else {
            System.out.println("Invalid voter ID.");
        }
        return false;
    }

    public List<String> getCandidates() {
        return candidates;
    }

    public void displayResults() {
        System.out.println("Election Results:");
        String winner = null;
        int maxVotes = 0;
        boolean tie = false;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");

            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
                tie = false;
            } else if (entry.getValue() == maxVotes) {
                tie = true;
            }
        }

        if (tie) {
            System.out.println("The election resulted in a tie.");
        } else {
            System.out.println("The winner is: " + winner + " with " + maxVotes + " votes");
        }
    }
}
