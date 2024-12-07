package fes.aragon.practica_4_android

import android.graphics.Typeface
import android.view.Gravity
import com.google.android.material.snackbar.Snackbar
import android.view.View
import android.widget.TextView

fun crearSnackBar(root : View, texto : String, duracion : Int, colorSnackbar : Int, colorTexto : Int, accion : Unit?) : Snackbar {

    val snackbar = Snackbar.make(root, texto, duracion)

    snackbar.setTextColor(colorTexto)

    snackbar.setBackgroundTint(colorSnackbar)

    val snackbarView = snackbar.view

    val snackbarTextView = snackbarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)

    snackbarTextView.textAlignment = View.TEXT_ALIGNMENT_CENTER

    snackbarTextView.gravity = Gravity.CENTER

    snackbarTextView.setTypeface(null, Typeface.BOLD)

    snackbarTextView.textSize = 20.0f

    return snackbar

}