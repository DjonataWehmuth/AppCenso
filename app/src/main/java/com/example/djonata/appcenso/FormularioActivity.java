package com.example.djonata.appcenso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.djonata.appcenso.Dao.CensoDAO;
import com.example.djonata.appcenso.Modelo.Censo;

import java.util.Objects;

import static com.example.djonata.appcenso.R.id.btn_gravar;

/**
 * Created by Djonata on 25/11/2016.
 */

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;
    private Button btngravar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new FormularioHelper(this);

        Intent intent = getIntent();

        Censo censo = (Censo) intent.getSerializableExtra("censo");
        if (censo != null) {
            helper.preencheFormulario(censo);
        }
        btngravar = (Button) findViewById(R.id.btn_gravar);
        btngravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Censo censo = helper.Captura();

                CensoDAO dao = new CensoDAO(FormularioActivity.this);
                if (Integer.valueOf(censo.getID()) != null){
                    dao.altera(censo);
                }else{
                    dao.insere(censo);
                }
                dao.close();
                Toast.makeText(FormularioActivity.this, "Censo Salvo!",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    public boolean onCreateOptionMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case btn_gravar:
                Censo censo = helper.Captura();

                CensoDAO dao = new CensoDAO(this);
                if (Integer.valueOf(censo.getID()) != null){
                    dao.altera(censo);
                }else{
                    dao.insere(censo);
                }
                dao.close();
                Toast.makeText(FormularioActivity.this, "Censo Salvo!",
                        Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
