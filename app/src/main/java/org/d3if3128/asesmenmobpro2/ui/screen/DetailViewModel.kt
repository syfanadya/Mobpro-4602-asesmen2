package org.d3if3128.asesmenmobpro2.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3128.asesmenmobpro2.database.PeminjamanDao
import org.d3if3128.asesmenmobpro2.model.Peminjaman

class DetailViewModel(private val dao: PeminjamanDao) : ViewModel() {

    fun insert(nama: String, nim: String, nohp: String, judulbuku: String, status: String, tanggalpinjam: String, tanggalkembali: String){
        val peminjaman = Peminjaman(
            nama = nama,
            nim = nim,
            nohp = nohp,
            judulbuku = judulbuku,
            status = status,
            tanggalpinjam = tanggalpinjam,
            tanggalkembali = tanggalkembali
        )

        viewModelScope.launch(Dispatchers.IO){
            dao.insert(peminjaman)
        }
    }

    suspend fun getPeminjaman(id: Long): Peminjaman?{
        return dao.getPeminjamanById(id)
    }


    fun update(id: Long, nama: String, nim: String, nohp: String, judulbuku: String, status: String, tanggalpinjam: String, tanggalkembali: String){
        val peminjaman = Peminjaman(
            id = id,
            nama = nama,
            nim = nim,
            nohp = nohp,
            judulbuku = judulbuku,
            status = status,
            tanggalpinjam = tanggalpinjam,
            tanggalkembali = tanggalkembali
        )
        viewModelScope.launch(Dispatchers.IO) {
            dao.update(peminjaman)
        }
    }

    fun delete(id: Long){
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}