package br.senac.joaovsstrindade.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.senac.joaovsstrindade.agenda.model.ContatoEntity;

public class ContatoDAO {

    private SQlitehelper sqLiteHelper;

    private SQLiteDatabase sqLiteDatabase;

    public ContatoDAO(Context context) {
        this.sqLiteHelper = new SQlitehelper(context);
    }

    public void salvar(ContatoEntity contato) {
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("NOME", contato.getNome());
        values.put("TELEFONE", contato.getTelefone());
        values.put("PONTUACAO", contato.getPontuacao());

        sqLiteDatabase.insert("CONTATO", null, values);

        sqLiteDatabase.close();
    }

    public List<ContatoEntity> listar() {
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();

        String sql = "SELECT * FROM CONTATO;";

        Cursor c = sqLiteDatabase.rawQuery(sql, null);

        List<ContatoEntity> contatos  =new ArrayList<>();

        while (c.moveToNext()) {
            ContatoEntity contato = new ContatoEntity();
            contato.setId(c.getInt(c.getColumnIndex("ID")));
            contato.setNome(c.getString(c.getColumnIndex("NOME")));
            contato.setTelefone(c.getString(c.getColumnIndex("TELEFONE")));
            contato.setPontuacao(c.getDouble(c.getColumnIndex("PONTUACAO")));

            contatos.add(contato);
        }

        return contatos;
    }



}
