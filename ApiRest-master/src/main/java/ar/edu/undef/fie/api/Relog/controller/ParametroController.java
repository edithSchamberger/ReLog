package ar.edu.undef.fie.api.Relog.controller;

import ar.edu.undef.fie.api.Relog.model.request.ParametroRequest;
import ar.edu.undef.fie.api.Relog.model.response.ParametroResponse;
import ar.edu.undef.fie.api.Relog.service.ParametroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParametroController {
    private final ParametroService parametroService;

    public ParametroController(ParametroService parametroService) {
        this.parametroService = parametroService;
    }

    @GetMapping(value = "usuarios/{idUser}/parametros")
    public ResponseEntity<ParametroResponse> getParametros(@PathVariable Long idUser) {
        return ResponseEntity.ok(parametroService.getParametros(idUser).representation());
    }

    @PutMapping(value = "parametros")
    public ResponseEntity<ParametroResponse>  modificarParametros(@RequestBody ParametroRequest parametroRequest) {
        return ResponseEntity.ok(parametroService.modificarParametros(parametroRequest.construct()).representation());

    }
}
