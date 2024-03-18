package com.sinerji.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sinerji.entities.Endereco;
import com.sinerji.repository.EnderecoRepository;
import com.sinerji.util.Transacional;

public class CadastroEnderecoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EnderecoRepository enderecoRepository;
	
	@Inject
    public void setEnderecoRepository(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }
	
	@Transacional
	public void salvar(Endereco endereco) {
		enderecoRepository.salvar(endereco);
	}
	
	@Transacional
	public void excluir(Endereco endereco) {
		enderecoRepository.remover(endereco);
	}
}
