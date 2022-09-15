package br.com.fiap.vacinacard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.vacinacard.data.DataBaseManager
import br.com.fiap.vacinacard.model.Usuario

class VacinaFormActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vacina_form)

        supportActionBar!!.hide()

        val email: String? = intent.getStringExtra("email")
        val db = DataBaseManager(this, "usuarios")
        val usuario = db.findUserById(email!!)

        // relativo ao nome do usuário
        val nome: String? = usuario!!.nome
        var txvNome: TextView = findViewById(R.id.txv_nome)
        txvNome.text = "Olá, $nome!"

        val btnHome = findViewById<Button>(R.id.btn_home)
        val btnVacinas = findViewById<Button>(R.id.btn_vacinas)
        val btnPerfil = findViewById<Button>(R.id.btn_perfil)
        val edtNomeVacina = findViewById<EditText>(R.id.edt_nome_vacina)
        val edtAnoDose = findViewById<EditText>(R.id.edt_nome_vacina)
        val edtAnoVencimento = findViewById<EditText>(R.id.edt_nome_vacina)



        btnHome.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            i.putExtra("email", usuario?.email)
            startActivity(i)
        }

        btnPerfil.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            i.putExtra("email", usuario?.email)
            startActivity(i)
        }

        btnVacinas.setOnClickListener {
            val vacinaIntent = Intent(this, VacinaActivity::class.java)
            vacinaIntent.putExtra("email", usuario?.email)
            startActivity(vacinaIntent)
        }
    }

}
