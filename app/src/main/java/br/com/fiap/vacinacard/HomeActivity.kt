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
            val homeIntent = Intent(this, HomeActivity::class.java).apply {
                putExtra("email", usuario?.email)
            }
            startActivity(homeIntent)
        }

        btnPerfil.setOnClickListener {
            val perfilIntent = Intent(this, PerfilActivity::class.java)
            perfilIntent.putExtra("email", usuario?.email)
            startActivity(perfilIntent)
        }

        btnVacinas.setOnClickListener {
            val vacinaIntent = Intent(this, VacinaActivity::class.java)
            vacinaIntent.putExtra("email", usuario?.email)
            startActivity(vacinaIntent)
        }

        btnNovaVacina.setOnClickListener{
            val vacinaFormIntent = Intent(this, VacinaFormActivity::class.java)
            vacinaFormIntent.putExtra("email", usuario?.email)
            startActivity(vacinaFormIntent)
        }
    }
}
