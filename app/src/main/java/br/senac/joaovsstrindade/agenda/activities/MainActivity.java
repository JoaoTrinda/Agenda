package br.senac.joaovsstrindade.agenda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import br.senac.joaovsstrindade.agenda.R;
import br.senac.joaovsstrindade.agenda.dao.ContatoDAO;
import br.senac.joaovsstrindade.agenda.model.ContatoEntity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = findViewById(R.id.listaContatosListeView);

        ContatoDAO contatoDAO = new ContatoDAO( this);
        List<ContatoEntity> contatos = contatoDAO.listar();

        ArrayAdapter<ContatoEntity> adapter = new ArrayAdapter<ContatoEntity>( this, android.R.layout.simple_list_item_1, contatos);

        lista.setAdapter(adapter);

        Button novoContato = findViewById(R.id.novoContatoButton);

        novoContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent contato = new Intent (MainActivity.this, ContatoActivity.class);
                startActivity(contato);
                finish();
            }
        });
    }
}

