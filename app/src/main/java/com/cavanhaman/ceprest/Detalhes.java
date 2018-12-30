package com.cavanhaman.ceprest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.cavanhaman.ceprest.db.DB;
import com.cavanhaman.ceprest.model.CEP;
import com.mulataporno.ceprest.R;

/**
 * Created by Digitador01 on 21/11/2015.
 * Edited by CavanhaMan on 29/12/2018.
 * */
public class Detalhes extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        Intent intent = getIntent();

        TextView txtCep = (TextView) findViewById(R.id.txtDT_cep);
        TextView txtLogradouro = (TextView) findViewById(R.id.txtDT_logradouro);
        TextView txtComplemento = (TextView) findViewById(R.id.txtDT_complemento);
        TextView txtBairro = (TextView) findViewById(R.id.txtDT_bairro);
        TextView txtLocalidade = (TextView) findViewById(R.id.txtDT_localidade);
        TextView txtEstado = (TextView) findViewById(R.id.txtDT_estado);
        TextView txtibge = (TextView) findViewById(R.id.txtDT_ibge);

        if(intent != null){
            Bundle paramns = intent.getExtras();
            String itemId = paramns.getString("itemId");

            if(paramns != null){
                DB db = new DB(Detalhes.this);

                CEP cep = db.getSingleCep(Integer.parseInt(itemId));
                txtCep.setText(cep.getCep());
                txtLogradouro.setText(cep.getLogradouro());
                txtComplemento.setText(cep.getComplemento());
                txtBairro.setText(cep.getBairro());
                txtLocalidade.setText(cep.getLocalidade());
                txtEstado.setText(cep.getUf());
                txtibge.setText(cep.getIbge());
            }
        }

    }
}
