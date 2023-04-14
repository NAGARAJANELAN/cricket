package com.rajan.cricket.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.rajan.cricket.model.Match;

@Component
public interface MatchRepository extends CrudRepository<Match,String>{
    
    List<Match> getByTeam1OrTeam2OrderByDateDesc(String team1,String team2,Pageable pageable);

    @Query("select m from Match m where (m.team1= :teamName or m.team2= :teamName) and m.date between :startDate and :endDate order by date desc")
    List<Match> getMatchesByTeamBetweenDates(@Param("teamName") String teamName,@Param("startDate") LocalDate startDate,@Param("endDate") LocalDate endDate);

    default List<Match> getLatestMatchesByTeam(String teamName,int count){
        Pageable pageable=PageRequest.of(0,count);
        return getByTeam1OrTeam2OrderByDateDesc(teamName, teamName, pageable);
    }
}
