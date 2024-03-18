package com.sinerji.test.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sinerji.entities.Pessoa;
import com.sinerji.repository.PessoaRepository;

@RunWith(MockitoJUnitRunner.class)
public class PessoaRepositoryTest {

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private PessoaRepository pessoaRepository;

    @Before
    public void setUp() {

    }

    @Test
    public void testBuscarPorId() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("João");

        // Configurando o comportamento do EntityManager quando find for chamado
        when(entityManager.find(Pessoa.class, 1L)).thenReturn(pessoa);

        // Chamando o método buscarPorId do repositório
        Pessoa result = pessoaRepository.buscarPorId(1L);

        // Verificando se o resultado retornado é o mesmo que esperamos
        assertEquals(pessoa, result);
    }

    @Test
    public void testPesquisarPorNome() {
        List<Pessoa> pessoas = new ArrayList<>();
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setId(1L);
        pessoa1.setNome("Maria");
        pessoas.add(pessoa1);

        // Configurando o comportamento do TypedQuery quando getResultList for chamado
        TypedQuery<Pessoa> query = mock(TypedQuery.class);
        when(entityManager.createQuery(anyString(), eq(Pessoa.class))).thenReturn(query);
        when(query.setParameter(anyString(), any())).thenReturn(query);
        when(query.getResultList()).thenReturn(pessoas);

        // Chamando o método pesquisarPorNome do repositório
        List<Pessoa> result = pessoaRepository.pesquisarPorNome("Maria");

        assertEquals(pessoas, result);
    }
    
    @Test
    public void testSalvar() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("João");

        // Configurando o comportamento do EntityManager quando merge for chamado
        when(entityManager.merge(pessoa)).thenReturn(pessoa);

        // Chamando o método salvar do repositório
        Pessoa result = pessoaRepository.salvar(pessoa);

        assertEquals(pessoa, result);
    }

    @Test
    public void testRemover() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("João");

        // Configurando o comportamento do EntityManager quando find e remove for chamado
        when(entityManager.find(Pessoa.class, 1L)).thenReturn(pessoa);

        // Chamando o método remover do repositório
        pessoaRepository.remover(pessoa);

        // Verificando se o método remove foi chamado no EntityManager
        verify(entityManager).remove(pessoa);
    }
}
