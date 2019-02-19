package br.senac.joaovsstrindade.agenda.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import br.senac.joaovsstrindade.agenda.R;
import br.senac.joaovsstrindade.agenda.dao.ContatoDAO;
import br.senac.joaovsstrindade.agenda.model.ContatoEntity;
import br.senac.joaovsstrindade.agenda.model.EnderecoEntity;

public class ContatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        // Ação de click no salvar
        Button salavarcontatoButton = findViewById(R.id.SalvarContatoButton);
        salavarcontatoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nomeEditTest = findViewById(R.id.NomeEditText);
                EditText telefoneeditText = findViewById(R.id.TelefoneEditText);
                EditText ruaEditTest = findViewById(R.id.RuaEditText);
                EditText numeroEditTest = findViewById(R.id.NumeroEditText);
                EditText cidadeEditTest = findViewById(R.id.CidadeEditText);

                EditText emailEditText = findViewById(R.id.EmailEditText);
                RatingBar pontuacaoRantingBar = findViewById(R.id.pontuacaoratingBar);


                ContatoEntity contato = new ContatoEntity(nomeEditTest.getText().toString(),
                        emailEditText.getText().toString(),
                        telefoneeditText.getText().toString(),
                        Double.valueOf(pontuacaoRantingBar.getProgress()))
                        ;
                ContatoDAO contatoDAO = new ContatoDAO( ContatoActivity.this);

                contatoDAO.salvar(contato);

                EnderecoEntity endereco = new EnderecoEntity(ruaEditTest.getText().toString(),numeroEditTest.getText().toString(),cidadeEditTest.getText().toString());


                Toast.makeText(ContatoActivity.this,"Contato Salvo!"   ,  Toast.LENGTH_SHORT).show();
                Intent main = new Intent(ContatoActivity.this, MainActivity.class);
                startActivity(main);

                finish();
            }
        });
    }
}
