package br.senac.joaovsstrindade.agenda.dao;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.senac.joaovsstrindade.agenda.model.EnderecoEntity;

public class EnderecoDAO{
    private SQlitehelper sqLiteHelper;

    private SQLiteDatabase sqLiteDatabase;

    public EnderecoDAO(Context context) {
        this.sqLiteHelper = new SQlitehelper(context);
    }

    public void salvar(EnderecoEntity endereco) {
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();

        sqLiteDatabase.insert("ENDERECO", null, values);

        sqLiteDatabase.close();

    }
    public List<EnderecoEntity> listar() {
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();

        String sql = "SELECT * FROM ENDERECO;";

        Cursor c = sqLiteDatabase.rawQuery(sql, null);

        List<EnderecoEntity> endereco  =new ArrayList<>();

        while (c.moveToNext()) {
            EnderecoEntity endereco = new EnderecoEntity();
            EnderecoEntity.setId(c.getInt(((Cursor) c).getColumnIndex("ID")));
            Endereco.setNome(c.getString(c.getColumnIndex("NOME")));
            Endereco.setTelefone(c.getString(c.getColumnIndex("TELEFONE")));
            Endereco.setPontuacao(c.getDouble(c.getColumnIndex("PONTUACAO")));

            Endereco.add(endereco);
        }

        return endereco;


}
