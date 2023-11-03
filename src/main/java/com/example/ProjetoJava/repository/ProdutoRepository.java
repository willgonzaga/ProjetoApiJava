package com.example.ProjetoJava.repository;

import com.example.ProjetoJava.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    @Query(value="select * from produtos where descricao like ?1%", nativeQuery = true)
    public List<Produto> findByDesc(String desc);

    @Query(value="select * from produtos where preco < ?1", nativeQuery = true)
    public List<Produto> findByPrecoMenor(double preco);

    @Query(value="select * from produtos where marca = ?1", nativeQuery = true)
    public List<Produto> findByMarca(String marca);

    @Query(value="select * from produtos where preco < ?2 and marca like %?1%", nativeQuery = true)
    public List<Produto> findByMarcaPrecoMenor(String marca, double preco);
}
