package com.example.examen.efinal2_api_pw_p6_fch.repository;

import java.util.List;

import com.example.examen.efinal2_api_pw_p6_fch.repository.model.Vehiculo;

public interface IVehiculoRepository {

    public void guardar(Vehiculo vehiculo);
    public void actualizar(Vehiculo vehiculo);
    public void eliminar(Vehiculo vehiculo);
    public Vehiculo buscarPorId(Integer id);
    public List<Vehiculo> buscarTodos();
    public Vehiculo buscarPorPlaca(String placa);
    public void eliminarPorPlaca(String placa);
    
    
}
