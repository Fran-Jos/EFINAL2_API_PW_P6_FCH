package com.example.examen.efinal2_api_pw_p6_fch.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.examen.efinal2_api_pw_p6_fch.repository.model.Vehiculo;
import com.example.examen.efinal2_api_pw_p6_fch.service.IVehiculoService;
import com.example.examen.efinal2_api_pw_p6_fch.service.to.VehiculoDTO;
import com.example.examen.efinal2_api_pw_p6_fch.service.to.VehiculoTO;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@CrossOrigin
@RequestMapping("/vehiculos")
public class VehiculoController {

    @Autowired
    private IVehiculoService iVehiculoService;

    // http://localhost:8081/API/v1.0/Concesionario/vehiculos
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehiculoTO> guardar(@RequestBody VehiculoTO vehiculoTO) {
        this.iVehiculoService.guardar(vehiculoTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("200", "Guardado");
        return ResponseEntity.ok().headers(headers).build();
    }

    // http://localhost:8081/API/v1.0/Concesionario/vehiculos/1
    // controller
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<VehiculoTO> actualizar(@PathVariable Integer id, @RequestBody VehiculoTO vehiculoTO) {
        VehiculoTO vehiculo = this.iVehiculoService.buscarPorId(id);
       if(vehiculo != null) {
              vehiculoTO.setId(id);
              vehiculoTO.setPlaca(vehiculo.getPlaca());
                vehiculoTO.setMarca(vehiculo.getMarca());
                vehiculoTO.setModelo(vehiculo.getModelo());
                vehiculoTO.setColor(vehiculo.getColor());
                vehiculoTO.setPrecio(vehiculo.getPrecio());
           this.iVehiculoService.actualizar(vehiculoTO);
           HttpHeaders headers = new HttpHeaders();
           headers.add("200", "Actualizado");
           return ResponseEntity.ok().headers(headers).build();
       } else {
           HttpHeaders headers = new HttpHeaders();
           headers.add("404", "No encontrado");
           return ResponseEntity.notFound().headers(headers).build();
       }
    }

    // http://localhost:8081/API/v1.0/Concesionario/vehiculos/1
    @DeleteMapping(path = "/{placa}")
    public void eliminar(@PathVariable String placa) {
        this.iVehiculoService.eliminarPorPlaca(placa);
        HttpHeaders headers = new HttpHeaders();
        headers.add("200", "Eliminado");
    }

    // http://localhost:8081/API/v1.0/Concesionario/vehiculos
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<VehiculoDTO> buscarTodosDTO() {
        List<VehiculoDTO> vehiculosDTO = this.iVehiculoService.listarDTO();
        for (VehiculoDTO vehiculoDTO : vehiculosDTO) {
                   Link link = linkTo(methodOn(VehiculoController.class).buscarPorPlaca(vehiculoDTO.getPlaca()))
        .withRel("VehiculoCompleta");
        vehiculoDTO.add(link);
        }
        return vehiculosDTO;
    }

    // http://localhost:8081/API/v1.0/Concesionario/vehiculos/1
    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehiculoTO buscarPorId(Integer id) {
        this.iVehiculoService.buscarPorId(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("200", "Buscado");
        return this.iVehiculoService.buscarPorId(id);
    }

    // http://localhost:8081/API/v1.0/Concesionario/vehiculos/placa/ABC123
    @GetMapping(path = "/placa/{placa}", produces = MediaType.APPLICATION_JSON_VALUE)
    public VehiculoTO buscarPorPlaca(String placa) {
        this.iVehiculoService.buscarPorPlaca(placa);
        HttpHeaders headers = new HttpHeaders();
        headers.add("200", "Buscado");
        return this.iVehiculoService.buscarPorPlaca(placa);
    }

}

