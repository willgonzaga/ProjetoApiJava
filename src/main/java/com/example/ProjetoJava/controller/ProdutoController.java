package com.example.ProjetoJava.controller;

import com.example.ProjetoJava.model.Produto;
import com.example.ProjetoJava.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/apiProduto")
public class ProdutoController {
    @Autowired
    ProdutoRepository pr;

    @RequestMapping("/findAll")
    public List<Produto> findAll() {
        return pr.findAll();
    }

    @RequestMapping("/findByCod/{cod}")
    public Optional<Produto> findByCod(@PathVariable(value="cod") int cod) {
        return pr.findById(cod);
    }

    @RequestMapping("/findByDesc/{desc}")
    public List<Produto> findByDesc(@PathVariable(value="desc") String desc) {
        return pr.findByDesc(desc);
    }

    @RequestMapping("/findByPrecoMenor/{preco}")
    public List<Produto> findByPrecoMenor(@PathVariable(value="preco") double preco) {
        return pr.findByPrecoMenor(preco);
    }

    @RequestMapping("/findByMarca/{marca}")
    public List<Produto> findByMarca(@PathVariable(value="marca") String marca) {
        return pr.findByMarca(marca);
    }

    @RequestMapping("/findByMarca/{marca}/findByPrecoMenor/{preco}")
    public List<Produto> findByMarcaPrecoMenor(@PathVariable(value="marca") String marca, @PathVariable(value="preco") double preco) {
        return pr.findByMarcaPrecoMenor(marca,preco);
    }

    @DeleteMapping("/delete")
    public void deleteProduto(@RequestBody Produto produto) {
        pr.delete(produto);
    }

    @DeleteMapping("/deleteByCod/{cod}")
    public void deleteByCod(@PathVariable(value="cod") int cod) {
        pr.deleteById(cod);
    }

    @PutMapping("/update")
    public void updateProduto(@RequestBody Produto produto) {
        pr.save(produto);
    }
}
