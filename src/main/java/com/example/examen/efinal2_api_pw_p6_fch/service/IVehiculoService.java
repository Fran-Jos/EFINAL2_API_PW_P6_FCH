package com.example.examen.efinal2_api_pw_p6_fch.service;

import java.util.List;

import com.example.examen.efinal2_api_pw_p6_fch.service.to.VehiculoDTO;
import com.example.examen.efinal2_api_pw_p6_fch.service.to.VehiculoTO;

public interface IVehiculoService {
    
    public void guardar(VehiculoTO vehiculo);
    public void actualizar(VehiculoTO vehiculo);
    public void eliminar(VehiculoTO vehiculo);
    public VehiculoTO buscarPorId(Integer id);
    public List<VehiculoTO> buscarTodos();
    public VehiculoTO buscarPorPlaca(String placa);
    public List<VehiculoDTO> listarDTO();
    public void eliminarPorPlaca(String placa);

    

}
