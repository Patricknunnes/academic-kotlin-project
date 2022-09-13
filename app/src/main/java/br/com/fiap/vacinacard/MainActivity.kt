package br.com.fiap.vacinacard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.vacinacard.data.DataManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val btnEntrar: Button = findViewById(R.id.btn_entrar)
        val btnRegistrar: Button = findViewById(R.id.btn_registrar)
        val edtEmail: EditText = findViewById(R.id.edt_email)
        val edtPassword: EditText = findViewById(R.id.edt_password)

        btnEntrar.setOnClickListener {

            val db = DataManager(this, "usuarios")
            val usuario = db.findUserById(edtEmail.text.toString())

            if (edtEmail.text.toString().equals(usuario?.email) && edtPassword.text.toString()
                    .equals(usuario?.senha)
            ) {
                val i = Intent(this, HomeActivity::class.java)
                i.putExtra("nome", usuario?.nome)
                startActivity(i)
            } else {
                Toast.makeText(this, "Dados inválidos", Toast.LENGTH_SHORT).show()
            }
        }

        btnRegistrar.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
    }
}