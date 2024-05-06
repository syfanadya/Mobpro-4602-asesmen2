package org.d3if3128.asesmenmobpro2.ui.screen

import androidx.lifecycle.ViewModel
import org.d3if3128.asesmenmobpro2.model.Peminjaman

class DetailViewModel : ViewModel() {
    private val mainViewModel = MainViewModel()

    fun getPeminjaman(id: Long): Peminjaman? {
        return mainViewModel.data.find { it.id == id }
    }
}