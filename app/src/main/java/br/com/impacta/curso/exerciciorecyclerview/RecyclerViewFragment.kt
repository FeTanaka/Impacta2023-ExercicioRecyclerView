package br.com.impacta.curso.exerciciorecyclerview

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.impacta.curso.exerciciorecyclerview.databinding.FragmentRecyclerViewBinding
import java.time.LocalDateTime

@RequiresApi(Build.VERSION_CODES.O)
class RecyclerViewFragment : Fragment() {

    private var _binding: FragmentRecyclerViewBinding? = null
    private val binding get() = _binding!!
    private val listaEventos: ArrayList<Evento> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listaEventos.add(Evento("Evento 1", "Descricao 1", LocalDateTime.now()))
        listaEventos.add(Evento("Evento 2", "Descricao 2", LocalDateTime.now()))
        listaEventos.add(Evento("Evento 3", "Descricao 3", LocalDateTime.of(2023, 1,1, 10,20 )))

        val adaptador = Adaptador(listaEventos)
        binding.rv.adapter = adaptador
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
    }

}