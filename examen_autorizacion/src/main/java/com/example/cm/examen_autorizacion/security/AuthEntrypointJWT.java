package com.example.cm.examen_autorizacion.security;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthEntrypointJWT implements AuthenticationEntryPoint{
    private static final Logger LOG = LoggerFactory.getLogger(AuthEntrypointJWT.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException, ServletException {
        LOG.error("Unauthorized error {}", authException.getMessage());
        LOG.error(request.getServletPath());                                                                                                                                                          
    }


    
}
