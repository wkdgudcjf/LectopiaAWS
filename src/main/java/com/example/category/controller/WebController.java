package com.example.category.controller;

import com.example.category.config.SessionWire;
import com.example.category.entity.Server;
import com.example.category.entity.Traffic;
import com.example.category.entity.User;
import com.example.category.service.ServerService;
import com.example.category.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksb on 2017. 9. 23..
 */
@Controller
@RequestMapping("/web")
public class WebController {

    @Autowired
    SessionWire sessionWire;
    @Autowired
    UserService userService;
    @Autowired
    ServerService serverSerivce;

    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }
    @RequestMapping(value = {"/agreement"}, method = RequestMethod.GET)
    public String agreement(Model model) {
        return "agreement";
    }
    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String join(Model model) {
        return "join";
    }
    @RequestMapping(value={"/login"}, method = RequestMethod.POST)
    public String loginPost(Model model, @RequestParam("email") String email, @RequestParam("password") String password)
    {
        User user = userService.login(email,password);
        if(user.isAdmin()) {
            sessionWire.setAdmin(true);
        }
        else
        {
            sessionWire.setAdmin(false);
        }
        sessionWire.setId(user.getId());
        return "redirect:/web/managementServer";
    }
    @RequestMapping(value={"/logout"}, method = RequestMethod.GET)
    public String logout(Model model){
        if(sessionWire.getId()!=0) // 기본값이 뭐지??
        {
            sessionWire.invaildate();
        }
        return "redirect:web/login";
    }
    @RequestMapping(value={"/join"}, method = RequestMethod.POST)
    public String joinPost(Model model, @RequestParam("password") String password,
                           @RequestParam("email") String email,@RequestParam("admin") boolean admin){
        userService.saveUser(email,password,admin);
        return "redirect:/web/login";
    }
    @RequestMapping(value = "/managementServer", method = RequestMethod.GET)
    public String managementServer(Model model) {
        if(sessionWire.getId()==0) {
            return "redirect:/web/login";
        }
        model.addAttribute("id",  sessionWire.getId());
        model.addAttribute("admin",  sessionWire.getAdmin());
        model.addAttribute("serviceList",  serverSerivce.getServerList());
        model.addAttribute("regionList",  userService.getRegionList());
        List<Server> list = null;
        if(sessionWire.getAdmin() == true) {
            list = serverSerivce.getServerList();
        }
        else{
            list = new ArrayList<Server>();
            list.add(userService.getUser(sessionWire.getId()).getServer());
        }
        model.addAttribute("serverList", list);
        return "managementServer";
    }
    @RequestMapping(value = "/managementTraffic", method = RequestMethod.GET)
    public String managementTraffic(Model model) {
        if(sessionWire.getId()==0) {
            return "redirect:/web/login";
        }
        model.addAttribute("id",  sessionWire.getId());
        model.addAttribute("admin",  sessionWire.getAdmin());
        List<Traffic> list = null;
        if(sessionWire.getAdmin() == true) {
            list = userService.getTrafficList();
        }
        else{
            list = userService.getTrafficList(sessionWire.getId());
        }
        model.addAttribute("trafficList", list);
        return "managementTraffic";
    }
    @RequestMapping(value = "/managementUser", method = RequestMethod.GET)
    public String managementTraffic(Model model) {
        if(sessionWire.getId()==0) {
            return "redirect:/web/login";
        }
        model.addAttribute("id",  sessionWire.getId());
        model.addAttribute("admin",  sessionWire.getAdmin());
        List<Server> list = null;
        if(sessionWire.getAdmin() == true) {
            list = serverSerivce.getServerList();
        }
        else{
            list = userService.getUserList(sessionWire.getId());
        }
        model.addAttribute("userList", list);
        //관리자일 경우 각 유저마다 가격넣어주기?
        //전체가격? 계산값 넣어주기?
        return "managementUser";
    }
    @RequestMapping(value = "/registServer", method = RequestMethod.POST)
    public ResponseEntity<String> registServer(@RequestParam("serverMainUrl") String serverMainUrl,
                                               @RequestParam("serverMem") String serverMem,@RequestParam("serverUrl") String serverUrl,
                                               @RequestParam("serverService") String serverService,
                                               @RequestParam("serverRegion") String serverRegion)
    {

        Server server = new Server();
        server.setMainUrl(serverMainUrl);
        server.setTotalMem(Integer.parseInt(serverMem));


        long id = serverSerivce.saveServer(server);
        userService.update(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
