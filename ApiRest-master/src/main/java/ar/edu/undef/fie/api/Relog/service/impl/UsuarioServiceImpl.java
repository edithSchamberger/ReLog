package ar.edu.undef.fie.api.Relog.service.impl;

import ar.edu.undef.fie.api.Relog.model.entity.inicio.Usuario;
import ar.edu.undef.fie.api.Relog.repository.UsuarioRepository;
import ar.edu.undef.fie.api.Relog.service.UsuarioService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }


    @Override
    public Usuario getUsuario(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public void eliminar(Usuario usuario) {
        usuarioRepository.delete(usuario);
    }

    @Override
    public Usuario registrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {

        Usuario userEncontrado = usuarioRepository.findByEmail(usuario.getEmail());
        if (userEncontrado== null) {
            return null;
        }

        String passwordHashed = userEncontrado.getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(passwordHashed, usuario.getPassword())) {
            return userEncontrado;
        }
        return null;
    }

    @Override
    public Usuario findById(Long idUser) {
        return usuarioRepository.findById(idUser);
    }
}

