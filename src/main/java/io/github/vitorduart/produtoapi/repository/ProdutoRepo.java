package io.github.vitorduart.produtoapi.repository;

import io.github.vitorduart.produtoapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepo extends JpaRepository<Produto, String> {

    List<Produto> findByNome(String nome);
}
