package sorocaba.peteca.com.dinamicparam;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.weigan.loopview.LoopView;

import java.util.ArrayList;

public class DinamicParam extends LinearLayout {

    private double valorAtual;
    private String simbolo;
    private TextView virgula;
    private TextView simbText;
    private TextView botaoMais;
    private TextView botaoMenos;

    private LoopView centena;
    private LoopView dezena;
    private LoopView unidade;
    private LoopView decimos;
    private LoopView centesimos;
    private LoopView milesimos;
    private LoopView grandeza;
    private boolean estado = true;
    private ArrayList<String> unidadesSI;

    private InterfaceTouch interfaceTouch;

    public void setInterfaceListener(InterfaceTouch interfaceTouch) {
        this.interfaceTouch = interfaceTouch;
    }

    public interface InterfaceTouch {
        void fimDoTouch();
    }

    public DinamicParam(Context context) {
        super(context);
        init();
    }

    public DinamicParam(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater  mInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(R.layout.layout_dinamicparam, this, true);

        centena = view.findViewById(R.id.loopView1);
        dezena = view.findViewById(R.id.loopView2);
        unidade = view.findViewById(R.id.loopView3);
        decimos = view.findViewById(R.id.loopView4);
        virgula = view.findViewById(R.id.virgula);
        centesimos = view.findViewById(R.id.loopView5);
        milesimos = view.findViewById(R.id.loopView6);
        grandeza = view.findViewById(R.id.loopView7);
        simbText = view.findViewById(R.id.simb);
        botaoMais = view.findViewById(R.id.botaoMais);
        botaoMenos = view.findViewById(R.id.botaoMenos);

        ArrayList<String> numeros = new ArrayList<>();
        for (int i = 9; i >= 0; i--) {numeros.add(String.valueOf(i));}
        unidadesSI = new ArrayList<>();
        unidadesSI.add("G"); unidadesSI.add("M"); unidadesSI.add("k"); unidadesSI.add(" ");
        unidadesSI.add("m"); unidadesSI.add("μ"); unidadesSI.add("p");

        centena.setItems(numeros); dezena.setItems(numeros); unidade.setItems(numeros);
        decimos.setItems(numeros); centesimos.setItems(numeros); milesimos.setItems(numeros);
        grandeza.setItems(unidadesSI);

        botaoMais.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                valorAtual = pegarValor();
                if (!((grandeza.getSelectedItem() == 0) && (centena.getSelectedItem() != 9))) {
                valorAtual *= 10;
                carregar(valorAtual, simbolo);
                }
            }
        });

        botaoMenos.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                valorAtual = pegarValor();
                if (!((grandeza.getSelectedItem() == 6) && (centena.getSelectedItem() == 9) && (dezena.getSelectedItem() == 9))) {
                    valorAtual *= 0.1;
                    carregar(valorAtual, simbolo);
                }
            }
        });
    }

    public void carregar(double valor, String simb) {
        valorAtual = valor;
        simbolo = simb;
        simbText.setText(simbolo);
        int exponencial = 0;

        if(valor >= 1000) {
            while(valor >= 1000) {
                exponencial += 1;
                valor /= 1000;
            }
        } else if ((valor < 1) && (valor != 0)){
            while (valor < 1) {//SE FOR ZERO TRAVA NO LOOPING
                exponencial -= 1;
                valor *= 1000;
            }
        } else {
            exponencial = 0;
        }

        unidade.setCurrentPosition((((int) (valor%10) + 1)*9)%10);
        valor *= 0.1;
        dezena.setCurrentPosition((((int) (valor%10) + 1)*9)%10);
        valor *= 0.1;
        centena.setCurrentPosition((((int) (valor%10) + 1)*9)%10);
        valor = 10*(100*valor - (int) (100*valor));
        decimos.setCurrentPosition((((int) (valor)+1)*9)%10);
        valor *= 10;
        centesimos.setCurrentPosition((((int) (valor)+1)*9)%10);
        valor *= 10;
        milesimos.setCurrentPosition((((int) (valor)+1)*9)%10);
        grandeza.setCurrentPosition(3-exponencial);
    }

    public double pegarValor() {
        valorAtual = (((centena.getSelectedItem()+1)*9)%10 * 100 + ((dezena.getSelectedItem()+1)*9)%10 * 10 + ((unidade.getSelectedItem()+1)*9)%10
                + ((decimos.getSelectedItem()+1)*9)%10 * 0.1 + ((centesimos.getSelectedItem()+1)*9)%10 * 0.01 + ((milesimos.getSelectedItem()+1)*9)%10 * 0.001)
                * Math.pow(10, (3-grandeza.getSelectedItem())*3);
        return valorAtual;
    }

    public double pegarValorSE() {
        valorAtual = (((centena.getSelectedItem()+1)*9)%10 * 100 + ((dezena.getSelectedItem()+1)*9)%10 * 10 + ((unidade.getSelectedItem()+1)*9)%10
                + ((decimos.getSelectedItem()+1)*9)%10 * 0.1 + ((centesimos.getSelectedItem()+1)*9)%10 * 0.01 + ((milesimos.getSelectedItem()+1)*9)%10 * 0.001);
        return valorAtual;
    }

    public String pegarGrandeza() {
        return (unidadesSI.get(grandeza.getSelectedItem()) + simbolo);
    }

    public void setTextSize(float size) {
        centena.setTextSize(size);
        dezena.setTextSize(size);
        unidade.setTextSize(size);
        decimos.setTextSize(size);
        virgula.setTextSize(size);
        centesimos.setTextSize(size);
        milesimos.setTextSize(size);
        grandeza.setTextSize(size);
        simbText.setTextSize(size);

        botaoMenos.setTextSize(size);
        botaoMais.setTextSize(size);
    }
    public void setTextColor(int color) {
        centena.setCenterTextColor(color);
        dezena.setCenterTextColor(color);
        unidade.setCenterTextColor(color);
        decimos.setCenterTextColor(color);
        virgula.setTextColor(color);
        centesimos.setCenterTextColor(color);
        milesimos.setCenterTextColor(color);
        grandeza.setCenterTextColor(color);
        simbText.setTextColor(color);
        botaoMais.setTextColor(color);
        botaoMenos.setTextColor(color);
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent event) {
//        if(!estado)
//            return true;
//
//        int action = event.getAction();
//        if ((action == MotionEvent.ACTION_UP) ||  (action == MotionEvent.ACTION_CANCEL)) {
//            if (interfaceTouch != null)
//                interfaceTouch.fimDoTouch();
//            return true;
//        }
//
//        return super.onInterceptTouchEvent(event);
//    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if(!estado)
            return true;

        int action = event.getAction();
        if ((action == MotionEvent.ACTION_UP) ||  (action == MotionEvent.ACTION_CANCEL)) {
            if (interfaceTouch != null)
                interfaceTouch.fimDoTouch();
            return true;
        }

        return super.dispatchTouchEvent(event);
    }
}
