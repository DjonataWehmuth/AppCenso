package com.example.djonata.appcenso;

import android.widget.EditText;

import com.example.djonata.appcenso.Modelo.Censo;

/**
 * Created by Djonata on 25/11/2016.
 */

public class FormularioHelper {
    //propriedades correspondentes aos elementos que estão na tela do formulário de cadastro e alteração de dados
    private final EditText Chomens;
    private final EditText Cmulheres;
    private final EditText Ccriancas;
    private final EditText Cendereco;

    private Censo censo;

    public FormularioHelper(FormularioActivity activity) {
        Chomens = (EditText) activity.findViewById(R.id.edt_homens);
        Cmulheres = (EditText) activity.findViewById(R.id.edt_mulheres);
        Ccriancas = (EditText) activity.findViewById(R.id.edt_criancas);
        Cendereco = (EditText) activity.findViewById(R.id.edt_endereco);
        censo = new Censo();
    }

    public Censo Captura() {
        censo.setCriancas(Integer.parseInt(Chomens.getText().toString()));
        censo.setEndereco(Cendereco.getText().toString());
        censo.setHomens(Integer.parseInt(Chomens.getText().toString()));
        censo.setMulheres(Integer.parseInt(Cmulheres.getText().toString()));
        return censo;
    }

    public void preencheFormulario(Censo censo) {
        Cmulheres.setText(censo.getCriancas());
        Chomens.setText(censo.getHomens());
        Chomens.setText(censo.getCriancas());
        Cendereco.setText(censo.getEndereco());
        this.censo = censo;
    }
}