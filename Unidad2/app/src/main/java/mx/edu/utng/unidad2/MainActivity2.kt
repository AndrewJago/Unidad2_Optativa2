package mx.edu.utng.unidad2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btnIngresar = findViewById<View>(R.id.btnIngresar) as Button

        val texto = findViewById<View>(R.id.textView) as TextView

        //Se asocia el archivo de recursos de android
        val animacion = AnimationUtils.loadAnimation(
            this, R.anim.animacion
        )
        texto.startAnimation(animacion)
        btnIngresar.startAnimation(animacion)

        btnIngresar.setOnClickListener{
            val intentA = Intent(this, MenuActivity::class.java)
            startActivity(intentA)
        }
    }
}

