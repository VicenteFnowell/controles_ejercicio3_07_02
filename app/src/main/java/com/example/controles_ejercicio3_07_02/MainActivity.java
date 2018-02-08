package com.example.controles_ejercicio3_07_02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etApellidos, etEdad;
    Spinner spProvincia;
    RadioGroup rgEstadocivil;
    CheckBox cbAceptarterminos;
    TextView tvNombre,tvApellido,tvProvincia,tvEstado,tvEdad;
    ArrayList<Usuarioregistrado> lista_usuarios = new ArrayList<Usuarioregistrado>();
    int indicelistausua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre=(EditText)findViewById(R.id.etnombre);
        etApellidos=(EditText)findViewById(R.id.etapellido);
        etEdad=(EditText)findViewById(R.id.etedad);
        spProvincia=(Spinner)findViewById(R.id.spprovincia);
        rgEstadocivil=(RadioGroup)findViewById(R.id.rgestcivil);
        cbAceptarterminos=(CheckBox)findViewById(R.id.cbterminos);
        tvNombre=(TextView)findViewById(R.id.tvnombre);
        tvApellido=(TextView)findViewById(R.id.tvapellido);
        tvEstado=(TextView)findViewById(R.id.tvestado);
        tvProvincia=(TextView)findViewById(R.id.tvprovincia);
        tvEdad=(TextView)findViewById(R.id.tvedad);

        //Rellenar Spinner

        String[] Provincias={"Selecciona","Almería","Cádiz","Córdoba","Granada","Huelva","Jaen","Málaga","Sevilla"};
        ArrayAdapter<String> adaptadorprovincias = new ArrayAdapter<String>(this,R.layout.item_spinner,Provincias);
        spProvincia.setAdapter(adaptadorprovincias);





    }//Fin OnCreate


    public void clickAceptar (View view) {
        String nombre = etNombre.getText().toString();
        String apellido=etApellidos.getText().toString();
        String spinnerprovincias=spProvincia.getSelectedItem().toString();
        String cajaedad = etEdad.getText().toString();
        int idEstado = rgEstadocivil.getCheckedRadioButtonId();


        boolean termaceptados=false;

        if(cbAceptarterminos.isChecked()){
            termaceptados=true;
        }

        if(termaceptados){

            if(nombre.equals("")|| apellido.equals("")||cajaedad.equals("")||spinnerprovincias.equals("Selecciona")||idEstado==-1){

                mostrarMensaje("Debes rellenar los campos obligatorios");

            }else{

                RadioButton rbCopia = (RadioButton)findViewById(idEstado);
                String estadocivil = rbCopia.getText().toString();
                int edad = Integer.parseInt(cajaedad);

               Usuarioregistrado ureg=new Usuarioregistrado(nombre,apellido,spinnerprovincias,estadocivil,edad);
               lista_usuarios.add(ureg);



               limpiarFormulario();

            }


        }else{

            mostrarMensaje("Debes aceptar los términos");


        }

    }


    public void clickBorrar (View view){
        limpiarFormulario();

    }

    public void botonatras(View view){
        if(indicelistausua>0) {
            indicelistausua--;
            cargarUsuario();
        }else{
            mostrarMensaje("Has llegado al principio");
        }

    }

    public void botonadelante(View view){
        if(indicelistausua<lista_usuarios.size()-1){
            indicelistausua++;
            cargarUsuario();
        }else{

            //mostrarMensaje("Has llegado al final");
            indicelistausua=0;
            cargarUsuario();
        }


    }





    //Metodos propios


    private void limpiarFormulario (){
        etNombre.setText("");
        etApellidos.setText ("");
        etEdad.setText("");
        spProvincia.setSelection(0);
        rgEstadocivil.clearCheck();

    }



    private void mostrarMensaje (String mensaje){
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();

    }

    private void cargarUsuario (){
        Usuarioregistrado ureg = lista_usuarios.get(indicelistausua);
        tvNombre.setText("Nombre: "+ureg.getNombre());
        tvApellido.setText("Apellido: " +ureg.getApellido());
        tvEdad.setText("Edad: "+ureg.getEdad()+"");
        tvEstado.setText("Estado civil: " +ureg.getEstadociv());
        tvProvincia.setText("Provincia: " +ureg.getProvincia());


    }







}//Fin MainActivity
