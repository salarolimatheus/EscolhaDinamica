package sorocaba.peteca.com.escolhadinamica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sorocaba.peteca.com.dinamicparam.DinamicParam;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    DinamicParam din;
}
