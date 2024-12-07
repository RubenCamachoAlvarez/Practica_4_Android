package fes.aragon.practica_4_android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class LoginActivity : AppCompatActivity() {

    private lateinit var campoUsuario : EditText

    private lateinit var campoPassword : EditText

    private lateinit var botonIniciarSesion : Button

    private lateinit var botonRegistro : Button

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        this.auth = Firebase.auth

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

        this.botonIniciarSesion.setOnClickListener{ this.iniciarSesion() }

        this.botonRegistro.setOnClickListener {

            val intent = Intent(this, RegistrarActivity::class.java)

            startActivity(intent)

        }

    }

    private fun iniciarSesion() {

        val correoUsuario = this.campoUsuario.text.toString()

        val passwordUsuario = this.campoPassword.text.toString()

        this.auth.signInWithEmailAndPassword(correoUsuario, passwordUsuario).addOnCompleteListener(this) {task ->

            if(task.isSuccessful) {

                Log.i("INICIO SESION", "correcto")

                usuario = this.auth.currentUser!!

                val intent = Intent(this, PaginaPrincipalActivity::class.java)

                startActivity(intent)

                finish()

            }else{

                Log.i("INICION SESION", "incorrecto")

                val snackbar = crearSnackBar(findViewById(R.id.contenidoInicioSesion),
                    "Error al intentar iniciar sesion", Snackbar.LENGTH_LONG,
                    ContextCompat.getColor(this, android.R.color.holo_red_dark),
                    ContextCompat.getColor(this, android.R.color.white), null)

                snackbar.show()

            }

        }

    }
}