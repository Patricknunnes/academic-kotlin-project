package br.com.fiap.vacinacard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.vacinacard.data.DataBaseManager
import br.com.fiap.vacinacard.model.Vacina

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        supportActionBar!!.hide()

        val edtEmail: EditText = findViewById(R.id.edt_email)
        val edtPassword: EditText = findViewById(R.id.edt_password)
        val edtNome: EditText = findViewById(R.id.edt_nome)
        val btnRegistro: Button = findViewById(R.id.btn_registrar)

        btnRegistro.setOnClickListener {
            val db = DataBaseManager(this, "usuarios")
            val usuario = db.findUserById(edtEmail.text.toString())

            if(!edtEmail.text.toString().equals(usuario?.email)) {
                db.insertUser(
                    edtEmail.text.toString(),
                    edtPassword.text.toString(),
                    edtNome.text.toString(),
                )
                Toast.makeText(this, "Registrado!", Toast.LENGTH_SHORT).show()
                val i = Intent(this, HomeActivity::class.java)
                i.putExtra("nome", edtNome.text.toString())
                startActivity(i)
            } else {
                Toast.makeText(this, "Email já registrado!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}