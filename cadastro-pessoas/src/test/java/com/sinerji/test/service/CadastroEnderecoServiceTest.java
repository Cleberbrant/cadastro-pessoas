package com.sinerji.test.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.sinerji.entities.Endereco;
import com.sinerji.repository.EnderecoRepository;
import com.sinerji.service.CadastroEnderecoService;

public class CadastroEnderecoServiceTest {

    private CadastroEnderecoService cadastroEnderecoService;
    private EnderecoRepository enderecoRepository;

    @Before
    public void setUp() {
        enderecoRepository = mock(EnderecoRepository.class);
        cadastroEnderecoService = new CadastroEnderecoService();
        cadastroEnderecoService.setEnderecoRepository(enderecoRepository);
    }

    @Test
    public void testSalvar() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setEstado("São Paulo");

        // Chamando o método salvar do serviço
        cadastroEnderecoService.salvar(endereco);

        // Verificando se o método salvar foi chamado no repositório
        verify(enderecoRepository).salvar(endereco);
    }

    @Test
    public void testExcluir() {
        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setEstado("Rio de Janeiro");

        // Chamando o método excluir do serviço
        cadastroEnderecoService.excluir(endereco);

        // Verificando se o método remover foi chamado no repositório
        verify(enderecoRepository).remover(endereco);
    }
}