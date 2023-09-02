package com.example.cm.examen_autorizacion.repository;

import com.example.cm.examen_autorizacion.repository.model.Usuario;

public interface IUsuarioRepo {
    public Usuario consultarPorUsername(String username);
}
