package com.example.cm.examen_autorizacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cm.examen_autorizacion.security.JwtUtils;
import com.example.cm.examen_autorizacion.service.to.IngresoTO;
import com.example.cm.examen_autorizacion.service.to.UsuarioTO;

@RestController
@RequestMapping("/tokens")
@CrossOrigin
public class TokenControllerRestful {
    
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtils jwtUtils;

    @GetMapping("/obtener")
    public String obtenertoken(@RequestBody UsuarioTO usuario) {
        this.authenticated(usuario.getUsername(), usuario.getPassword());
        return this.jwtUtils.generateJWTToken(usuario.getUsername());
        
    }

    private void authenticated(String usuario, String password){
        Authentication authentication =  this.authManager.authenticate(new UsernamePasswordAuthenticationToken(usuario, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @GetMapping("/obtener2")
    public String obtenertoken2(@RequestBody IngresoTO ingreso) {
        this.authenticated("usuario", "123");
        return this.jwtUtils.generateJWTToken2("usuario",ingreso.getTiempo(),ingreso.getSemilla());
        
    }

}
