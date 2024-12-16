package io.github.vitorduart.produtoapi.controller;

import io.github.vitorduart.produtoapi.model.Produto;
import io.github.vitorduart.produtoapi.repository.ProdutoRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    private final ProdutoRepo repo;

    public ProdutoController(ProdutoRepo repo){
        this.repo = repo;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        repo.save(produto);

        return produto;
    }

    @GetMapping("{id}")
    public Produto obterPorId (@PathVariable("id") String id){
        return repo
                .findById(id)
                .orElse(null);

    }

    @PutMapping("{id}")
    public Produto atualizar(@PathVariable("id") String id, @RequestBody Produto nu){
        nu.setId(id);
        repo.save(nu);
        return nu;
    }

    @DeleteMapping("{id}")
    public void excluir (@PathVariable("id") String id){
        repo.deleteById(id);
    }

    @GetMapping
    public List<Produto> buscar (@RequestParam("nome") String nome){
        return repo.findByNome(nome);
    }
}
