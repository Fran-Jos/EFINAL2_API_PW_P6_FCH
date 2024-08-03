package com.example.examen.efinal2_api_pw_p6_fch.service.to;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

public class VehiculoDTO extends RepresentationModel<VehiculoDTO> implements Serializable {

    private static final long serialVersionUID = 2L;
    private String placa;
    private String marca;
    private String modelo;

    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
