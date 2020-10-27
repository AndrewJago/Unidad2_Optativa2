package mx.edu.utng.unidad2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnResultado.setOnClickListener {
            if (etName.text.toString() != "" && etPass.text.toString() == "abc123") {
                val intent1 = Intent(this, MainActivity2::class.java)
                startActivity(intent1)
            } else
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_LONG).show()
        }

        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        val imageButton = findViewById<ImageButton>(R.id.imageButton)

        imageButton2.setOnClickListener {
            val webIntent: Intent =
                Uri.parse("https://www.facebook.com/profile.php?id=100009001431118")
                    .let { imageButton2 ->
                        Intent(Intent.ACTION_VIEW, imageButton2)
                    }
            startActivity(webIntent)
        }

        imageButton.setOnClickListener {
            val webIntent: Intent =
                Uri.parse("https://www.instagram.com/andrew_rzxd/")
                    .let { imageButton ->
                        Intent(Intent.ACTION_VIEW, imageButton)
                    }
            startActivity(webIntent)
        }
    }
}
