package com.sinerji.test.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.sinerji.entities.Pessoa;
import com.sinerji.repository.PessoaRepository;
import com.sinerji.service.CadastroPessoaService;

public class CadastroPessoaServiceTest {

    private CadastroPessoaService cadastroPessoaService;
    private PessoaRepository pessoaRepository;

    @Before
    public void setUp() {
        pessoaRepository = mock(PessoaRepository.class);
        cadastroPessoaService = new CadastroPessoaService();
        cadastroPessoaService.setPessoaRepository(pessoaRepository);
    }

    @Test
    public void testSalvar() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Maria");

        // Chamando o método salvar do serviço
        cadastroPessoaService.salvar(pessoa);

        // Verificando se o método salvar foi chamado no repositório
        verify(pessoaRepository).salvar(pessoa);
    }

    @Test
    public void testExcluir() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("João");

        // Chamando o método excluir do serviço
        cadastroPessoaService.excluir(pessoa);

        // Verificando se o método remover foi chamado no repositório
        verify(pessoaRepository).remover(pessoa);
    }
}