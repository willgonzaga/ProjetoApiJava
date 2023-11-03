package com.example.ProjetoJava.repository;

import com.example.ProjetoJava.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(value="select * from clientes where nome like ?1%", nativeQuery = true)
    public List<Cliente> findByName(String nome);

    @Query(value="select * from clientes where email = ?1", nativeQuery = true)
    public List<Cliente> findByEmail(String email);

    @Query(value="select * from clientes where nome like %?1% and email like %?2%", nativeQuery = true)
    public List<Cliente> findByNameEmail(String name, String email);
}
