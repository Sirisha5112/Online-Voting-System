package com.Onlinevoting;

public class Voter {
    private int id;
    private String name;
    private boolean hasVoted;

    public Voter(int id, String name) {
        this.id = id;
        this.name = name;
        this.hasVoted = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void setVoted(boolean hasVoted) {
        this.hasVoted = hasVoted;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hasVoted=" + hasVoted +
                '}';
    }
}
