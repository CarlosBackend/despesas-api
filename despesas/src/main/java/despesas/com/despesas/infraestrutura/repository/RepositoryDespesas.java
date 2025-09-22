package despesas.com.despesas.infraestrutura.repository;

import despesas.com.despesas.infraestrutura.model.Despesas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryDespesas extends JpaRepository<Despesas, Long> {
}
