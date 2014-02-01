package controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import jpa.PessoaRepositorio;
import lombok.Getter;
import lombok.Setter;

import model.Pessoa;

@ManagedBean(name = "mbPessoa")
@ViewScoped
public class PessoaController implements Serializable {

    @EJB
    private PessoaRepositorio rep;
    
    @Getter
    @Setter
    private Pessoa pessoa;

    @Getter
    @Setter
    private boolean showList;

    @Getter
    @Setter
    private boolean showForm;

    @PostConstruct
    public void inicializarVariaveis() {
        pessoa = new Pessoa();
        showList = true;
        showForm = false;
    }

    public PessoaController() {

    }

    
    public void changeToForm(){
        showList = false;
        showForm = true;
    }
    
    public void changeToList(){
        showList = true;
        showForm = false;
    }

    public void salvar() {
        
        try {

            rep.save(pessoa);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Item cadastrado", "Item cadastrado no banco!"));

            pessoa = new Pessoa();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deu erro", "Deu erro em tudo!"));
        }


    }

    public List<Pessoa> getPessoas() {

        return rep.findAll();
    }

}
