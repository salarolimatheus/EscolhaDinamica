package sorocaba.peteca.com.escolhadinamica;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import sorocaba.peteca.com.dinamicparam.DinamicParam;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DinamicParam dinamicParam = findViewById(R.id.dinamic);
        dinamicParam.post(new Runnable() {
            @Override
            public void run() {
                double valor = 49.179;
                String simb = "W";
                dinamicParam.carregar(valor, simb);
                dinamicParam.setTextSize(15f);
                dinamicParam.setTextColor(Color.rgb(0,0,255));
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //valor = dinamicParam.pegarValor();
                Toast.makeText(MainActivity.this, String.valueOf(dinamicParam.pegarValor()), Toast.LENGTH_LONG).show();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valor = 539.178;
                String simb = "V";
                //valor = dinamicParam.pegarValor();
                dinamicParam.carregar(valor, simb);
            }
        });
    }
}
