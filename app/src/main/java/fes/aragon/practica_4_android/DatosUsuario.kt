package fes.aragon.practica_4_android

import com.google.firebase.auth.FirebaseUser

lateinit var usuario : FirebaseUser

fun getCorreoUsuario() : String {

    return usuario.email!!

}