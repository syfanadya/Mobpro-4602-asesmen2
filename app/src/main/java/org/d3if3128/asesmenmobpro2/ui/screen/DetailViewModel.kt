package org.d3if3128.asesmenmobpro2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3128.asesmenmobpro2.database.PeminjamanDao
import org.d3if3128.asesmenmobpro2.model.Peminjaman
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val dao: PeminjamanDao) : ViewModel() {
    private val formatter =SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(nama: String, nim: String, nohp: String, judulbuku: String, status: String, tanggalkembali: String){
        val peminjaman = Peminjaman(
            nama = nama,
            nim = nim,
            nohp = nohp,
            judulbuku = judulbuku,
            status = status,
            tanggalpinjam = formatter.format(Date()),
            tanggalkembali = tanggalkembali
        )

        viewModelScope.launch(Dispatchers.IO){
            dao.insert(peminjaman)
        }
    }

//    fun getPeminjaman(id: Long): Peminjaman? {
//        return mainViewModel.data.find { it.id == id }
//    }
}