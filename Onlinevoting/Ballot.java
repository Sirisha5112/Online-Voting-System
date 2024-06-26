package com.Onlinevoting;

import java.util.List;

public class Ballot {
    private List<String> candidates;
    private String selectedCandidate;

    public Ballot(List<String> candidates) {
        this.candidates = candidates;
    }

    public List<String> getCandidates() {
        return candidates;
    }

    public String getSelectedCandidate() {
        return selectedCandidate;
    }

    public void setSelectedCandidate(String selectedCandidate) {
        this.selectedCandidate = selectedCandidate;
    }
}
