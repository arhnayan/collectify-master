package com.example.antikasat

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlin.math.log

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        // Initialize Firebase Auth
        auth = Firebase.auth
        val login: TextView = findViewById(R.id.textView_login_now)
        login.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            finish()
        }
        val registerbutton: Button = findViewById(R.id.register_button)
        registerbutton.setOnClickListener {
            performSignUp()
        }

    }

    private fun performSignUp() {
        val email = findViewById<EditText>(R.id.email_edittext_register)
        val psw = findViewById<EditText>(R.id.password_edittext_register)
        if (email.text.isEmpty() || psw.text.isEmpty()) {
            Toast.makeText(this, "Please input valid info.", Toast.LENGTH_SHORT).show()
            return//burası boş geçilemez yapıyor girişi
        }
        val inputEmail = email.text.toString()//burası baştan aşağı kayıt olma bölümü
        val inputPassword = psw.text.toString()
        auth.createUserWithEmailAndPassword(inputEmail, inputPassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    Toast.makeText(
                        baseContext,
                        "Sign up succesful.",
                        Toast.LENGTH_SHORT,
                    ).show()

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(
                        baseContext,
                        "Sign up failed.",
                        Toast.LENGTH_SHORT,
                    ).show()

                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
            }

    }

}