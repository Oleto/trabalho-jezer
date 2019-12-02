/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.dao;

import com.example.demo.modelo.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author CHICO & ICA
 */
public interface UsuarioDAO extends CrudRepository<Usuario, Integer> {

    public Usuario findByLogin(String login);

}
