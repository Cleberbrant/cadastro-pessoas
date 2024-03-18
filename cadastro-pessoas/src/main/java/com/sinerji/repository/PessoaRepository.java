package com.sinerji.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.sinerji.entities.Pessoa;

public class PessoaRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public PessoaRepository() {
		
	}
	
	public PessoaRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public Pessoa buscarPorId(Long id) {
		return manager.find(Pessoa.class, id);
	}
	
	public List<Pessoa> pesquisarPorNome(String nomePesquisa){
		String jpql = "from Pessoa where LOWER(nome) like LOWER(:nome)";
		TypedQuery<Pessoa> query = manager.createQuery(jpql, Pessoa.class);
		query.setParameter("nome", nomePesquisa + "%");
		return query.getResultList();
	}
	
	public List<Pessoa> pesquisarTodasPessoas(){
		return manager.createQuery("from Pessoa", Pessoa.class).getResultList();
	}
	
	public Pessoa salvar(Pessoa pessoa) {
		return manager.merge(pessoa);
	}
	
	public void remover(Pessoa pessoa) {
		pessoa = buscarPorId(pessoa.getId());
		manager.remove(pessoa);
	}
}
