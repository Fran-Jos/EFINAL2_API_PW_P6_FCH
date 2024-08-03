package com.example.examen.efinal2_api_pw_p6_fch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.examen.efinal2_api_pw_p6_fch.repository.IVehiculoRepository;
import com.example.examen.efinal2_api_pw_p6_fch.repository.model.Vehiculo;
import com.example.examen.efinal2_api_pw_p6_fch.service.to.VehiculoDTO;
import com.example.examen.efinal2_api_pw_p6_fch.service.to.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService{

    @Autowired
    private IVehiculoRepository iVehiculoRepository;

    @Override
    public void guardar(VehiculoTO vehiculo) {
        this.iVehiculoRepository.guardar(convertirVehiculo(vehiculo));
    }

    @Override
    public void actualizar(VehiculoTO vehiculo) {
        // TODO Auto-generated method stub
        this.iVehiculoRepository.actualizar(convertirVehiculo(vehiculo));

    }

    @Override
    public void eliminar(VehiculoTO vehiculo) {
        // TODO Auto-generated method stub
        this.iVehiculoRepository.eliminar(convertirVehiculo(vehiculo));

    }

    @Override
    public VehiculoTO buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        Vehiculo vehiculo = this.iVehiculoRepository.buscarPorId(id);
        return convertirVehiculoTO(vehiculo);
    }

    @Override
    public List<VehiculoTO> buscarTodos() {
        // TODO Auto-generated method stub
        List<Vehiculo> vehiculos = this.iVehiculoRepository.buscarTodos();
        List<VehiculoTO> vehiculosTO = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            vehiculosTO.add(convertirVehiculoTO(vehiculo));
          
        }
        return vehiculosTO;
    }

    @Override
    public List<VehiculoDTO> listarDTO() {
        // TODO Auto-generated method stub
        List<Vehiculo> vehiculos = this.iVehiculoRepository.buscarTodos();
        List<VehiculoDTO> vehiculosDTO = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            VehiculoDTO vehiculoDTO = new VehiculoDTO();
            vehiculoDTO.setPlaca(vehiculo.getPlaca());
            vehiculoDTO.setMarca(vehiculo.getMarca());
            vehiculoDTO.setModelo(vehiculo.getModelo());
            vehiculosDTO.add(vehiculoDTO);
        }
        return vehiculosDTO;
    }


    @Override
    public VehiculoTO buscarPorPlaca(String placa) {
        // TODO Auto-generated method stub
        Vehiculo vehiculo = this.iVehiculoRepository.buscarPorPlaca(placa);
        return convertirVehiculoTO(vehiculo);
    }

    public VehiculoTO convertirVehiculoTO(Vehiculo vehiculo) {
        // TODO Auto-generated method stub
     VehiculoTO vehiculoTO = new VehiculoTO();
        vehiculoTO.setPlaca(vehiculo.getPlaca());
        vehiculoTO.setMarca(vehiculo.getMarca());
        vehiculoTO.setModelo(vehiculo.getModelo());
        vehiculoTO.setColor(vehiculo.getColor());
        vehiculoTO.setPrecio(vehiculo.getPrecio());
        vehiculoTO.setId(vehiculo.getId());
        return vehiculoTO;
    }

    public Vehiculo convertirVehiculo(VehiculoTO vehiculoTO) {
        // TODO Auto-generated method stub
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPlaca(vehiculoTO.getPlaca());
        vehiculo.setMarca(vehiculoTO.getMarca());
        vehiculo.setModelo(vehiculoTO.getModelo());
        vehiculo.setColor(vehiculoTO.getColor());
        vehiculo.setPrecio(vehiculoTO.getPrecio());
        vehiculo.setId(vehiculoTO.getId());
        return vehiculo;
    }

    @Override
    public void eliminarPorPlaca(String placa) {
        // TODO Auto-generated method stub
    Vehiculo vehiculo = this.iVehiculoRepository.buscarPorPlaca(placa);
    this.iVehiculoRepository.eliminar(vehiculo);
}
    
}
