package com.sinerji.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sinerji.entities.Endereco;

public class EnderecoRepository implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public EnderecoRepository(){
		
	}
	
	public EnderecoRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public Endereco buscarPorId(Long id) {
		return manager.find(Endereco.class, id);
	}
	
	public Endereco salvar(Endereco endereco) {
		return manager.merge(endereco);
	}
	
	public void remover(Endereco endereco) {
		endereco = buscarPorId(endereco.getId());
		manager.remove(endereco);
	}

}
