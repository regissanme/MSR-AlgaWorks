package br.com.regissanme.log.api.controller;

import br.com.regissanme.log.domain.model.Cliente;
import br.com.regissanme.log.domain.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 18/07/2022
 * Hora: 15:42
 */
@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping()
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> findById(@PathVariable Long clienteId) {
        Cliente cliente = clienteService.buscarPorId(clienteId);
        if(cliente == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/nome={nomeCliente}")
    public ResponseEntity<List<Cliente>> findByNome(@PathVariable String nomeCliente) {
        List<Cliente> clientes = clienteService.buscarPorNome(nomeCliente);
        if (clientes.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@Valid @RequestBody Cliente cliente) {
        return ResponseEntity.created(null).body(clienteService.salvar(cliente));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        if (clienteService.existePeloId(id)) {
            return ResponseEntity.ok(clienteService.salvar(cliente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (clienteService.existePeloId(id)) {
            clienteService.excluir(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
