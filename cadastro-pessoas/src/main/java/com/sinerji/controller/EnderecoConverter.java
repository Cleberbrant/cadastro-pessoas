package com.sinerji.controller;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import com.sinerji.entities.Endereco;

public class EnderecoConverter implements Converter {
	
	private List<Endereco> listaEnderecos;
	
	public EnderecoConverter(List<Endereco> listaEnderecos) {
		this.listaEnderecos = listaEnderecos;
	}

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if(value == null) {
			return null;
		}
		
		Long id = Long.valueOf(value);
		
		for(Endereco endereco: listaEnderecos) {
			if(id.equals(endereco.getId())) {
				return endereco;
			}
		}
		
		return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value == null) {
			return null;
		}
		
		Endereco endereco = (Endereco) value;
		
		return endereco.getId().toString();
	}

}
