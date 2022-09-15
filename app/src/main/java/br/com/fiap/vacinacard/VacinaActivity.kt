package br.com.fiap.vacinacard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.vacinacard.adapter.RecyclerViewAdapter
import br.com.fiap.vacinacard.data.DataBaseManager
import br.com.fiap.vacinacard.model.Vacina

class VacinaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vacina)

        supportActionBar!!.hide()

        var email: String? = intent.getStringExtra("email")
        var db = DataBaseManager(this, "usuarios")
        var usuario = db.findUserById(email!!)

        // relativo ao nome do usuário
        var nome: String? = usuario!!.nome
        var txvNome: TextView = findViewById(R.id.txv_nome)
        txvNome.text = "Olá, $nome!"

        var vacina : Vacina = Vacina("BCG", "1998", "2098")
        var vacinas: MutableList<Vacina>? = null
        vacinas!!.add(vacina)
        usuario.vacinas = vacinas

        var recyclerView = findViewById<RecyclerView>(R.id.recycler_view_vacina)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val adapterVacina = RecyclerViewAdapter(this, usuario.vacinas!!)
        recyclerView.adapter = adapterVacina

        val btnHome = findViewById<Button>(R.id.btn_home)
        val btnVacinas = findViewById<Button>(R.id.btn_vacinas)
        val btnPerfil = findViewById<Button>(R.id.btn_perfil)

        btnHome.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            i.putExtra("email", usuario.email)
            startActivity(i)
        }

        btnPerfil.setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            i.putExtra("email", usuario.email)
            startActivity(i)
        }

        btnVacinas.setOnClickListener {
            val i = Intent(this, VacinaActivity::class.java)
            i.putExtra("email", usuario.email)
            startActivity(i)
        }
    }
}
