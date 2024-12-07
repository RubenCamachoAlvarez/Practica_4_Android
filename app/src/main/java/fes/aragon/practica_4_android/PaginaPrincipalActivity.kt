package fes.aragon.practica_4_android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PaginaPrincipalActivity : AppCompatActivity() {

    private lateinit var etiquetaCorreoUsuario : TextView

    override fun onCreate(bundle : Bundle?) {

        super.onCreate(bundle)

        setContentView(R.layout.pagina_principal_activity)

        this.etiquetaCorreoUsuario = findViewById(R.id.correoUsuario)

        this.etiquetaCorreoUsuario.text = getCorreoUsuario()

    }

}