/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Auth;

import com.example.demo.modelo.entidades.Usuario;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class AuthUser extends User {
    private Usuario usuario;
    public AuthUser(Usuario usuario) {
        super(usuario.getLogin(),
                usuario.getSenha(),
                AuthorityUtils.createAuthorityList(
                    usuario.getPermissoes().toArray(new String[]{})));
        this.usuario=usuario;
    }
    public Usuario getUsuario() {
        return usuario;
    }
}
