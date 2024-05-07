package org.d3if3128.asesmenmobpro2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3128.asesmenmobpro2.database.PeminjamanDao
import org.d3if3128.asesmenmobpro2.model.Peminjaman

class MainViewModel (dao: PeminjamanDao): ViewModel() {

    val data: StateFlow<List<Peminjaman>> = dao.getPeminjaman().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(0L),
        initialValue = emptyList()
    )

}