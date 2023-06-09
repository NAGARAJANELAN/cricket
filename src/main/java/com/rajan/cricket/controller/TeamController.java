package com.rajan.cricket.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rajan.cricket.model.Match;
import com.rajan.cricket.model.Team;
import com.rajan.cricket.repository.MatchRepository;
import com.rajan.cricket.repository.TeamRepository;

@RestController
@CrossOrigin
public class TeamController {
    
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private MatchRepository matchRepository;


    @GetMapping("/teams")
    public Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/teams/{teamName}")
    public Team getTeam(@PathVariable String teamName){
        Team team=teamRepository.findByName(teamName);
        team.setMatchList(matchRepository.getLatestMatchesByTeam(teamName,4));
        return team;
    }

    @GetMapping("/teams/{teamName}/matches")
    public List<Match> getTeamMatchByYear(@PathVariable String teamName, @RequestParam int year) {
        LocalDate startDate=LocalDate.of(year,1,1);
        LocalDate endDate=LocalDate.of(year+1,1,1);
        return matchRepository.getMatchesByTeamBetweenDates(teamName,startDate,endDate);
    }
}
