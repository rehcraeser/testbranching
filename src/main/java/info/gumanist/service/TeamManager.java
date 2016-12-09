package info.gumanist.service;

import java.util.List;
import info.gumanist.domain.Team;

public interface TeamManager {
    public void addTeam(Team team);
    public List<Team> getAllTeams();
    public void deleteTeam(Long teamId);
}
