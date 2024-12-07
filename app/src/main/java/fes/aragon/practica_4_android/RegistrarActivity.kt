package fes.aragon.practica_4_android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class RegistrarActivity : AppCompatActivity() {

    private lateinit var campoUsuario : EditText

    private lateinit var campoPassword : EditText

    private lateinit var campoRepetirPassword : EditText

    private lateinit var botonConfirmar : Button

    private lateinit var auth : FirebaseAuth

    override fun onCreate(bundle : Bundle?) {

        super.onCreate(bundle)

        this.auth = Firebase.auth

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

            this.botonConfirmar.isEnabled = this.campoUsuario.text.isNotEmpty() &&
                    this.campoPassword.text.isNotEmpty() &&
                    (this.campoPassword.text.toString() == this.campoRepetirPassword.text.toString())

        }

        this.campoPassword.doAfterTextChanged { verificacion() }

        this.campoUsuario.doAfterTextChanged { verificacion() }

        this.campoRepetirPassword.doAfterTextChanged { verificacion() }

        this.botonConfirmar.setOnClickListener { procesarNuevoUsuario() }

    }

    private fun procesarNuevoUsuario() {

        val emailUsuario = this.campoUsuario.text.toString()

        val password = this.campoPassword.text.toString()

        this.auth.createUserWithEmailAndPassword(emailUsuario, password).addOnCompleteListener(this) {task ->

            if(task.isSuccessful) {

                Log.i("REGISTRO", "correcto")

                usuario = auth.currentUser!!

                val intent = Intent(this, PaginaPrincipalActivity::class.java)

                startActivity(intent)

                finish()

            }else{

                Log.i("Registro", "incorrecto")

                val snackbar = crearSnackBar(findViewById(R.id.contenido),
                    "Error al intentar crear el usuario",
                    Snackbar.LENGTH_LONG, ContextCompat.getColor(this, android.R.color.holo_red_dark),
                    ContextCompat.getColor(this, android.R.color.white), null)

                snackbar.show()

            }

        }

    }

}