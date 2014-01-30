package jpa;

import java.util.List;
import javax.ejb.Stateless;

import model.Pessoa;

@Stateless
public class PessoaRepositorioImpl extends RepositorioImpl<Pessoa, Long> implements PessoaRepositorio{


        @Override
	public List<Pessoa> consultaEspecifica() {
		// TODO Auto-generated method stub
		return null;
	}

}
