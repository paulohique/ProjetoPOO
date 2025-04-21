package Estoque.Estoque.repository;

import Estoque.Estoque.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // Buscar um produto pelo nome
    Optional<Produto> findByNome(String nome);

    // Verifica se um produto existe pelo nome
    boolean existsByNome(String nome);
}
