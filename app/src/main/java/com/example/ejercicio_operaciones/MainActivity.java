package com.example.ejercicio_operaciones;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ejercicio_operaciones.operaciones.OperacionesMat;
import com.example.operaciones.R;


public class MainActivity extends AppCompatActivity {
    EditText num1, num2;
    Button sumar, restar, multi, divi;

    String msj= "Operaciones";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        assignValues();

        sumar.setOnClickListener(this::onClickSumar);
        restar.setOnClickListener(this::onClickRestar);
        multi.setOnClickListener(this::onClickMulti);
        divi.setOnClickListener(this::onClickDivi);

    }

    protected void onClickSumar(View view){
        if(!emptyField(num1, num2)){
            OperacionesMat mt = new OperacionesMat (Integer.parseInt(num1.getText().toString()), Integer.parseInt(num2.getText().toString()));
            openActivity("RESULTADO:", mt.suma());
        }else message("Debe llenar los campos");
    }

    protected void onClickRestar(View view){
        if(!emptyField(num1, num2)) {
            OperacionesMat mt = new OperacionesMat(Integer.parseInt(num1.getText().toString()), Integer.parseInt(num2.getText().toString()));
            openActivity("RESULTADO:", mt.resta());
        }else message("Debe llenar los campos");
    }

    protected void onClickMulti(View view){
        if(!emptyField(num1, num2)) {
            OperacionesMat mt = new OperacionesMat(Integer.parseInt(num1.getText().toString()), Integer.parseInt(num2.getText().toString()));
            openActivity("RESULTADO:", mt.multiplicacion());
        }else message("Debe llenar los campos");
    }

    protected void onClickDivi(View view){
        if(!emptyField(num1, num2)) {
            OperacionesMat mt = new OperacionesMat(Integer.parseInt(num1.getText().toString()), Integer.parseInt(num2.getText().toString()));
            openActivity("RESULTADO:", mt.division());
        }else message("Debe llenar los campos");
    }





    protected void openActivity(String calculo, Double resultado){
        Intent panel = new Intent(getApplicationContext(), ActivityResultado.class);
        Bundle bnd = new Bundle();
        bnd.putDouble("resultado", resultado);
        bnd.putString("calculo", calculo);
        panel.putExtras(bnd);
        startActivity(panel);
    }

    private void assignValues(){
        num1 = findViewById(R.id.txtNum1);
        num2 = findViewById(R.id.txtNum2);
        sumar = findViewById(R.id.btnSum);
        restar = findViewById(R.id.btnRest);
        multi = findViewById(R.id.btnMulti);
        divi = findViewById(R.id.btnDivi);
    }

    protected boolean emptyField(EditText v1, EditText v2){
        if (v1.getText().toString().length() < 1 || v2.getText().toString().length() < 1) return true;
        else return false;
    }

    private void message(String msg){
        Toast.makeText(this, msg, LENGTH_SHORT).show();
    }


}