package jpa;

import java.util.List;
import javax.ejb.Local;

import model.Pessoa;

@Local
public interface PessoaRepositorio extends Repositorio<Pessoa, Long>{
	
	public List<Pessoa> consultaEspecifica();

}
