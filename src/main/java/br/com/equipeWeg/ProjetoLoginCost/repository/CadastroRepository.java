package br.com.equipeWeg.ProjetoLoginCost.repository;

import br.com.equipeWeg.ProjetoLoginCost.model.CadastroUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadastroRepository extends JpaRepository<CadastroUsuario, Long> {
}
