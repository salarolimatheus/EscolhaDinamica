# EscolhaDinamica
![Badge Desenvolvido](http://img.shields.io/static/v1?label=STATUS&message=DESENVOLVIDO&color=GREEN&style=for-the-badge)

[![](https://jitpack.io/v/salarolimatheus/EscolhaDinamica.svg)](https://jitpack.io/#salarolimatheus/EscolhaDinamica)

Módulo de visualização dinâmica para aplicativos Android

## 💡 Motivo
Visualização e modificação dinâmica de um valor numérico respeitando o sistema internacional de unidades.

Algumas vezes, telas para inserção de paramêtros são necessárias. 
Com o tempo, percebe-se um gasto grande de tempo para mudanças pequenas ou muito grandes no valor (campo). Por isso, eu utilizei a biblioteca androidWheelView para desenvolver uma roleta que possibilita a modificação de cada número separadamente, uma mudança nas grandezas e multiplicações por 10 e 0.1. 

De maneira geral, o tempo médio gasto considerando todos os tipos de mudança de valor é menor que de um campo de texto com um valor a ser inserido.

## 📱 Visualização

## 🛠️ Como funciona

Para adicionar o objeto no XML, basta utilizar a seguinte estrutura:
```
  <sorocaba.peteca.com.dinamicparam.DinamicParam
    android:id="@+id/dinamic"
    android:layout_width="230dp"
    android:layout_height="120dp">
  </sorocaba.peteca.com.dinamicparam.DinamicParam>
```

Na parte do código em Java:
```
dinamicParam = findViewById(R.id.dinamic);
dinamicParam.carregar(valor[0], simb);
dinamicParam.setTextSize(18f);
dinamicParam.setTextColor(Color.rgb(0,0,255));
double valorSE = dinamicParam.pegarValorSE();
double valorReal = dinamicParam.pegarValor();
String grandeza = dinamicParam.pegarGrandeza();
```

## 📁 Créditos

Eu utilizei a biblioteca [androidWheelView](https://github.com/weidongjian/androidWheelView) do usuário [weidongjian](https://github.com/weidongjian)
