package sorocaba.peteca.com.dinamicparam;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class DinamicParam extends View {
    private float valorEsquerdoUm, valorEsquerdoDois, valorDireitoUm, valorDireitoDois;
    private float valorOficial;

    public DinamicParam(Context context) {
        super(context);
        init();
    }

    public DinamicParam(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public float getValorOficial() {
        return valorOficial;
    }
    public void setValorOficial(float valorOficial) {
        this.valorOficial = valorOficial;
    }
}
