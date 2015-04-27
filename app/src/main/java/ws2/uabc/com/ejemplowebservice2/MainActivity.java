package ws2.uabc.com.ejemplowebservice2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.Wsdl2Code.WebServices.MiWebService1.IWsdl2CodeEvents;
import com.Wsdl2Code.WebServices.MiWebService1.MiWebService1;
import com.Wsdl2Code.WebServices.MiWebService1.datos_persona_entrada;
import com.Wsdl2Code.WebServices.MiWebService1.datos_persona_salidad;


public class MainActivity extends ActionBarActivity {

    private MiWebService1 miClienteWS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

    miClienteWS= new MiWebService1(new IWsdl2CodeEvents() {
        @Override
        public void Wsdl2CodeStartedRequest() {
        //Se llamada cuando inicia el request
            System.err.println("Inicio el Request");

        }

        @Override
        public void Wsdl2CodeFinished(String methodName, Object Data) {
            //Se llamada cuando finaliza
            System.err.println("Finalizo con respuesta del metodo:["+methodName+"]");
            //Obtengo la respuesta y le hago un cast
            datos_persona_salidad salida= (datos_persona_salidad) Data;
            //Si hay una respuesta se imprime el mensaje
            if(salida!=null){
                System.err.println("++++SALIDA: "+salida.mensaje);
            }

        }

        @Override
        public void Wsdl2CodeFinishedWithException(Exception ex) {
            //Se llamada cuando finaliza con error
            System.err.println("Finalizo con Error:["+ex.getMessage()+"]");

        }

        @Override
        public void Wsdl2CodeEndedRequest() {
            //Se llamada cuando finaliza el request

            System.err.println("Finalizo el Request");

        }
    });

        //Este metodo ejecuta en un hilo sin bloquear la interfaz grafica
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Se crea el objeto que se va enviar
                datos_persona_entrada entrada=new datos_persona_entrada();
                entrada.ano_nac=1987;
                entrada.email="rosendorsc@gmail.com";
                entrada.nombre="Odnesor Leafar Sosa Canales";
                entrada.telefono="526862032977";

                //Se envia el objeto entrada y se espera respuesta en el listener declara una lineas arriba.
                try {
                    miClienteWS.calculo_edadAsync(entrada);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
