package mx.edu.utng.unidad2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    private EditText et1, et2;
    private TextView tv1;
    private RadioGroup myRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        tv1=(TextView)findViewById(R.id.tv1);
        myRadioGroup=(RadioGroup)findViewById(R.id.myRadioGroup);

    }

    public void resultado(View view) {
        try {
            float valor1=Integer.parseInt(et1.getText().toString());
            float valor2=Integer.parseInt(et2.getText().toString());
            float total= (float) 0.00;
            switch(myRadioGroup.getCheckedRadioButtonId())
            { case R.id.suma: total=valor1+valor2;
                break;
                case R.id.resta: total=valor1-valor2;
                break;
                case R.id.multi: total=valor1*valor2;
                break;
                case R.id.div: total=valor1/valor2;
                break;
            }
            tv1.setText("Resultado: "+ total);
        }
        catch(NumberFormatException e)
        { tv1.setText("Resultado: Faltan datos");
        }
        catch(ArithmeticException e)
        { tv1.setText("Resultado: Error en operación");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId(); // se obtiene el id de la opcion seleccionada
        String msg = "";
        switch (id) {
            case R.id.action_opcion1:
                msg = "Disfrute la practica";
                Uri webpage = Uri.parse("http://soda.ustadistancia.edu.co/enlinea/programacionmovil/calculadora_con_radiobutton_y_radiogroup.html");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
                break;
            case R.id.action_opcion2:
                msg = "Aprenda bien con julioprofe crack";
                Uri webpage1 = Uri.parse("https://www.youtube.com/user/julioprofe");
                Intent webIntent1 = new Intent(Intent.ACTION_VIEW, webpage1);
                startActivity(webIntent1);
                break;
            case R.id.action_salir:
                /*finish();*/
                Intent intentSalir = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(intentSalir);
                msg = "Hasta luego luca";
                break;
            default:
                super.onOptionsItemSelected(item);
        }
        Toast.makeText(MenuActivity.this, msg, Toast.LENGTH_LONG).show();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}