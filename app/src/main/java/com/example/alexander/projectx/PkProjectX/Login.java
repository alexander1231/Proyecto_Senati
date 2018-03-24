package com.example.alexander.projectx.PkProjectX;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alexander.projectx.R;

public class Login extends AppCompatActivity {

    private Button btnacep;
    private EditText txtUsuario,txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnacep = (Button) findViewById(R.id.btnAceptar);
        txtUsuario = (EditText) findViewById(R.id.txtUsuario);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
    }

    public void  Onclick_BtnAcepar(View v){
        String usuario = txtUsuario.getText().toString();
        String password = txtPassword.getText().toString();

        if (usuario.equals("Alexander") && password.equals("developer"))
            startActivity(new Intent(Login.this,MenuPrincipal.class));
        else
            Toast.makeText(this,"Error en el usuario o contraseña", Toast.LENGTH_SHORT).show();
    }
}
