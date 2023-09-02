package com.example.cm.examen_autorizacion.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.cm.examen_autorizacion.repository.model.Usuario;

@Transactional
@Repository
public class UsuarioRepoImpl implements IUsuarioRepo{


    @PersistenceContext
    private EntityManager em;

    @Override
    public Usuario consultarPorUsername(String username) {
    
        TypedQuery<Usuario> myQuery =this.em
            .createQuery("Select a from Usuario a where a.username = :username",Usuario.class);
        myQuery.setParameter("username", username);

        return myQuery.getSingleResult();
    }
    
}
