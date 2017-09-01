package com.example.logonrm.pokemonapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by logonrm on 01/09/2017.
 */

public interface GitHubService {
    @GET("/pokemon/{numeropokemon}")
    Call<Usuario> buscarPokemon(
            @Path(value = "numeropokemon")String pokemon);
}
