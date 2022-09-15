package br.com.fiap.vacinacard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.vacinacard.R
import br.com.fiap.vacinacard.model.Vacina

class RecyclerViewAdapter( private val context: Context, private val vacinas: MutableList<Vacina>)
    : RecyclerView.Adapter<RecyclerViewAdapter.VacinaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VacinaViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.vacina_item, parent, false)
        return VacinaViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: VacinaViewHolder, position: Int) {
        holder.nome.text = vacinas[position].nome.toString()
        holder.anoDose.text = vacinas[position].anoDose.toString()
        holder.anoVencimento.text = vacinas[position].anoVencimento.toString()
    }

    override fun getItemCount(): Int = vacinas.size

    inner class VacinaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nome = itemView.findViewById<TextView>(R.id.txv_nome_vacina)
        val anoDose = itemView.findViewById<TextView>(R.id.txv_ano_dose)
        val anoVencimento = itemView.findViewById<TextView>(R.id.txv_vencimento)
    }
}