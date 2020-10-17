package mx.tecnm.ladm_u2_tarea2_drivera

import kotlinx.android.synthetic.main.activity_main.*

class Hilo (p: MainActivity) : Thread() {

    var puntero = p
    var iniciado = false
    var pausa = false
    var reinicio = false

    override fun run() {
        super.run()

        iniciado = true

        while (iniciado){
            sleep(500)

            if (!pausa){

                puntero.runOnUiThread {
                    puntero.TeViContador.setText(puntero.contador.toString())
                }//runOnUiThread

                if (reinicio){
                    puntero.contador = 0
                    reinicio = false
                }

                puntero.contador++

            }//if-Pausa

        }//while

    }//overrideFunRun


    fun detener(){
        iniciado = false
    }//detener

    fun pausa (){
        pausa = true
    }//pausa

    fun despausar(){
        pausa = false
    }//despausar

    fun reiniciar (){
        reinicio = true
    }//reinicio

}//class