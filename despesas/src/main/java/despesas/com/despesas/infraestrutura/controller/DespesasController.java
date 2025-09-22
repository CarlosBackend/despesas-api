package despesas.com.despesas.infraestrutura.controller;

import despesas.com.despesas.infraestrutura.model.Despesas;
import despesas.com.despesas.infraestrutura.services.ServiceDespesas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/despesas")
public class DespesasController {
    @Autowired
    private ServiceDespesas serviceDespesas;

    @RequestMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestBody Despesas despesas){
        try{
            serviceDespesas.adicionar(despesas);
            return new ResponseEntity<>("Despesa adicionada com sucesso", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao adicionar despesa", HttpStatus.BAD_REQUEST);
        }
    }
}
