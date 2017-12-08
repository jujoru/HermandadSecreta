package es.luisgonzaga.hermandadsecreta;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaUsuariosActivity extends AppCompatActivity {

    ListView listaUsuario;
    DatabaseAdapter dba=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuarios);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        DeclararComponentes();
        RellenarListView();
    }

    private void DeclararComponentes(){

        listaUsuario = (ListView)findViewById(R.id.lv_usuarios);



    }

    private void RellenarListView(){

        dba=new DatabaseAdapter(getApplicationContext());
        ArrayList<Usuario> lista_usuarios = dba.ObtenerUsuarios();

        String[] from = {"Nombre","Estado"};
        int[] to = {android.R.id.text1, android.R.id.text2};

        List<Map<String, String>> data = new ArrayList<Map<String, String>>();

        for (int i=0; i<lista_usuarios.size(); i++){
            if(!lista_usuarios.get(i).getNombre().equals("admin")){
                Map<String, String> datum = new HashMap<String, String>();

                datum.put("Nombre", lista_usuarios.get(i).getNombre());
                datum.put("Estado",lista_usuarios.get(i).getEstado());

                data.add(datum);
            }
        }
        SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                from,
                to);
        listaUsuario.setAdapter(adapter);
    }
}
