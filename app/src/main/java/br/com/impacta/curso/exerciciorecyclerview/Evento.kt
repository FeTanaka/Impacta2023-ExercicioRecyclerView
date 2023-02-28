package br.com.impacta.curso.exerciciorecyclerview

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

data class Evento(
    val titulo: String,
    val descricao: String,
    val data: LocalDateTime
) {
    fun getDataString() = this.data.toString()

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDiaMes() = "${this.data.dayOfMonth}\n${this.data.month}"

}
