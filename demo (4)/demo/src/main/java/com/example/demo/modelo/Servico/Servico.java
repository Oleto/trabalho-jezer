/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.Servico;

import com.example.demo.excecoes.NaoEncontrado;
import com.example.demo.modelo.RN.RegraNegocio;
import com.example.demo.modelo.entidades.Entidade;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public abstract class Servico<T extends Entidade> {

    public abstract CrudRepository<T, Integer> getDAO();
    public abstract RegraNegocio<T> getRegraNegocio();

    public T cadastrar(T entidade) throws Throwable {
        entidade.setId(0);
        if(getRegraNegocio()!=null)
            getRegraNegocio().validarCadastrar(entidade);
        T save = getDAO().save(entidade);
        return save;
    }

    public Iterable<T> listar() {
        return getDAO().findAll();
    }

    public void atualizar(T entidade)  throws Throwable {
        if(getRegraNegocio()!=null) {
            T entidadeAntiga = getDAO().findById(entidade.getId()).get();
            getRegraNegocio().validarAtualizar(entidadeAntiga, entidade);
        }
        getDAO().save(entidade);
    }

    public T recuperar(int id) throws Throwable {
        Optional<T> optional = getDAO().findById(id);
        if (!optional.isPresent()) {
            throw new NaoEncontrado("id " + id + " não foi encontrada");
        }
        return optional.get();
    }

    public void excluir(int id) throws Throwable {
        if (!getDAO().existsById(id)) {
            throw new NaoEncontrado("id " + id + " não foi encontrada");
        }
        if(getRegraNegocio()!=null)
            getRegraNegocio().validarExcluir(recuperar(id));
        getDAO().deleteById(id);
    }

}