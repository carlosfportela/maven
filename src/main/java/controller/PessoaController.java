package controller;

import action.PessoaAction;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import jpa.PessoaRepositorio;

import model.Pessoa;

@ManagedBean(name = "mbPessoa")
@ViewScoped
public class PessoaController implements Serializable{
	
	
	@EJB
	private PessoaRepositorio rep;
	
        private PessoaAction action = new PessoaAction(rep);
	private Pessoa pessoa;
        
	
	@PostConstruct
	public void inicializarVariaveis(){
		pessoa = new Pessoa();
	}

	public PessoaController() {

	}


	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
    public void salvar() {
        if (action.salvar(pessoa)) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Item cadastrado", "Item cadastrado no banco!"));

            pessoa = new Pessoa();
        
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
		new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deu erro", "Deu erro em tudo!"));
        }

    }
	
	public List<Pessoa> getPessoas() {

		return rep.findAll();
	}

}
