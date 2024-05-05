package org.d3if3128.asesmenmobpro2.ui.screen

import androidx.lifecycle.ViewModel
import org.d3if3128.asesmenmobpro2.model.Peminjaman

class MainViewModel: ViewModel(){
    val data = getDataDummy()
    private fun getDataDummy(): List<Peminjaman>{
        val data = mutableListOf(
            Peminjaman(1, "Syfanadya Wening Adi", "6706223128", "081358008183",
                "Harry Potter 2020", "Sedang dipinjam","2024-02-15 12:34:56", "2024-02-22 12:34:56"),
            Peminjaman(2, "Chaeza Fauzyyah Inayah", "6706223056", "082344678900",
                "Dilan & Milea", "Sedang dipinjam","2024-02-16 11:34:56", "2024-02-23 11:34:56"),
            Peminjaman(3, "Feby Irmayana", "6706220079", "082444678900",
                "The Design Thinking Playbook", "Sedang dipinjam","2024-02-17 10:34:56", "2024-02-24 10:34:56"),
            Peminjaman(4, "Dyna Rosalina Pangaribuan", "6706223016", "082444679900",
                "Ensiklopedia Sains", "Sedang dipinjam","2024-02-18 10:34:56", "2024-02-25 10:34:56"),
            Peminjaman(5, "Mariana", "6706220079", "082444678900",
                "Finding Yourself in the Age of Distractions", "Sedang dipinjam","2024-02-19 10:34:56", "2024-02-26 10:34:56"),
        )
        return data
    }
}