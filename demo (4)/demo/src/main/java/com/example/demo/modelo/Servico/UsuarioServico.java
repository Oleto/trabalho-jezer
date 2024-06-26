/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.Servico;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.Auth.AuthUser;
import com.example.demo.ConfiguracaoSeguranca;
import com.example.demo.excecoes.NaoEncontrado;
import com.example.demo.excecoes.Proibido;
import com.example.demo.modelo.RN.RegraNegocio;
import com.example.demo.modelo.dao.UsuarioDAO;
import com.example.demo.modelo.entidades.Usuario;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
@Component
public class UsuarioServico extends Servico<Usuario> {

    @Autowired
    UsuarioDAO usuarioDAO;

    @Override
    public RegraNegocio<Usuario> getRegraNegocio() {
        return null;
    }

    @Override
    public UsuarioDAO getDAO() {
        return usuarioDAO;
    }

    @Override
    public Usuario cadastrar(Usuario entidade) {
        return cadastrar(null, entidade);
    }

    public Usuario cadastrar(AuthUser usuarioAut, Usuario entidade) {
        entidade.setId(0);
        entidade.setSenha(ConfiguracaoSeguranca.PASSWORD_ENCODER.encode(entidade.getNovaSenha()));
        if (usuarioAut == null || !usuarioAut.getUsuario().getPermissoes().contains("administrador")) {
            ArrayList<String> permissao = new ArrayList<String>();
            permissao.add("usuario");
            entidade.setPermissoes(permissao);
        }
        return usuarioDAO.save(entidade);
    }

    public String token(Usuario usuario) throws UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256(ConfiguracaoSeguranca.SEGREDO);
        Calendar agora = Calendar.getInstance();
        agora.add(Calendar.MINUTE, 4);
        Date expira = agora.getTime();
        String token = JWT.create()
                .withClaim("id", usuario.getId()).
                withExpiresAt(expira).
                sign(algorithm);
        return token;
    }

    public Usuario login(String login, String senha) {
        Usuario usuarioBanco = usuarioDAO.findByLogin(login);
        if (usuarioBanco != null) {
            boolean senhasIguais = ConfiguracaoSeguranca.PASSWORD_ENCODER.matches(senha, usuarioBanco.getSenha());
            if (senhasIguais) {
                return usuarioBanco;
            }
        }
        throw new NaoEncontrado("Usuário e/ou senha incorreto(s)");
    }

    public Usuario recuperar(AuthUser usuarioAut, int id) {
        if (usuarioAut.getUsuario().getId() == id
                || usuarioAut.getUsuario().getPermissoes().contains("administrador")) {
            return usuarioDAO.findById(id).get();
        } else {
            throw new Proibido("Não é permitido acessar dados de outro usuário");
        }
    }

    @Override
    public Usuario recuperar(int id) {
        throw new Proibido("Não é permitido recuperar usuário sem identificação");
    }

}
