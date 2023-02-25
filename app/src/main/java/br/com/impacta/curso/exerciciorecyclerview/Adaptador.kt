package br.com.impacta.curso.exerciciorecyclerview

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import br.com.impacta.curso.exerciciorecyclerview.databinding.RecyclerViewItemBinding

@RequiresApi(Build.VERSION_CODES.O)
class Adaptador(private val lista: ArrayList<Evento>): RecyclerView.Adapter<Adaptador.PontoFixacao>() {

    inner class PontoFixacao(val binding: RecyclerViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(evento: Evento) {
            binding.tituloTextview.text = evento.titulo
            binding.descricaoTextview.text = evento.descricao
            binding.dataTextview.text = evento.data.toString()
            binding.diaMesTextview.text = "${evento.data.dayOfMonth}\n${evento.data.month.toString()}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PontoFixacao {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewItemBinding.inflate(inflater, parent, false)
        return PontoFixacao(binding)
    }

    override fun onBindViewHolder(holder: PontoFixacao, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount(): Int = lista.size
}