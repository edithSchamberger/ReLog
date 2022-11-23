package ar.edu.undef.fie.api.Relog.controller;

import ar.edu.undef.fie.api.Relog.model.request.SolicitudRequest;
import ar.edu.undef.fie.api.Relog.model.response.SolicitudDeRequerimientoResponse;
import ar.edu.undef.fie.api.Relog.model.response.SolicitudResponse;
import ar.edu.undef.fie.api.Relog.service.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/solicitud")
public class SolicitudController {

    @Autowired
    SolicitudService solicitudService;

    @PostMapping()
    public ResponseEntity<SolicitudResponse> create(@Valid @RequestBody SolicitudRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitudService.create(request));
    }

    @GetMapping("/{solicitud_id}")
    public ResponseEntity<SolicitudDeRequerimientoResponse> getSolicitudById(@PathVariable Long solicitud_id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(solicitudService.getSolicitud(solicitud_id));
    }

}
