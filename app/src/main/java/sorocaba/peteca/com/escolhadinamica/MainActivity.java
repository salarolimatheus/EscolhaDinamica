package sorocaba.peteca.com.escolhadinamica;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import sorocaba.peteca.com.dinamicparam.DinamicParam;

public class MainActivity extends AppCompatActivity implements DinamicParam.InterfaceTouch{
    DinamicParam dinamicParam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final double[] valor = {15};
        String simb = "W";

        dinamicParam = findViewById(R.id.dinamic);
        dinamicParam.carregar(valor[0], simb);
        dinamicParam.setTextSize(18f);
        dinamicParam.setTextColor(Color.rgb(0,0,255));
        dinamicParam.setInterfaceListener(this);
        double valorSE = dinamicParam.pegarValorSE();
        double valorReal = dinamicParam.pegarValor();
        String grandeza = dinamicParam.pegarGrandeza();

        Button button = findViewById(R.id.button);
        final Button button2 = findViewById(R.id.button2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor[0] = dinamicParam.pegarValorSE();
                Toast.makeText(MainActivity.this, valor[0] + " " + dinamicParam.pegarGrandeza(), Toast.LENGTH_LONG).show();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double valor = 539.0;
                String simb = "W";
                dinamicParam.carregar(valor, simb);
            }
        });
    }

    @Override
    public void fimDoTouch() {
        Toast.makeText(MainActivity.this, dinamicParam.pegarValor() + " " + dinamicParam.pegarGrandeza(), Toast.LENGTH_SHORT).show();
    }
}
