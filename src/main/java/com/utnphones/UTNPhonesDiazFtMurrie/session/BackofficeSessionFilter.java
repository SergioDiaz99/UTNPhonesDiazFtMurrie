package com.utnphones.UTNPhonesDiazFtMurrie.session;

import com.utnphones.UTNPhonesDiazFtMurrie.controller.web.AdviceController;
import com.utnphones.UTNPhonesDiazFtMurrie.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class BackofficeSessionFilter extends OncePerRequestFilter {

    @Autowired
    private SessionManager sessionManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                              HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String sessionToken = request.getHeader("Authorization");
        Session session = sessionManager.getSession(sessionToken);
        if(null != session){
            if(sessionManager.getCurrentUser(sessionToken) == null)
                response.setStatus(HttpStatus.FORBIDDEN.value());
            else if (sessionManager.getCurrentUser(sessionToken).getUserType().getDescription().equals("Employee")) {
                filterChain.doFilter(request, response);
            }
            else
            {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
            }
        }
        else
            response.setStatus(HttpStatus.FORBIDDEN.value());
    }

}
