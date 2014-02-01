/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import jpa.PessoaRepositorio;
import model.Pessoa;

/**
 *
 * @author Carlos
 */
public class PessoaAction{

    PessoaRepositorio rep;

    public PessoaAction(PessoaRepositorio rep) {
        this.rep = rep;
    }

    public boolean salvar(Pessoa pessoa) {
        try {

            rep.save(pessoa);

            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
