package com.sinerji.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.sinerji.entities.Pessoa;
import com.sinerji.repository.PessoaRepository;
import com.sinerji.util.Transacional;

public class CadastroPessoaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaRepository pessoaRepository;
	
	@Inject
    public void setPessoaRepository(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }
	
	@Transacional
	public void salvar(Pessoa pessoa) {
		pessoaRepository.salvar(pessoa);
	}
	
	@Transacional
	public void excluir(Pessoa pessoa) {
		pessoaRepository.remover(pessoa);
	}
}
