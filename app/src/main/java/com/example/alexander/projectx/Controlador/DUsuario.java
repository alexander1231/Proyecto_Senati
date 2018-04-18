package com.example.alexander.projectx.Controlador;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.example.alexander.projectx.Server.SOAPNET;
import com.example.alexander.projectx.modelo.Usuario;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class DUsuario implements INFPrincipal<Usuario>{


    private Context ct;
    private Activity at;
    //private SQLUsuario sqlu;
    //private AdapterListaUsuario adpu;


    public DUsuario(Context c, Activity a){
        this.ct = c;
        //this.sqlu = new SQLUsario(c);
        this.at = a;
        //this.adpu = AdapterListaUsuario(a);
    }

    @Override
    public void Add(Usuario obj) {

    }

    @Override
    public void Update(Usuario obj) {

    }

    @Override
    public void Delete(Object cod) {

    }

    @Override
    public List<Usuario> getList(Object f) {
        return null;
    }

    @Override
    public Usuario getItem(int f) {
        return null;
    }

    public Boolean getAcceso(String usu,String pas){
        try {
            String SOAPA = "http://tempuri.org/ISSesion/InciarSesion";
            String METODO = "InciarSesion";
            String NAMEWEB = "http://tempuri.org/";
            String URL = "http://192.168.43.14/ServicioWeb/Seguridad/SSesion.svc";
            String WSDL = URL + "?wsdl";

            SOAPNET ws = new SOAPNET(ct,SOAPA,METODO,NAMEWEB,URL,WSDL);
            Object[] [] dato = {{"Codigo",usu},{"Contraseña",pas}};
            ws.execute(dato);


            Toast.makeText(ct,"Acceso"+ws.get().toString(), Toast.LENGTH_LONG).show();

            return new Boolean(ws.get());

        } catch (Exception ex){Toast.makeText(ct,"Error:"+ex.getMessage(),Toast.LENGTH_LONG).show();}
        return false;

    }
}
