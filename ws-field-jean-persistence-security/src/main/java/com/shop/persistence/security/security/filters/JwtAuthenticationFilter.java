package com.shop.persistence.security.security.filters;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.persistence.security.entity.UsersSecurityEntity;
import com.shop.persistence.security.security.jwt.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Log4j2
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter  {

    private JwtUtils jwtUtils;
    public JwtAuthenticationFilter(JwtUtils jwtUtils){
        this.jwtUtils=jwtUtils;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        UsersSecurityEntity user=null;
        String userName;
        String password;
        try {
            user=new ObjectMapper().readValue(request.getInputStream(),UsersSecurityEntity.class);
            userName = user.getUsername();
            password = user.getPassword();
        }catch (StreamReadException e) {
            throw new RuntimeException(e);
        }catch (DatabindException e){
            throw new RuntimeException(e);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        UsernamePasswordAuthenticationToken authenticationToken=new
                UsernamePasswordAuthenticationToken(userName,password);

        return getAuthenticationManager().authenticate(authenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
       User user= (User) authResult.getPrincipal();
       String token=jwtUtils.generateAccessToken(user.getUsername());
       response.addHeader("Authorization",token);
       Map<String,Object> httpResponse=new HashMap<>();
       httpResponse.put("token",token);
       httpResponse.put("Message","Autenticacion Correcta");
       httpResponse.put("Username",user.getUsername());
       response.getWriter().write(new ObjectMapper().writeValueAsString(httpResponse));
       response.setStatus(HttpStatus.OK.value());
       response.setContentType(MediaType.APPLICATION_JSON_VALUE);
       response.getWriter().flush();
        super.successfulAuthentication(request, response, chain, authResult);
    }
}
