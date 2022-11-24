package ar.edu.undef.fie.api.Relog.controller;

import ar.edu.undef.fie.api.Relog.exception.GenericAlreadyExistsExeption;
import ar.edu.undef.fie.api.Relog.model.entity.inicio.Usuario;
import ar.edu.undef.fie.api.Relog.model.request.UsuarioRequest;
import ar.edu.undef.fie.api.Relog.model.response.UsuarioResponse;
import ar.edu.undef.fie.api.Relog.service.UsuarioService;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioController {
    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;

    }


    @GetMapping(value = "usuarios/{email}")
    public ResponseEntity<UsuarioResponse> getUsuarioController(@PathVariable String email) {
        return ResponseEntity.ok(usuarioService.getUsuario(email).representation());
    }

    @PostMapping(value = "usuarios")
    public ResponseEntity<UsuarioResponse> registrarUsuario(@RequestBody UsuarioRequest usuarioRequest) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuarioRequest.getPassword());
        usuarioRequest.setPassword(hash);
        Usuario usuario = usuarioRequest.construct();
        return ResponseEntity.ok(usuarioService.registrar(usuario).representation());
    }


    @DeleteMapping(value = "/usuarios/{idUser}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Long idUser) throws GenericAlreadyExistsExeption {

        usuarioService.eliminar(usuarioService.findById(idUser));
        return new ResponseEntity<>(
                "Usuario eliminado con éxito",
                HttpStatus.OK);
    }
}
