package action;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import jpa.PessoaRepositorio;
import jpa.PessoaRepositorioImpl;
import model.Pessoa;

@ManagedBean(name = "mbPessoa")
@ViewScoped
public class PessoaController implements Serializable{
	
/*	Session session = HibernateUtil.getSession();
	DaoFactory fac = new DaoFactory(session);
	
	Dao<Pessoa> dao = fac.getPessoaDao();*/
	
	@EJB
	private PessoaRepositorio rep;
	

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

		try{
//			rep.beginTransaction();
			
			rep.save(pessoa);
			
//			fac.commit();
			
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Item cadastrado", "Item cadastrado no banco!"));
		
		}catch(Exception e){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Deu erro", "Deu erro em tudo!"));
		}
		
		
		pessoa = new Pessoa();

	}
	
	public List<Pessoa> getPessoas() {

		
		return rep.findAll();
	}

}
