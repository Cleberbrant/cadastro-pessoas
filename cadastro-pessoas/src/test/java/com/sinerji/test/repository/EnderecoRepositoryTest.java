package com.sinerji.test.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;

import com.sinerji.entities.Endereco;
import com.sinerji.repository.EnderecoRepository;

public class EnderecoRepositoryTest {

	private EntityManager entityManager;
	private EnderecoRepository enderecoRepository;

	@Before
	public void setUp() {
		entityManager = mock(EntityManager.class);
		enderecoRepository = new EnderecoRepository(entityManager);
	}

	@Test
	public void testBuscarPorId() {
		Endereco endereco = new Endereco();
		endereco.setId(1L);
		endereco.setEstado("São Paulo");

		// Configurando o comportamento do EntityManager quando find for chamado
		when(entityManager.find(Endereco.class, 1L)).thenReturn(endereco);

		// Chamando o método buscarPorId do repositório
		Endereco result = enderecoRepository.buscarPorId(1L);

		assertEquals(endereco, result);
	}

	@Test
	public void testSalvar() {
		Endereco endereco = new Endereco();
		endereco.setId(1L);
		endereco.setEstado("São Paulo");

		// Configurando o comportamento do EntityManager quando merge for chamado
		when(entityManager.merge(endereco)).thenReturn(endereco);

		// Chamando o método salvar do repositório
		Endereco result = enderecoRepository.salvar(endereco);

		assertEquals(endereco, result);
	}

	@Test
	public void testRemover() {
		Endereco endereco = new Endereco();
		endereco.setId(1L);
		endereco.setEstado("São Paulo");

		// Configurando o comportamento do EntityManager quando find e remove for
		// chamado
		when(entityManager.find(Endereco.class, 1L)).thenReturn(endereco);

		// Chamando o método remover do repositório
		enderecoRepository.remover(endereco);

		// Verificando se o método remove foi chamado no EntityManager
		verify(entityManager).remove(endereco);
	}

}