package ar.edu.undef.fie.api.Relog.service;

import ar.edu.undef.fie.api.Relog.model.entity.inicio.Usuario;

public interface UsuarioService {
    Usuario getUsuario(String email);

    void eliminar(int id);

    Usuario registrar(Usuario usuario);

    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}

