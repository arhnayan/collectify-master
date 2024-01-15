package com.example.antikasat

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class Login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
auth = Firebase.auth
        val register: TextView = findViewById(R.id.textView_register_now)
        register.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
            finish()
        }
        val loginbutton: Button = findViewById(R.id.login_button)
        loginbutton.setOnClickListener { performLogin() }
    }

    private fun performLogin() {
        val email = findViewById<EditText>(R.id.email_edittext_login)
        val psw = findViewById<EditText>(R.id.password_edittext_login)
        if (email.text.isEmpty() || psw.text.isEmpty()) {
            Toast.makeText(this, "Please input valid login info", Toast.LENGTH_SHORT).show()
            return

        }
        val emailinput = email.text.toString()
        val passwordinput = psw.text.toString()

        auth.signInWithEmailAndPassword(emailinput, passwordinput)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                    Toast.makeText(
                        baseContext,
                        "Giriş Başarılı.",
                        Toast.LENGTH_SHORT,
                    ).show()

                } else {
                    // If sign in fails, display a message to the user.

                    Toast.makeText(
                        baseContext,
                        "Login failed.",
                        Toast.LENGTH_SHORT,
                    ).show()

                }

            }
            .addOnFailureListener {
                Toast.makeText(this, "Error ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
    }
}