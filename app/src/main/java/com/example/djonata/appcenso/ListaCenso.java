package com.example.djonata.appcenso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.djonata.appcenso.Modelo.Censo;

/**
 * Created by Djonata on 25/11/2016.
 */

    public class ListaCenso extends AppCompatActivity{

        private ListView listaCenso;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lista_censo);

    //capturando a referência o objeto ListView no design da tela da lista de Alunos
            listaCenso = (ListView) findViewById(R.id.lista_censo);
    //implementando o evento de click em um dos itens da lista de alunos da agenda
            listaCenso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
    //capturando o elemento aluno que foi clicado
           Censo censo = (Censo) listaCenso.getItemAtPosition(position);

    //iniciando uma intent que é a classe no android responsável pela chamada de uma outra tela no aplicação, ou até mesmo de aplicações externas. No android você sempre precisa enviar uma Intenção (Intent) para acessar alguma funcionalidade. E será sempre o sistema operacional que irá realizar essa chamada para as aplicações.
                    Intent intentVaiPtoFormulario = new Intent(ListaCenso.this, FormularioActivity.class);
                    //enviando para o formulário o aluno carregado para o objeto, quando ele foi clicado pelo usuário na lista da agenda.
                    intentVaiPtoFormulario.putExtra("censo", censo);
    //iniciando a chamada da Activity
                    startActivity(intentVaiPtoFormulario);
                }
            });
    //capturando o referência em tela para o botão de novo aluno
            Button novoCenso = (Button) findViewById(R.id.novo_censo);
    //implementando o evento de click do botão
            novoCenso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //realizando a criação da Intent para a chamada a tela do formulário
                    Intent vaiProFormulario = new Intent(ListaCenso.this, FormularioActivity.class);
    //iniciando a chamada. Repare que como foi realizado no método anterior, utilizando o putExtra(), nesse método isso não foi necessário porque é um cadastro novo, e não será necessário recuperar os dados do aluno
                    startActivity(vaiProFormulario);
                }
            });

            registerForContextMenu(listaCenso);
        }
    }

