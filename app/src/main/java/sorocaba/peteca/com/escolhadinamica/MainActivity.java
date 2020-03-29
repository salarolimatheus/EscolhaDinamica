package sorocaba.peteca.com.escolhadinamica;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import sorocaba.peteca.com.dinamicparam.DinamicParam;

public class MainActivity extends AppCompatActivity {
    DinamicParam dinamicParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         dinamicParam = findViewById(R.id.dinamic);
        final double[] valor = {15};
        String simb = "W";
        dinamicParam.carregar(valor[0], simb);
        dinamicParam.setTextSize(15f);
        dinamicParam.setTextColor(Color.rgb(0,0,255));

        Button button = findViewById(R.id.button);
        final Button button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor[0] = dinamicParam.pegarValorSE();
                Toast.makeText(MainActivity.this, Double.toString(valor[0]) + " " + dinamicParam.pegarGrandeza(), Toast.LENGTH_LONG).show();
            }
        });
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
