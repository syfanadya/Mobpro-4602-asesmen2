package org.d3if3128.asesmenmobpro2.model

data class Peminjaman(
    val id: Long,
    val nama: String,
    val nim: String,
    val nohp: String,
    val judulbuku: String,
    val status: String,
    val tanggalpinjam: String,
    val tanggalkembali: String
)
