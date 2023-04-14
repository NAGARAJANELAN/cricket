package com.rajan.cricket.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private long matchesPlayed;
    private long matchesWon;

    @Transient
    private List<Match> matchList;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getMatchesPlayed() {
        return matchesPlayed;
    }
    public void setMatchesPlayed(long matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }
    public long getMatchesWon() {
        return matchesWon;
    }
    public void setMatchesWon(long matchesWon) {
        this.matchesWon = matchesWon;
    }
    public Team(String name, long matchesPlayed) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
    }


    public Team() {

    }
    public String toString(){
        return "Team : "+getName()+ " Matches : "+getMatchesPlayed()+" Won : "+getMatchesWon();
    }

    public List<Match> getMatchList() {
        return matchList;
    }
    public void setMatchList(List<Match> matchList) {
        this.matchList = matchList;
    }
}
