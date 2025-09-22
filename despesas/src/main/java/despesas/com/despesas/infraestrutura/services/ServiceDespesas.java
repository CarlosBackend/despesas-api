package despesas.com.despesas.infraestrutura.services;

import despesas.com.despesas.infraestrutura.model.Despesas;
import despesas.com.despesas.infraestrutura.repository.RepositoryDespesas;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDespesas {
    @Autowired
    private RepositoryDespesas repositoryDespesas;

    public void adicionar(Despesas despesas){
        if (despesas == null){
            throw new IllegalArgumentException("O objeto não pode ser nulo");
        }
        repositoryDespesas.save(despesas);
    }
}
