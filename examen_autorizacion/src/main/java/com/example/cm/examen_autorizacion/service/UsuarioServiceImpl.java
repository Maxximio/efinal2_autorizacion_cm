package com.example.cm.examen_autorizacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.cm.examen_autorizacion.repository.IUsuarioRepo;
import com.example.cm.examen_autorizacion.repository.model.Usuario;

import static java.util.Collections.emptyList;

@Service
public class UsuarioServiceImpl implements UserDetailsService{

    @Autowired
    private IUsuarioRepo usuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usuario user=this.usuarioRepo.consultarPorUsername(username);
       return new User (user.getUsername(),user.getPassword(),emptyList());
    }

}