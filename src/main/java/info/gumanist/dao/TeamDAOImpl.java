package info.gumanist.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.gumanist.domain.Team;

@Repository
public class TeamDAOImpl implements TeamDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTeam(Team team) {
        this.sessionFactory.getCurrentSession().save(team);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Team> getAllTeams() {
        return this.sessionFactory.getCurrentSession().createQuery("from Team").list();
    }

    @Override
    public void deleteTeam(Long teamId) {
        Team team = sessionFactory.getCurrentSession().load(Team.class, teamId);
        if (null != team)
            sessionFactory.getCurrentSession().delete(team);

    }
}
