package br.com.fiap.vacinacard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.vacinacard.data.DataBaseManager

class HomeActivity  : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

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
        val btnNovaVacina = findViewById<Button>(R.id.btn_nova_vacina)

        btnHome.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java).apply {
                putExtra("email", usuario?.email)
            }
            startActivity(i)
        }

        btnPerfil.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            i.putExtra("email", usuario?.email)
            startActivity(i)
        }

        btnVacinas.setOnClickListener {
            val i = Intent(this, VacinaActivity::class.java)
            i.putExtra("email", usuario?.email)
            startActivity(i)
        }

        btnNovaVacina.setOnClickListener{
            val i = Intent(this, VacinaFormActivity::class.java)
            i.putExtra("email", usuario?.email)
            startActivity(i)
        }
    }
}
