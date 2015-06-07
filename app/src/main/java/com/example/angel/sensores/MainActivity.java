package com.example.angel.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

//Implementar evento de Sensores
public class MainActivity extends ActionBarActivity implements SensorEventListener {

    //Declarar variables
    private TextView salida, val1, val2, val3, val4, val5, val6, val7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlazar variables con la vista
        salida = (TextView) findViewById(R.id.salida);
        val1 = (TextView) findViewById(R.id.val1);
        val2 = (TextView) findViewById(R.id.val2);
        val3 = (TextView) findViewById(R.id.val3);
        val4 = (TextView) findViewById(R.id.val4);
        val5 = (TextView) findViewById(R.id.val5);
        val6 = (TextView) findViewById(R.id.val6);
        val7 = (TextView) findViewById(R.id.val7);

        //Administrador de Sensores
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        //Agregar Sensores econtrados en el arreglo
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        //Muestra los sensores en la interfaz
        for (Sensor sensor: listaSensores){
            log(sensor.getName());
        }
    }

    //Metodo para iniciar Sensores
    public void iniciarSensores(){

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        //Sensor de orientacion
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
        if (!listaSensores.isEmpty()) {
            Sensor orientationSensor = listaSensores.get(0);
            sensorManager.registerListener(this, orientationSensor,
                    SensorManager.SENSOR_DELAY_UI);}

        //Sensor de acelerometro
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.registerListener(this, acelerometerSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}

        //Sensor de giroscopio
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);
        if (!listaSensores.isEmpty()) {
            Sensor giroscopioSensor = listaSensores.get(0);
            sensorManager.registerListener(this, giroscopioSensor,
                    SensorManager.SENSOR_DELAY_UI);}

        //Sensor de proxmidad
        listaSensores = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);
        if (!listaSensores.isEmpty()) {
            Sensor proximitySensor = listaSensores.get(0);
            sensorManager.registerListener(this, proximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}
    }

    //Metodo para detener Sensores
    public void detenerSensores(){

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(acelerometerSensor.TYPE_ORIENTATION));
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);
        if (!listaSensores.isEmpty()) {
            Sensor giroscopioSensor = listaSensores.get(0);
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(giroscopioSensor.TYPE_GYROSCOPE));
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(acelerometerSensor.TYPE_ACCELEROMETER));
        }

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);
        if (!listaSensores.isEmpty()) {
            Sensor proximitySensor = listaSensores.get(0);
            sensorManager.unregisterListener(this, sensorManager.getDefaultSensor(proximitySensor.TYPE_PROXIMITY));
        }
    }

    //Metodo para iniciar sensor de acelerometro
    public void iniciarACCELEROMETER(){

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.registerListener(this, acelerometerSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}
    }

    //Metodo para iniciar sensor de giroscopio
    public void iniciarGYROSCOPE(){

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);
        if (!listaSensores.isEmpty()) {
            Sensor giroscopioSensor = listaSensores.get(0);
            sensorManager.registerListener(this, giroscopioSensor,
                    SensorManager.SENSOR_DELAY_UI);}
    }

    //Metodo para limpiar sensores
    public void Limpiar(){

        val1.setText("");
        val2.setText("");
        val3.setText("");
        val4.setText("");
        val5.setText("");
        val6.setText("");
        val7.setText("");
    }

    //Evento de identificacion de cambio de estado de sensores
    @Override
    public void onSensorChanged(SensorEvent event) {

        synchronized (this){
            switch (event.sensor.getType()){
                case Sensor.TYPE_ORIENTATION:
                    break;
                case Sensor.TYPE_ACCELEROMETER:
                    val1.setText("Aceler\u00f3metro X: " + event.values[0]);
                    val2.setText("Aceler\u00f3metro Y: " + event.values[1]);
                    val3.setText("Aceler\u00f3metro Z: " + event.values[2]);
                    break;
                case Sensor.TYPE_GYROSCOPE:
                    val4.setText("Eje X: " + event.values[0]);
                    val5.setText("Eje Y: " + event.values[1]);
                    val6.setText("Eje Z: " + event.values[2]);
                    break;
                case Sensor.TYPE_PROXIMITY:
                    val7.setText("Proximidad: " + event.values[0]);
                    break;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    //Metodo para mostrar sensores identificados
    private void log (String string) {
        salida.append(string + "\n");
    }

    //Evento para pausar servicios
    @Override
    protected void onPause(){
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onPause();
    }

    //Evento para reestablecer servicios
    @Override
    protected void onRestart(){
        super.onRestart();

        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> listaSensores = sensorManager.getSensorList(Sensor.TYPE_ALL);

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
        if (!listaSensores.isEmpty()) {
            Sensor orientationSensor = listaSensores.get(0);
            sensorManager.registerListener(this, orientationSensor,
                    SensorManager.SENSOR_DELAY_UI);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);
        if (!listaSensores.isEmpty()) {
            Sensor acelerometerSensor = listaSensores.get(0);
            sensorManager.registerListener(this, acelerometerSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_GYROSCOPE);
        if (!listaSensores.isEmpty()) {
            Sensor giroscopioSensor = listaSensores.get(0);
            sensorManager.registerListener(this, giroscopioSensor,
                    SensorManager.SENSOR_DELAY_UI);}

        listaSensores = sensorManager.getSensorList(Sensor.TYPE_PROXIMITY);
        if (!listaSensores.isEmpty()) {
            Sensor proximitySensor = listaSensores.get(0);
            sensorManager.registerListener(this, proximitySensor,
                    SensorManager.SENSOR_DELAY_NORMAL);}
    }

    //Evento para detener servicios
    @Override
    protected void onStop() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onStop();
    }

    //Evento para destruir servicios y liberar recursos
    @Override
    protected void onDestroy() {
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.unregisterListener(this);
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //Menu para seleccionar opciones y activar metodos
        switch (item.getItemId()){
            case R.id.iniciar:
                iniciarSensores();
                return true;
            case R.id.acelerometer:
                iniciarACCELEROMETER();
                return true;
            case R.id.gyroscope:
                iniciarGYROSCOPE();
                return true;
            case R.id.detener:
                detenerSensores();
                return true;
            case R.id.limpiar:
                Limpiar();
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}
