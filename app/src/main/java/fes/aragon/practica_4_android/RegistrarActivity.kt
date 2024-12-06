package fes.aragon.practica_4_android

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

class RegistrarActivity : AppCompatActivity() {

    private lateinit var campoUsuario : EditText

    private lateinit var campoPassword : EditText

    private lateinit var campoRepetirPassword : EditText

    private lateinit var botonConfirmar : Button

    override fun onCreate(bundle : Bundle?) {

        super.onCreate(bundle)

        setContentView(R.layout.registrar_activity)

        this.recuperarComponentes()

        this.configurarComponentes()

    }

    private fun recuperarComponentes() {

        this.campoUsuario = findViewById(R.id.campoUsuarioRegistro)

        this.campoPassword = findViewById(R.id.campoPasswordRegistro)

        this.campoRepetirPassword = findViewById(R.id.campoRepetirPasswordRegistro)

        this.botonConfirmar = findViewById(R.id.botonConfirmarRegistro)

    }

    private fun configurarComponentes() {

        val verificacion = {

            this.botonConfirmar.isEnabled = this.campoUsuario.text.isNotEmpty() && this.campoPassword.text.isNotEmpty() && (this.campoPassword.text.toString() == this.campoRepetirPassword.text.toString())

        }

        this.campoPassword.doAfterTextChanged { verificacion() }

        this.campoUsuario.doAfterTextChanged { verificacion() }

        this.campoRepetirPassword.doAfterTextChanged { verificacion() }

    }

}