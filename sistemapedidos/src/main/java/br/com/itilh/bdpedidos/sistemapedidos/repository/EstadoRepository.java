package br.com.itilh.bdpedidos.sistemapedidos.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.itilh.bdpedidos.sistemapedidos.model.Estado;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, BigInteger> {

    List<Estado> findByNome(String nome);
    
    List<Estado> findByNomeStartingWithIgnoreCase(String nome);

    List<Estado> findByNomeEndingWithIgnoreCase(String nome);

    List<Estado> findByNomeContainingIgnoreCase(String nome);

    @Query("FROM Estado e WHERE e.nome like %?1")
    List<Estado> findByMinhaQuery(String nome);

    @Query(value = "Select * from tb_estados", nativeQuery = true)
    List<Estado> findByNativeQuery();
}
