package thiagocury.eti.br.aulalistviewdinamica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Tela1 extends AppCompatActivity {

    //Widgets
    private EditText etNome;
    private EditText etIdade;
    private Button btnOK;
    //Lista
    private ListView lvPessoas;
    //Adapter
    private ArrayAdapter adapter;
    //Objeto
    private Pessoa p;
    //ArrayList
    private ArrayList<Pessoa> pessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        //Referencias
        etNome = (EditText) findViewById(R.id.t1_et_nome);
        etIdade = (EditText) findViewById(R.id.t1_et_idade);
        btnOK = (Button) findViewById(R.id.t1_btn_ok);
        lvPessoas = (ListView) findViewById(R.id.t1_lv_pessoas);

        //Instanciar ArrayList
        pessoas = new ArrayList<Pessoa>(); //aqui ele está vazio

        adapter = new ArrayAdapter<Pessoa>(
            Tela1.this,
            android.R.layout.simple_list_item_1,
            pessoas);
        //Setando o adapter na ListView
        lvPessoas.setAdapter(adapter);

        //Clique do botão
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p = new Pessoa();
                p.setNome(etNome.getText().toString());
                p.setIdade(
                    Integer.parseInt(etIdade.getText().toString()));

                //Inserindo objeto dentro do ArrayList
                pessoas.add(p);

                //Notificar o Adapter
                adapter.notifyDataSetChanged();

                Toast.makeText(
                        getBaseContext(),
                        "Pessoa cadastrada com sucesso!",
                        Toast.LENGTH_LONG).show();
            }//fecha classe
        });

        lvPessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Resgatando objeto                     //posição escolhida
                Pessoa p = (Pessoa) lvPessoas.getItemAtPosition(i);

                Toast.makeText(
                        getBaseContext(),
                        "Pessoa escolhida: "+p.toString(),
                        Toast.LENGTH_SHORT).show();
            }//fecha onitemclick
        });//fecha onitemclick

        lvPessoas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Removendo objeto pessoa!
                pessoas.remove(i);

                //Notificar o adapter
                adapter.notifyDataSetChanged();

                Toast.makeText(
                        getBaseContext(),
                        "Pessoa removida!",
                        Toast.LENGTH_SHORT).show();

                return true;
            }
        });

    }//fecha onCreate
}//fecha classe
