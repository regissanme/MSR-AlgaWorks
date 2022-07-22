package br.com.regissanme.log;

import br.com.regissanme.log.domain.model.Cliente;
import br.com.regissanme.log.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Projeto: regissanme-log
 * Desenvolvedor: Reginaldo Santos de Medeiros (regissanme)
 * Data: 21/07/2022
 * Hora: 16:07
 */
@Component
public class StartDevApplication implements CommandLineRunner {
    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {

        System.out.println("Start Application running ... ");

        Cliente cliente1 = new Cliente(1L, "João", "joao@joao.com.br", "62 1234-5555");
        Cliente cliente2 = new Cliente(2L, "Maria", "maria@maria.com.br", "62 2222-6666");

        System.out.println("Saving mock data in H2 database...");
        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);


    }
}
