package info.gumanist.controller;

import info.gumanist.domain.Team;
import info.gumanist.service.TeamManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    private TeamManager teamManager;

    @RequestMapping(value = "/team/", method = RequestMethod.GET)
    public List<Team> getTeams(){
        return teamManager.getAllTeams();
    }

    @RequestMapping(value = "/team/{id}", method = RequestMethod.DELETE)
    public void deleteTeam(@PathVariable("id") Long id) {
        teamManager.deleteTeam(id);
    }
}