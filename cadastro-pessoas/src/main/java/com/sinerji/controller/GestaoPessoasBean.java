package com.sinerji.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.sinerji.entities.Endereco;
import com.sinerji.entities.Pessoa;
import com.sinerji.entities.TipoSexo;
import com.sinerji.repository.PessoaRepository;
import com.sinerji.service.CadastroPessoaService;
import com.sinerji.util.FacesMessages;


@Named
@ViewScoped
public class GestaoPessoasBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private PessoaRepository pessoaRepository;
	
	@Inject
	private CadastroPessoaService cadastroPessoaService;
	
	@Inject
	private FacesMessages messages;
	
	private List<Pessoa> listaPessoas;
	
	private String nomePesquisa;
	
	private Pessoa pessoa;
	private Endereco endereco;
	
	public void prepararNovoCadastro() {
		pessoa = new Pessoa();
		endereco = new Endereco();
	}
	
	public void prepararEdicao() {
		pessoa.getId();
		endereco.getId();
	}
	
	public void salvar() {
		pessoa.setEndereco(endereco);
		cadastroPessoaService.salvar(pessoa);
		
		todasPessoas();
		
		messages.info("Pessoa salva com sucesso!");
	}
	
	public void excluir() {
		cadastroPessoaService.excluir(pessoa);
		
		todasPessoas();
		
		messages.info("Pessoa removida com sucesso!");
	}
	
	public void pesquisar() {
		listaPessoas = pessoaRepository.pesquisarPorNome(nomePesquisa);
		
		if(listaPessoas.isEmpty()) {
			messages.info("Sua consulta não retornou registros.");
		}
	}
	
	public boolean isPessoaSelecionada() {
		return pessoa != null && pessoa.getId() != null;
	}
	
	public void todasPessoas() {
		listaPessoas = pessoaRepository.pesquisarTodasPessoas();
	}
	
	public List<Pessoa> getListaPessoas() {
		return listaPessoas;
	}
	
	public String getNomePesquisa() {
		return nomePesquisa;
	}
	
	public void setNomePesquisa(String nomePesquisa) {
		this.nomePesquisa = nomePesquisa;
	}
	
	public TipoSexo[] getTiposSexo() {
		return TipoSexo.values();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
