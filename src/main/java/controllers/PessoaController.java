package controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Pessoa;

@Stateless
public class PessoaController {
	
	@PersistenceContext(unitName = "nomedasource-ds")
	private EntityManager em;
	
	public void salvaPessoa(Pessoa pessoa){
		this.em.persist(pessoa);
	}

}
