package mx.tecnm.ladm_u2_tarea2_drivera

import android.media.session.MediaSession
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var contador = 0
    var hiloControl : Hilo?=null
    var detenido = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hiloControl = Hilo(this)

        btnIniciar.setOnClickListener {

            //si detenido == TRUE el hilo ya fue detenido y no se inicia por lo que se muestra el mensaje
            //si detenido == FALSE se revisa el estado del hilo...
            if (detenido){
                mensaje("El hilo no puede volver a iniciarse")
            }else{

                //Pregunta si el hilo se encuentra "Vivo", si se encuentra vivo se muestra el mensaje
                //si no se encuentra vivo, se inicia el hilo
                if(hiloControl?.isAlive!!){
                    mensaje("El hilo ya se encuentra activo")
                }else{
                    hiloControl?.start()
                    TeViEstado.setText("Iniciado")
                }//if-else --> isAlive
            }//if-else --> detenido

        }//btnIniciar


        btnDetener.setOnClickListener {

            hiloControl?.detener()
            TeViEstado.setText("Detenido")
            detenido = true

        }//btnDetener


        btnPausar.setOnClickListener {

            hiloControl?.pausa()
            TeViEstado.setText("Pausa")

        }//btnPausar


        btnDespausar.setOnClickListener {

            hiloControl?.despausar()
            TeViEstado.setText("Despausado-Iniciado")

        }//btnDespausar


        btnReiniciar.setOnClickListener {

            hiloControl?.reiniciar()

        }//btnReiniciar

    }//onCreate


    fun mensaje(cadena:String){
        Toast.makeText(this,cadena,Toast.LENGTH_LONG).show()
    }//mensaje

}//class