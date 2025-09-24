package despesas.com.despesas.infraestrutura.controller;
import despesas.com.despesas.infraestrutura.model.Despesas;
import despesas.com.despesas.infraestrutura.services.ServiceDespesas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/despesas")
public class DespesasController {
    @Autowired
    private ServiceDespesas serviceDespesas;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionar(@RequestBody Despesas despesas){
        try{
            serviceDespesas.adicionar(despesas);
            return new ResponseEntity<>("Despesa adicionada com sucesso", HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao adicionar despesa" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Despesas>> listar(){
       List<Despesas> despesas = serviceDespesas.listar();
       return new ResponseEntity<>(despesas, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if (id == null){
            return new ResponseEntity<>("O id não pode ser nulo", HttpStatus.BAD_REQUEST);
        }
        try{
            serviceDespesas.delete(id);
            return new ResponseEntity<>("Despesa deletada com sucesso", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao deletar despesa" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Despesas novaDespesas){
        if (id == null){
            return new ResponseEntity<>("O id não pode ser nulo", HttpStatus.BAD_REQUEST);
        }
        try{
            serviceDespesas.update(id, novaDespesas);
            return new ResponseEntity<>("Despesa atualizada com sucesso", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao atualizar despesa" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
