/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.modelo.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Usuario implements Entidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String login;
    // Senha não deve nunca ficar disponível para a api cliente
    @JsonIgnore
    private String senha;
    // Campo necessário para cadastrar senha inicial ou atualiza-lá
    @Transient
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String novaSenha;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> permissoes;
    @OneToMany
    private List<Vaga> vagascandidatadas;

    public List<Vaga> getVagascandidatadas() {
        return vagascandidatadas;
    }

    public void setVagascandidatadas(List<Vaga> vagascandidatadas) {
        this.vagascandidatadas = vagascandidatadas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNovaSenha() {
        return novaSenha;
    }

    public void setNovaSenha(String novaSenha) {
        this.novaSenha = novaSenha;
    }

    public List<String> getPermissoes() {
        return permissoes;
    }

    public void setPermissoes(List<String> permissoes) {
        this.permissoes = permissoes;
    }

}
