package com.losdistribuidos.turestaurante;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.servlet.SoapServlet;
import org.ksoap2.transport.HttpTransport;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.transport.HttpsTransportSE;

public class ReservaActivity extends AppCompatActivity {

    private EditText concepto, monto, usuario, dni, nro_tarjeta;
    private Button btnInvoke;
    private TextView confirm;
    String param1, param2, param3, param4, param5, mensaje;
    SoapPrimitive resultString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        concepto = (EditText) findViewById(R.id.et_concepto);
        monto = (EditText) findViewById(R.id.et_monto);
        usuario = (EditText) findViewById(R.id.et_usuario);
        dni = (EditText) findViewById(R.id.et_dni);
        nro_tarjeta = (EditText) findViewById(R.id.et_tarjeta);

        btnInvoke.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                param1 = concepto.getText().toString();
                param2 = monto.getText().toString();
                param3 = usuario.getText().toString();
                param4 = dni.getText().toString();
                param5 = nro_tarjeta.getText().toString();

                SegundoPlano tarea = new SegundoPlano();
                tarea.execute();
            }
        });
    }

    private class SegundoPlano extends AsyncTask<Void, Void,Void>{

        @Override
        protected void onPreExecute(){
        }

        @Override
        protected Void doInBackground(Void... voids) {
            convertir();
            return null;
        }

        @Override
        protected void onPostExecute(Void result){
            confirm.setText("Response: "+resultString.toString()+", "+mensaje);
        }
    }

    private void convertir(){
        String SOAP_ACTION = "http://jfloresninaco-001-site2.etempurl.com/PagoServices/PagoServicio";
        String METHOD_NAME = "PagoServicio";
        String NAMESPACE = "http://jfloresninaco-001-site2.etempurl.com/";
        String URL = "http://jfloresninaco-001-site2.etempurl.com/PagoServices/PagoServicio.svc?wsdl";

        try {
            SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);
            Request.addProperty("ConceptoPago", param1);
            Request.addProperty("MontoPagar", param2);
            Request.addProperty("NombreUsuario", param3);
            Request.addProperty("NumeroDNI", param4);
            Request.addProperty("NumeroTarjeta", param5);

            SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            soapEnvelope.dotNet = true;
            soapEnvelope.setOutputSoapObject(Request);

            HttpTransportSE transportSE = new HttpTransportSE(URL);
            transportSE.call(SOAP_ACTION, soapEnvelope);
            resultString = (SoapPrimitive) soapEnvelope.getResponse();

            mensaje = "OK";

        }catch (Exception ex){
            mensaje = "Error: "+ex.getMessage();
        }
    }
}
