package com.example.examen.efinal2_api_pw_p6_fch.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.examen.efinal2_api_pw_p6_fch.repository.model.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepositoryImpl implements IVehiculoRepository {


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void guardar(Vehiculo vehiculo) {
        // TODO Auto-generated method stub
        this.entityManager.persist(vehiculo);
    }

    @Override
    public void actualizar(Vehiculo vehiculo) {
        // TODO Auto-generated method stub
        this.entityManager.merge(vehiculo);        
    }

    @Override
    public void eliminar(Vehiculo vehiculo) {
        this.entityManager.remove(vehiculo);
    }

    @Override
    public Vehiculo buscarPorId(Integer id) {
        return this.entityManager.find(Vehiculo.class, id);
    }

    @Override
    public List<Vehiculo> buscarTodos() {
        // TODO Auto-generated method stub
    TypedQuery<Vehiculo> query = this.entityManager.createQuery("SELECT v FROM Vehiculo v", Vehiculo.class);
    return query.getResultList();
    
    }

    @Override
    public Vehiculo buscarPorPlaca(String placa) {
        // TODO Auto-generated method stub
        TypedQuery<Vehiculo> query = this.entityManager.createQuery("SELECT v FROM Vehiculo v WHERE v.placa = :placa", Vehiculo.class);
        query.setParameter("placa", placa);
        return query.getSingleResult();
        
    }

    @Override
    public void eliminarPorPlaca(String placa) {
        // TODO Auto-generated method stub
        Vehiculo vehiculo = this.buscarPorPlaca(placa);
        this.eliminar(vehiculo);
    }
        
    
}
