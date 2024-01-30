package com.gcu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gcu.business.SecurityBusinessService;
import com.gcu.data.SearchDAOService;
import com.gcu.model.PostModel;
import com.gcu.model.SearchedUserModel;
import com.gcu.model.UserModel;

@Controller
@RequestMapping("/search-users")
public class SearchUsersController {
	
    @Autowired
    public SecurityBusinessService securityService; 
    
    @Autowired
    public SearchDAOService searchService;
    

    @GetMapping("/")
    public String display(Model model) 
    {
        model.addAttribute("title", "Search");       
        model.addAttribute("pageName", "Search");
        model.addAttribute("searchedUserModel", new SearchedUserModel()); 
        model.addAttribute("diffUser", new UserModel());
        model.addAttribute("users", new ArrayList<SearchedUserModel>());
        model.addAttribute("request-sent", false);
        
        return "search-users";
    }
    
    @PostMapping("/results")
    public ModelAndView searchUsers(@Valid SearchedUserModel searched, Model model) 
    {      
        ModelAndView homeView = new ModelAndView(); 
        model.addAttribute("diffUser", new UserModel());
        homeView.addObject("users", new ArrayList<SearchedUserModel>());
        homeView.addObject("users", searchService.getAllUsers(searched.searchValue));
        homeView.addObject("pageName", "Search");
        homeView.addObject("request-sent", false);
        homeView.setViewName("search-users");
        
        return homeView;
    }
    
    @PostMapping("/send-request")
    public ModelAndView sendRequest(@Valid UserModel diffUser, Model model) 
    {         
    	ModelAndView homeView = new ModelAndView();
        homeView.addObject("title", "Search");       
        homeView.addObject("pageName", "Search");
        homeView.addObject("searchedUserModel", new SearchedUserModel()); 
        homeView.addObject("users", new ArrayList<SearchedUserModel>());
        System.out.println(diffUser.getId());
        homeView.addObject("request-sent", searchService.addFriend(diffUser));
        homeView.setViewName("search-users");
        return homeView;
    }
}
