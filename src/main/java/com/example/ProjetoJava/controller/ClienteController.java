package com.example.ProjetoJava.controller;

import com.example.ProjetoJava.model.Cliente;
import com.example.ProjetoJava.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/apiCliente")
public class ClienteController {
    @Autowired
    ClienteRepository cl;

    @RequestMapping("/findAll")
    public List<Cliente> findAll() {
        return cl.findAll();
    }

    @RequestMapping("/findByCod/{cod}")
    public Optional<Cliente> findByCod(@PathVariable(value="cod") int cod) {
        return cl.findById(cod);
    }

    @RequestMapping("/findByName/{nome}")
    public List<Cliente> findByName(@PathVariable(value="nome") String nome) {
        return cl.findByName(nome);
    }

    @RequestMapping("/findByEmail/{email}")
    public List<Cliente> findByEmail(@PathVariable(value="email") String email) {
        return cl.findByEmail(email);
    }

    @RequestMapping("/findByName/{nome}/findByEmail/{email}")
    public List<Cliente> findByNameEmail(@PathVariable(value="nome") String nome, @PathVariable(value="email") String email) {
        return cl.findByNameEmail(nome,email);
    }

    @DeleteMapping("/delete")
    public void deleteCliente(@RequestBody Cliente cliente) {
        cl.delete(cliente);
    }

    @DeleteMapping("/deleteByCod/{cod}")
    public void deleteByCod(@PathVariable(value="cod") int cod) {
        cl.deleteById(cod);
    }

    @PutMapping("/update")
    public void updateCliente(@RequestBody Cliente cliente) {
        cl.save(cliente);
    }
}
