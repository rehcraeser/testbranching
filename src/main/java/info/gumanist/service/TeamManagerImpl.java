package info.gumanist.service;

import java.util.List;

import info.gumanist.dao.TeamDAO;
import info.gumanist.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamManagerImpl implements TeamManager {

    @Autowired
    private TeamDAO teamDAO;

    @Override
    @Transactional
    public void addTeam(Team team) {
        this.teamDAO.addTeam(team);
    }

    @Override
    @Transactional
    public List<Team> getAllTeams() {
        return this.teamDAO.getAllTeams();
    }

    @Override
    @Transactional
    public void deleteTeam(Long teamId) {
        this.teamDAO.deleteTeam(teamId);
    }

    public void setTeamDAO(TeamDAO teamDAO) {
        this.teamDAO = teamDAO;
    }
}
