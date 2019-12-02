/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.Controller;

import com.example.demo.modelo.Servico.Servico;
import com.example.demo.modelo.entidades.Entidade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class CRUD<T extends Entidade> {

    public abstract Servico<T> getService();

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public T cadastrar(@RequestBody T entidade) throws Throwable {
        return getService().cadastrar(entidade);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<T> listar() {
        return getService().listar();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable int id, @RequestBody T entidade) throws Throwable {
        entidade.setId(id);
        getService().atualizar(entidade);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable int id) throws Throwable {
        getService().excluir(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public T recuperar(@PathVariable int id) throws Throwable {
        return getService().recuperar(id);
    }
}
