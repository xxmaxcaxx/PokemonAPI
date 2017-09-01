package com.example.logonrm.pokemonapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText etNumeroPokemon;
    private ImageView ivFotoPokemon;
    private TextView tvNomePokemon;
    private TextView tvTipoPokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumeroPokemon = (EditText) findViewById(R.id.etNumeroPokemon);
        ivFotoPokemon = (ImageView) findViewById(R.id.ivFotoPokemon);
        tvNomePokemon = (TextView) findViewById(R.id.tvNomePokemon);
        tvTipoPokemon = (TextView) findViewById(R.id.tvTipoPokemon);
    }

    public void pesquisar (View v){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        service.buscarPokemon(etNumeroPokemon.getText().toString())
                .enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                       Picasso.with(MainActivity.this).load(response.body().getFoto()).into(ivFotoPokemon);
                        tvNomePokemon.setText(response.body().getNome());
                        tvTipoPokemon.setText(response.body().getTipo());
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Toast.makeText(MainActivity.this,
                                "Ocorreu um erro na requisicao",
                                Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
