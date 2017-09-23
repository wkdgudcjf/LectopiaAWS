package com.example.category.controller;

import com.example.category.config.SessionWire;
import com.example.category.entity.*;
import com.example.category.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ServerService serverService;
    @Autowired
    TrafficService trafficService;
    @Autowired
    RegionService regionService;
    @Autowired
    AdditionalService additionalService;
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
        return "redirect:/web/managementUser";
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
        model.addAttribute("serviceList", additionalService.getAdditionalList());
        model.addAttribute("regionList", regionService.getRegionList());
        User user = userService.getUser(sessionWire.getId());
        List<Server> list = null;
        if(sessionWire.getAdmin() == true) {
            list = serverService.getServerList();
        }
        else{
            list = new ArrayList<Server>();
            list.add(userService.getUser(sessionWire.getId()).getServer());
        }
        for (Server server:list)
        {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i< server.getRegionList().size();i++)
            {
                if(i==server.getRegionList().size()-1)
                {
                    sb.append(server.getRegionList().get(i).getName());
                }
                else
                {
                    sb.append(server.getRegionList().get(i).getName()+" / ");
                }
            }
            server.setRegionString(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            for(int i=0;i< server.getAdditionalList().size();i++)
            {
                if(i==server.getAdditionalList().size()-1)
                {
                    sb2.append(server.getAdditionalList().get(i).getName());
                }
                else
                {
                    sb2.append(server.getAdditionalList().get(i).getName()+" / ");
                }
            }
            server.setAdditionalString(sb2.toString());
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
            list = trafficService.getTrafficList();
        }
        else{
            list = trafficService.getTrafficList(userService.getUser(sessionWire.getId()).getServer().getId());
        }
        model.addAttribute("trafficList", list);
        return "managementTraffic";
    }
    @RequestMapping(value = "/managementUser", method = RequestMethod.GET)
    public String managementUser(Model model) {
        if(sessionWire.getId()==0) {
            return "redirect:/web/login";
        }
        model.addAttribute("id",  sessionWire.getId());
        model.addAttribute("admin",  sessionWire.getAdmin());
        List<User> list = null;
        if(sessionWire.getAdmin() == true) {
            list = userService.getUserList();
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).getServer()==null)
                {
                    Server temp = new Server();
                    temp.setMainUrl("서버없음");
                    list.get(i).setServer(temp);
                }
            }
        }
        else{
            User user = userService.getUser(sessionWire.getId());
            list = new ArrayList<User>();
            list.add(user);
        }
        model.addAttribute("userList", list);
        //관리자일 경우 각 유저마다 가격넣어주기?
        //전체가격? 계산값 넣어주기?
        return "managementUser";
    }
    @RequestMapping(value = "/registServer", method = RequestMethod.POST)
    public ResponseEntity<String> registServer(@RequestParam("serverMainUrl") String serverMainUrl,
                                               @RequestParam("serverMem") String serverMem,
                                               @RequestParam("serverService") List<String> serverServiceList,
                                               @RequestParam("serverRegion") List<String> serverRegionList)
    {

        Server server = new Server();
        server.setMainUrl(serverMainUrl);
        server.setTotalMem(Integer.parseInt(serverMem));

        ArrayList<Additional> slist = (ArrayList)additionalService.getAdditionalList();
        ArrayList<Additional> addAlist = new ArrayList<Additional>();
        for(String t1 : serverServiceList){
            for(Additional t2 : slist ){
                if(Integer.parseInt(t1) == t2.getId()) addAlist.add(t2);
            }
        }
        ArrayList<Region> rlist =  (ArrayList)regionService.getRegionList();
        ArrayList<Region> addRlist = new ArrayList<Region>();
        for(String t1 : serverRegionList){
            for(Region t2 : rlist ){
                if(Integer.parseInt(t1) == t2.getId()) addRlist.add(t2);
            }
        }
        server.setRegionList(addRlist);
        server.setAdditionalList(addAlist);

        long id = serverService.saveServer(server);
        userService.updateUserServer(sessionWire.getId(),id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
