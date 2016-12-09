package info.gumanist.controller;

import info.gumanist.domain.User;
import info.gumanist.domain.Team;
import info.gumanist.domain.Role;
import info.gumanist.service.TeamManager;
import info.gumanist.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditUserController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private TeamManager teamManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap map) {
        map.addAttribute("user", new User());
        map.addAttribute("userList", userManager.getAllUsers());
        map.addAttribute("teamList", teamManager.getAllTeams());

        return "editUserList";
    }

    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String initTables(ModelMap map) {
        String mess = "Init done.";

        Team team = new Team("Dream Team");
        teamManager.addTeam(team);
        teamManager.addTeam(new Team("RiF"));
        teamManager.addTeam(new Team("Stay Alive"));
        teamManager.addTeam(new Team("iTeam"));

        userManager.addUser(new User("Axl Rose", team, Role.SCRUM));
        userManager.addUser(new User("Ozzy", team, Role.DEVELOPER));
        userManager.addUser(new User("Doro", team, Role.MANAGER));
        userManager.addUser(new User("Udo", team, Role.ANALYST));

        map.addAttribute("r_mess", mess);

        return "opResult";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute(value="user") User user, BindingResult result) {
//        userManager.addUser(user);
        String mess = "";
        mess = user.getId() + " " + user.getName() + " " + user.getRole() + " " + user.getTeam();
        System.out.println("[ADD]" + mess);
        return "redirect:/";
    }

    @RequestMapping("/u_delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId) {
        userManager.deleteUser(userId);
        return "redirect:/";
    }

    @RequestMapping("/t_delete/{teamId}")
    public String deleteTeam(@PathVariable("teamId") Long teamId) {
        teamManager.deleteTeam(teamId);
        return "redirect:/";
    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}