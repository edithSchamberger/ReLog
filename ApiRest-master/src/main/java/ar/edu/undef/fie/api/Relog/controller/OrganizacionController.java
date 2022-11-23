package ar.edu.undef.fie.api.Relog.controller;

import ar.edu.undef.fie.api.Relog.service.OrganizacionService;
import ar.edu.undef.fie.api.Relog.model.request.OrganizacionRequest;
import ar.edu.undef.fie.api.Relog.model.response.EfectoResponse;
import ar.edu.undef.fie.api.Relog.model.response.MovimientoSimpleResponse;
import ar.edu.undef.fie.api.Relog.model.response.OrganizacionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/organizacion")
public class OrganizacionController {

    @Autowired
    OrganizacionService organizacionService;

    @PostMapping()
    public ResponseEntity<OrganizacionResponse> create(@Valid @RequestBody OrganizacionRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(organizacionService.create(request));
    }

    @GetMapping("/{organizacion_id}/movimientos")
    public ResponseEntity<List<MovimientoSimpleResponse>> getMovimientosByOrganizacionid(@PathVariable Long organizacion_id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(organizacionService.getMovimientos(organizacion_id));
    }

    @GetMapping("/{organizacion_id}")
    public ResponseEntity<OrganizacionResponse> getOrganizacionById(@PathVariable Long organizacion_id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(organizacionService.getOrganizacionById(organizacion_id));
    }

    @GetMapping("/{organizacion_id}/efectos")
    public ResponseEntity<List<EfectoResponse>> getEfectosByOrganizacionid(@PathVariable Long organizacion_id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(organizacionService.getEfectos(organizacion_id));
    }

}
