package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String num1;
    String num2;
    String operacion="";
    //int menos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clear(){
        View v=findViewById(R.id.display);
        TextView display=(TextView)v;
        display.setText("");
    }
    public void reset(){
        //Reset de los numeros y operacion
        View v=findViewById(R.id.display);
        TextView display=(TextView)v;
        display.setText("");
        num1 = "" ;
        num2 = "";
        operacion = "";
    }

    public void miclicknum(View view){
        //obtiene el valor del boton presionado y lo convierte a string
        Button boton=(Button)view;
        String digito=boton.getText().toString();
        //declaramos el textview
        View v=findViewById(R.id.display);
        TextView display=(TextView)v;
        //concatenamos el digito en el textview
        display.append(digito);
    }

    public void miclick(View view){
        switch (view.getId()){
            case R.id.buttonborrar:
                reset();
                break;
            case R.id.buttonsuma:
                TextView v=findViewById(R.id.display);
                String display=v.getText().toString();
                num1 = display;
                operacion="suma";
                clear();
                break;
            case R.id.buttonrestar:
                TextView x=findViewById(R.id.display);
                String displa=x.getText().toString();
                num1 = displa;
                operacion="resta";
                clear();
                break;
            case R.id.buttondividir:
                TextView y=findViewById(R.id.display);
                String displ=y.getText().toString();
                num1 = displ;
                operacion="division";
                clear();
                break;
            case R.id.buttonmult:
                TextView z=findViewById(R.id.display);
                String disp=z.getText().toString();
                num1 = disp;
                operacion="mult";
                clear();
                break;
            case R.id.buttonmasmenos:
                /*View a=findViewById(R.id.display);
                TextView dis=(TextView)a;
                if (menos == 0){

                }
                else {

                }*/
                break;
            case R.id.buttonigual:
                TextView b=findViewById(R.id.display);
                String dis=b.getText().toString();
                num2=dis;
                //TextView abc = (TextView)b;
                //abc.setText(dis);
                resolver();
                break;
        }
    }
    public void resolver(){
        //poner las operaciones y reset del display
        double res =0;
        double numA=Double.parseDouble(num1);
        double numB=Double.parseDouble(num2);
        switch (operacion) {
            case "suma":
                res = numA + numB;
                break;
            case "resta":
                res = numA - numB;
                break;
            case "division":
                res = numA / numB;
                break;
            case "mult":
                res = numA * numB;
                break;
        }
        reset();
        View v=findViewById(R.id.display);
        TextView display=(TextView)v;
        String str = String.valueOf(res);
        display.setText(str);

    }
}
