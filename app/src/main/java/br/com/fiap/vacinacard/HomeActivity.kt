package br.com.fiap.vacinacard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity  : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar!!.hide()

        // relativo ao nome do usuário
        val nome: String? = intent.getStringExtra("nome")
        var txvNome: TextView = findViewById(R.id.txv_nome)
        txvNome.text = "Olá, $nome!"
    }
}
