package fes.aragon.practica_4_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged

class LoginActivity : AppCompatActivity() {

    private lateinit var campoUsuario : EditText

    private lateinit var campoPassword : EditText

    private lateinit var botonIniciarSesion : Button

    private lateinit var botonRegistro : Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.login_activity)

        this.recuperarComponentes()

        this.configurarComponentes()

    }

    private fun recuperarComponentes() {

        this.campoUsuario = findViewById(R.id.campoUsuario)

        this.campoPassword = findViewById(R.id.campoPassword)

        this.botonIniciarSesion = findViewById(R.id.botonIniciarSesion)

        this.botonRegistro = findViewById(R.id.botonRegistro)

    }

    private fun configurarComponentes() {

        val comprobacion = {

            this.botonIniciarSesion.isEnabled = this.campoPassword.text.isNotEmpty() && this.campoUsuario.text.isNotEmpty()

        }

        this.campoUsuario.doAfterTextChanged { comprobacion() }

        this.campoPassword.doAfterTextChanged { comprobacion() }

        this.botonIniciarSesion.setOnClickListener{



        }

        this.botonRegistro.setOnClickListener {

            val intent = Intent(this, RegistrarActivity::class.java)

            startActivity(intent)

        }

    }
}