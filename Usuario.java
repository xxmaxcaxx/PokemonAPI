package com.example.logonrm.pokemonapi;

import com.google.gson.annotations.SerializedName;

/**
 * Created by logonrm on 01/09/2017.
 */

public class Usuario {
    @SerializedName(value = "pokemon")
    private String nome;
    @SerializedName(value = "avatar_url")
    private String foto;
    @SerializedName(value = "type")
    private String tipo;

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getFoto(){
        return foto;
    }

    public void setFoto(String foto){
        this.foto = foto;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
