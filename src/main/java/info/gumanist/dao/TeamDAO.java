package info.gumanist.dao;

import info.gumanist.domain.Team;
import java.util.List;

public interface TeamDAO {
    public void addTeam(Team team);
    public List<Team> getAllTeams();
    public void deleteTeam(Long teamId);
}
