package com.shop.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private SessionRegistry sessionRegistry;
    @GetMapping("/session")
    public ResponseEntity<?> getDetailSession(){
        String sessionId="";
        User userObject=null;
        List<Object> sessions=sessionRegistry.getAllPrincipals();
        for(Object session:sessions){
            if(session instanceof User){
                userObject= (User) session;
            }
            List<SessionInformation> sessionInformations=sessionRegistry.getAllSessions(session,false);
            for(SessionInformation sessionInformation:sessionInformations){
                sessionId=sessionInformation.getSessionId();
            }
        }
        Map<String,Object> response=new HashMap<>();
        response.put("response","Session");
        response.put("sessionId",sessionId);
        response.put("Session User :",userObject);
        return ResponseEntity.ok(response);
    }

}
