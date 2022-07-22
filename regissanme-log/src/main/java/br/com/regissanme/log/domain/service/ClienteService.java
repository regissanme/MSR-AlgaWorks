package br.com.regissanme.log.domain.service;

import br.com.regissanme.log.domain.exceptions.NegocioException;
import br.com.regissanme.log.domain.model.Cliente;
import br.com.regissanme.log.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 22/07/2022
 * Hora: 11:04
 */
@Service
@AllArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if (emailEmUso) {
            throw new NegocioException("Já existe um cliente cadastrado com esse email!");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long clienteId) {
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("O cliente informado não existe!"));
    }

    public List<Cliente> buscarPorNome(String nome) {
        return clienteRepository.findByNomeContaining(nome);
    }

    public boolean existePeloId(Long id) {
        return clienteRepository.existsById(id);
    }
}
