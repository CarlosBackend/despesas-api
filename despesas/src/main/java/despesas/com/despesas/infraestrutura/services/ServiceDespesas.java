package despesas.com.despesas.infraestrutura.services;

import despesas.com.despesas.infraestrutura.model.Despesas;
import despesas.com.despesas.infraestrutura.repository.RepositoryDespesas;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Despesas> listar(){
        List<Despesas> despesas = repositoryDespesas.findAll();
        if(despesas.isEmpty()){
            return List.of();
        }
        return despesas;
    }
}
